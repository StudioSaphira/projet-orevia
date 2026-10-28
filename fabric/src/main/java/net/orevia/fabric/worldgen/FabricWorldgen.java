package net.orevia.fabric.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.orevia.common.worldgen.MineralDeposit;
import net.orevia.common.worldgen.MineralVeinFeature;

/** Registers vanilla Orevia features and injects their placements into Fabric biomes. */
public final class FabricWorldgen {

    private FabricWorldgen() {}

    public static void register() {
        for (MineralDeposit deposit : MineralDeposit.values()) {
            Registry.register(BuiltInRegistries.FEATURE, deposit.location(), new MineralVeinFeature(deposit));
            var selector = deposit == MineralDeposit.BAUXITE
                    ? BiomeSelectors.tag(deposit.preferredBiomes())
                    : BiomeSelectors.tag(net.minecraft.tags.BiomeTags.IS_OVERWORLD);
            BiomeModifications.addFeature(selector, GenerationStep.Decoration.UNDERGROUND_ORES,
                    ResourceKey.create(Registries.PLACED_FEATURE, deposit.location()));
        }
    }
}
