package net.orevia.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

/** Refined storage block crafted from nine nickel ingots. */
public final class NickelBlock extends Block {

    public NickelBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    }
}
