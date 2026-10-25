package net.orevia.common.registry;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

@SuppressWarnings("CodeBlock2Expr")
public final class ModTabs {

	private ModTabs() {}

	public static PlatformRegistryObject<CreativeModeTab> ORE;

	public static void register(
			PlatformRegistry registry
	) {

		ORE =
				registry.registerCreativeModeTab(
						"ore",
						() -> registry.createCreativeModeTabBuilder()
								.title(
										Component.translatable(
												"item_group.orevia.building_blocks"
										)
								)
								.icon(
										() -> new ItemStack(
												ModItems.BAUXITE.get()
										)
								)
								.displayItems(
										(parameters, tabData) -> {
											tabData.accept(ModItems.BAUXITE.get());
										}
								)
								.withSearchBar()
				);
	}
}
