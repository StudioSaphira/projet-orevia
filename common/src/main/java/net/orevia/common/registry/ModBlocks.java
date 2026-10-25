package net.orevia.common.registry;

import net.minecraft.world.level.block.Block;

import net.orevia.common.blocks.*;

import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

public final class ModBlocks {

	private ModBlocks() {}

	public static PlatformRegistryObject<Block> BAUXITE;

	public static void register(
			PlatformRegistry registry
	) {
		BAUXITE = registry.registerBlock("bauxite", Bauxite::new);
    }
}
