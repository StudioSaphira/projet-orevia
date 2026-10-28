package net.orevia.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

/** Natural bauxite rock, harvested with a pickaxe. */
public final class Bauxite extends Block {

    public Bauxite() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    }
}
