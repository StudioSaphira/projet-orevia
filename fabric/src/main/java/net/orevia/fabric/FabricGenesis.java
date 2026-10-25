package net.orevia.fabric;

import net.fabricmc.api.ModInitializer;

import net.orevia.common.platform.PlatformServices;
import net.orevia.fabric.platform.FabricPlatformRegistry;
import net.orevia.fabric.platform.FabricPlatformServices;

@SuppressWarnings("unused")
public final class FabricGenesis implements ModInitializer {

    @Override
    public void onInitialize() {
        PlatformServices.initialize(
                new FabricPlatformServices());
        FabricPlatformRegistry registry = new FabricPlatformRegistry();
    }
}
