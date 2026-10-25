package net.orevia.common.registry;

import net.minecraft.world.item.Item;

import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

public final class ModItems {

	private ModItems() {}

	public static PlatformRegistryObject<Item> BAUXITE;

	public static void register(PlatformRegistry registry) {
        BAUXITE = registry.registerBlockItem("bauxite", ModBlocks.BAUXITE);
	}
}
