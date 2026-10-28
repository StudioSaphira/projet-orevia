package net.orevia.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.orevia.common.constants.ModConstants;
import net.orevia.common.registry.ModRegistries;
import net.saphyra.neoforge.platform.NeoForgePlatformRegistry;

/** Registers Orevia content on its own event bus through Saphyra. */
@Mod(ModConstants.MOD_ID)
public final class NeoForgeOrevia {

    public NeoForgeOrevia(IEventBus modEventBus) {
        var registry = new NeoForgePlatformRegistry(ModConstants.MOD_ID, modEventBus);
        ModRegistries.register(registry);
        registry.register();
        net.orevia.neoforge.worldgen.NeoForgeWorldgen.register(modEventBus);
    }
}
