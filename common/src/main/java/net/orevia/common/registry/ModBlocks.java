package net.orevia.common.registry;

import net.minecraft.world.level.block.Block;
import net.orevia.common.blocks.*;
import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

/** Registers Orevia mineral content through Saphyra. */
public final class ModBlocks {

    private ModBlocks() {}

    public static PlatformRegistryObject<Block> BAUXITE;
    public static PlatformRegistryObject<Block> POLISHEDBAUXITE;
    public static PlatformRegistryObject<Block> BAUXITE_STAIRS;
    public static PlatformRegistryObject<Block> BAUXITE_SLAB;
    public static PlatformRegistryObject<Block> BAUXITE_WALL;
    public static PlatformRegistryObject<Block> POLISHED_BAUXITE_SLAB;
    public static PlatformRegistryObject<Block> POLISHED_BAUXITE_STAIRS;

    public static PlatformRegistryObject<Block> NICKEL_ORE;
    public static PlatformRegistryObject<Block> DEEPSLATE_NICKEL_ORE;
    public static PlatformRegistryObject<Block> CHROMITE_ORE;
    public static PlatformRegistryObject<Block> DEEPSLATE_CHROMITE_ORE;
    public static PlatformRegistryObject<Block> PYROLUSITE_ORE;
    public static PlatformRegistryObject<Block> DEEPSLATE_PYROLUSITE_ORE;
    public static PlatformRegistryObject<Block> CORUNDUM_ORE;
    public static PlatformRegistryObject<Block> DEEPSLATE_CORUNDUM_ORE;

    public static PlatformRegistryObject<Block> RAW_NICKEL_BLOCK;
    public static PlatformRegistryObject<Block> RAW_CHROMITE_BLOCK;
    public static PlatformRegistryObject<Block> RAW_PYROLUSITE_BLOCK;
    public static PlatformRegistryObject<Block> NICKEL_BLOCK;

    /** Declares content before the loader finalizes its registries. */
    public static void register(PlatformRegistry registry) {
        BAUXITE = registry.registerBlock("bauxite", Bauxite::new);
        POLISHEDBAUXITE = registry.registerBlock("polished_bauxite", PolishedBauxite::new);
        BAUXITE_STAIRS = registry.registerBlock("bauxite_stairs", BauxiteStairs::new);
        BAUXITE_SLAB = registry.registerBlock("bauxite_slab", BauxiteSlab::new);
        BAUXITE_WALL = registry.registerBlock("bauxite_wall", BauxiteWall::new);
        POLISHED_BAUXITE_SLAB = registry.registerBlock("polished_bauxite_slab", PolishedBauxiteSlab::new);
        POLISHED_BAUXITE_STAIRS = registry.registerBlock("polished_bauxite_stairs", PolishedBauxiteStairs::new);
        NICKEL_ORE = registry.registerBlock("nickel_ore", () -> new NickelOre(false));
        DEEPSLATE_NICKEL_ORE = registry.registerBlock("deepslate_nickel_ore", () -> new NickelOre(true));
        CHROMITE_ORE = registry.registerBlock("chromite_ore", () -> new ChromiteOre(false));
        DEEPSLATE_CHROMITE_ORE = registry.registerBlock("deepslate_chromite_ore", () -> new ChromiteOre(true));
        PYROLUSITE_ORE = registry.registerBlock("pyrolusite_ore", () -> new PyrolusiteOre(false));
        DEEPSLATE_PYROLUSITE_ORE = registry.registerBlock("deepslate_pyrolusite_ore", () -> new PyrolusiteOre(true));
        CORUNDUM_ORE = registry.registerBlock("corundum_ore", () -> new CorundumOre(false));
        DEEPSLATE_CORUNDUM_ORE = registry.registerBlock("deepslate_corundum_ore", () -> new CorundumOre(true));
        RAW_NICKEL_BLOCK = registry.registerBlock("raw_nickel_block", RawMineralBlock::new);
        RAW_CHROMITE_BLOCK = registry.registerBlock("raw_chromite_block", RawMineralBlock::new);
        RAW_PYROLUSITE_BLOCK = registry.registerBlock("raw_pyrolusite_block", RawMineralBlock::new);
        NICKEL_BLOCK = registry.registerBlock("nickel_block", NickelBlock::new);
    }
}
