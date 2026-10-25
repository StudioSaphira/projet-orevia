package net.orevia.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.orevia.common.platform.PlatformServices;

import net.orevia.neoforge.platform.NeoForgePlatformServices;
import net.orevia.neoforge.platform.NeoForgePlatformRegistry;

@Mod("orevia")
public final class NeoForgeOrevia {

    public NeoForgeOrevia(IEventBus modEventBus) {
        PlatformServices.initialize(
                new NeoForgePlatformServices());
        NeoForgePlatformRegistry registry = new NeoForgePlatformRegistry(modEventBus);

        registry.register();
    }
}
