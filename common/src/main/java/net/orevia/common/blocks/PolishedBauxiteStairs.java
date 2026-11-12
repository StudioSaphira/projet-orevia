package net.orevia.common.blocks;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.orevia.common.registry.ModBlocks;

/** Bauxite building variant using vanilla placement, shapes and waterlogging. */
public final class PolishedBauxiteStairs extends StairBlock {

    public PolishedBauxiteStairs() {
        super(ModBlocks.POLISHEDBAUXITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(ModBlocks.POLISHEDBAUXITE.get()));
    }
}
