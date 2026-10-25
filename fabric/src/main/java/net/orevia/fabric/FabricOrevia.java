package net.orevia.fabric;

import net.fabricmc.api.ModInitializer;
import net.orevia.common.constants.ModConstants;
import net.orevia.common.registry.ModRegistries;
import net.saphyra.fabric.platform.FabricPlatformRegistry;

/** Registers Orevia content through Saphyra on Fabric. */
public final class FabricOrevia implements ModInitializer {

    @Override
    public void onInitialize() {
        var registry = new FabricPlatformRegistry(ModConstants.MOD_ID);
        ModRegistries.register(registry);
        registry.register();
    }
}
