package net.orevia.common.blocks;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.orevia.common.registry.ModBlocks;

/** Bauxite building variant using vanilla placement, shapes and waterlogging. */
public final class BauxiteSlab extends SlabBlock {

    public BauxiteSlab() {
        super(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BAUXITE.get()));
    }
}
