package net.orevia.common.blocks;

import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.orevia.common.registry.ModBlocks;

/** Bauxite building variant using vanilla placement, shapes and waterlogging. */
public final class BauxiteWall extends WallBlock {

    public BauxiteWall() {
        super(BlockBehaviour.Properties.ofFullCopy(ModBlocks.BAUXITE.get()));
    }
}
