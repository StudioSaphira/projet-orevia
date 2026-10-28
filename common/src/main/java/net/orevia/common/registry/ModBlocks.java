package net.orevia.common.registry;

import net.minecraft.world.level.block.Block;
import net.orevia.common.blocks.Bauxite;
import net.orevia.common.blocks.NickelOre;
import net.orevia.common.blocks.ChromiteOre;
import net.orevia.common.blocks.PyrolusiteOre;
import net.orevia.common.blocks.CorundumOre;
import net.orevia.common.blocks.RawMineralBlock;
import net.orevia.common.blocks.NickelBlock;
import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

/** Registers Orevia mineral content through Saphyra. */
public final class ModBlocks {

    private ModBlocks() {}

    public static PlatformRegistryObject<Block> BAUXITE;
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
