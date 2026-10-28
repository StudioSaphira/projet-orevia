package net.orevia.neoforge.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.orevia.common.worldgen.MineralDeposit;
import net.orevia.common.worldgen.MineralVeinFeature;

/** Registers shared features; biome injection is supplied by Orevia's data files. */
public final class NeoForgeWorldgen {

    private NeoForgeWorldgen() {}

    public static void register(IEventBus bus) {
        DeferredRegister<Feature<?>> features = DeferredRegister.create(Registries.FEATURE, "orevia");
        for (MineralDeposit deposit : MineralDeposit.values()) {
            features.register(deposit.id(), () -> new MineralVeinFeature(deposit));
        }
        features.register(bus);
    }
}
