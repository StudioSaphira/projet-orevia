package net.orevia.common.registry;

import net.minecraft.world.item.Item;
import net.orevia.common.items.RawMineralItem;
import net.orevia.common.items.NickelIngotItem;
import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

/** Registers Orevia mineral content through Saphyra. */
public final class ModItems {

    private ModItems() {}

    public static PlatformRegistryObject<Item> BAUXITE;
    public static PlatformRegistryObject<Item> NICKEL_ORE;
    public static PlatformRegistryObject<Item> DEEPSLATE_NICKEL_ORE;
    public static PlatformRegistryObject<Item> CHROMITE_ORE;
    public static PlatformRegistryObject<Item> DEEPSLATE_CHROMITE_ORE;
    public static PlatformRegistryObject<Item> PYROLUSITE_ORE;
    public static PlatformRegistryObject<Item> DEEPSLATE_PYROLUSITE_ORE;
    public static PlatformRegistryObject<Item> CORUNDUM_ORE;
    public static PlatformRegistryObject<Item> DEEPSLATE_CORUNDUM_ORE;

    public static PlatformRegistryObject<Item> RAW_NICKEL_BLOCK;
    public static PlatformRegistryObject<Item> RAW_CHROMITE_BLOCK;
    public static PlatformRegistryObject<Item> RAW_PYROLUSITE_BLOCK;
    public static PlatformRegistryObject<Item> NICKEL_BLOCK;
    public static PlatformRegistryObject<Item> RAW_NICKEL;
    public static PlatformRegistryObject<Item> RAW_CHROMITE;
    public static PlatformRegistryObject<Item> RAW_PYROLUSITE;
    public static PlatformRegistryObject<Item> RAW_CORUNDUM;
    public static PlatformRegistryObject<Item> NICKEL_INGOT;

    /** Declares content before the loader finalizes its registries. */
    public static void register(PlatformRegistry registry) {
        BAUXITE = registry.registerBlockItem("bauxite", ModBlocks.BAUXITE);
        NICKEL_ORE = registry.registerBlockItem("nickel_ore", ModBlocks.NICKEL_ORE);
        DEEPSLATE_NICKEL_ORE = registry.registerBlockItem("deepslate_nickel_ore", ModBlocks.DEEPSLATE_NICKEL_ORE);
        CHROMITE_ORE = registry.registerBlockItem("chromite_ore", ModBlocks.CHROMITE_ORE);
        DEEPSLATE_CHROMITE_ORE = registry.registerBlockItem("deepslate_chromite_ore", ModBlocks.DEEPSLATE_CHROMITE_ORE);
        PYROLUSITE_ORE = registry.registerBlockItem("pyrolusite_ore", ModBlocks.PYROLUSITE_ORE);
        DEEPSLATE_PYROLUSITE_ORE = registry.registerBlockItem("deepslate_pyrolusite_ore", ModBlocks.DEEPSLATE_PYROLUSITE_ORE);
        CORUNDUM_ORE = registry.registerBlockItem("corundum_ore", ModBlocks.CORUNDUM_ORE);
        DEEPSLATE_CORUNDUM_ORE = registry.registerBlockItem("deepslate_corundum_ore", ModBlocks.DEEPSLATE_CORUNDUM_ORE);
        RAW_NICKEL_BLOCK = registry.registerBlockItem("raw_nickel_block", ModBlocks.RAW_NICKEL_BLOCK);
        RAW_CHROMITE_BLOCK = registry.registerBlockItem("raw_chromite_block", ModBlocks.RAW_CHROMITE_BLOCK);
        RAW_PYROLUSITE_BLOCK = registry.registerBlockItem("raw_pyrolusite_block", ModBlocks.RAW_PYROLUSITE_BLOCK);
        NICKEL_BLOCK = registry.registerBlockItem("nickel_block", ModBlocks.NICKEL_BLOCK);
        RAW_NICKEL = registry.registerItem("raw_nickel", RawMineralItem::new);
        RAW_CHROMITE = registry.registerItem("raw_chromite", RawMineralItem::new);
        RAW_PYROLUSITE = registry.registerItem("raw_pyrolusite", RawMineralItem::new);
        RAW_CORUNDUM = registry.registerItem("raw_corundum", RawMineralItem::new);
        NICKEL_INGOT = registry.registerItem("nickel_ingot", NickelIngotItem::new);
    }
}
