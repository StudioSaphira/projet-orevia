package net.orevia.common.registry;

import net.saphyra.common.platform.PlatformRegistry;

/** Declares Orevia content in dependency order using Saphyra's active loader registry. */
public final class ModRegistries {

    private ModRegistries() {}

    /** Declares blocks before their items, and items before their creative tab. */
    public static void register(PlatformRegistry registry) {
        ModBlocks.register(registry);
        ModItems.register(registry);
        ModTabs.register(registry);
    }
}
