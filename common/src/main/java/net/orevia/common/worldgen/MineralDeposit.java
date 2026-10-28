package net.orevia.common.worldgen;

import java.util.function.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.orevia.common.registry.ModBlocks;

/** Mineral-specific vein bounds and deferred block references shared by both loaders. */
public enum MineralDeposit {

    BAUXITE("bauxite", 64, 160, 5, 12, () -> ModBlocks.BAUXITE.get(), () -> ModBlocks.BAUXITE.get()),
    NICKEL("nickel", -48, 48, 3, 8, () -> ModBlocks.NICKEL_ORE.get(), () -> ModBlocks.DEEPSLATE_NICKEL_ORE.get()),
    CHROMITE("chromite", -56, 0, 2, 5, () -> ModBlocks.CHROMITE_ORE.get(), () -> ModBlocks.DEEPSLATE_CHROMITE_ORE.get()),
    PYROLUSITE("pyrolusite", -32, 64, 4, 9, () -> ModBlocks.PYROLUSITE_ORE.get(), () -> ModBlocks.DEEPSLATE_PYROLUSITE_ORE.get()),
    CORUNDUM("corundum", -48, 30, 1, 3, () -> ModBlocks.CORUNDUM_ORE.get(), () -> ModBlocks.DEEPSLATE_CORUNDUM_ORE.get());

    private final String id;
    private final int minY;
    private final int maxY;
    private final int minSize;
    private final int maxSize;
    private final Supplier<Block> stone;
    private final Supplier<Block> deepslate;

    MineralDeposit(String id, int minY, int maxY, int minSize, int maxSize,
                   Supplier<Block> stone, Supplier<Block> deepslate) {
        this.id = id;
        this.minY = minY;
        this.maxY = maxY;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.stone = stone;
        this.deepslate = deepslate;
    }

    public String id() { return id; }

    public int minY() { return minY; }

    public int maxY() { return maxY; }

    public int minSize() { return minSize; }

    public int maxSize() { return maxSize; }

    public Block block(boolean deep) { return (deep ? deepslate : stone).get(); }

    public ResourceLocation location() {
        return ResourceLocation.fromNamespaceAndPath("orevia", id);
    }

    public TagKey<Biome> preferredBiomes() {
        return TagKey.create(Registries.BIOME,
                ResourceLocation.fromNamespaceAndPath("orevia", "preferred_" + id));
    }
}
