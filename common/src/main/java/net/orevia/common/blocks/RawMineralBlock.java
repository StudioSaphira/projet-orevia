package net.orevia.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

/** Reversible storage for nine raw minerals, with vanilla raw-metal block properties. */
public final class RawMineralBlock extends Block {

    public RawMineralBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK));
    }
}
