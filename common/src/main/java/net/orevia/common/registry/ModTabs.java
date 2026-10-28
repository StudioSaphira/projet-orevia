package net.orevia.common.registry;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;

import net.saphyra.common.platform.PlatformRegistry;
import net.saphyra.common.platform.PlatformRegistryObject;

/** Exposes Orevia ores, raw materials and refined nickel in progression order. */
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
											tabData.accept(ModItems.NICKEL_ORE.get());
											tabData.accept(ModItems.DEEPSLATE_NICKEL_ORE.get());
                                            tabData.accept(ModItems.RAW_NICKEL.get());
                                            tabData.accept(ModItems.RAW_NICKEL_BLOCK.get());
                                            tabData.accept(ModItems.NICKEL_INGOT.get());
                                            tabData.accept(ModItems.NICKEL_BLOCK.get());
											tabData.accept(ModItems.CHROMITE_ORE.get());
											tabData.accept(ModItems.DEEPSLATE_CHROMITE_ORE.get());
                                            tabData.accept(ModItems.RAW_CHROMITE.get());
                                            tabData.accept(ModItems.RAW_CHROMITE_BLOCK.get());
											tabData.accept(ModItems.PYROLUSITE_ORE.get());
											tabData.accept(ModItems.DEEPSLATE_PYROLUSITE_ORE.get());
                                            tabData.accept(ModItems.RAW_PYROLUSITE.get());
                                            tabData.accept(ModItems.RAW_PYROLUSITE_BLOCK.get());
											tabData.accept(ModItems.CORUNDUM_ORE.get());
											tabData.accept(ModItems.DEEPSLATE_CORUNDUM_ORE.get());
                                            tabData.accept(ModItems.RAW_CORUNDUM.get());
										}
								)
								.withSearchBar()
				);
	}
}
