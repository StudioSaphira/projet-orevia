package net.orevia.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

/** Shared vanilla mining properties for stone and deepslate mineral deposits. */
public abstract class MineralOreBlock extends Block {

    protected MineralOreBlock(boolean deepslate, float hardness) {
        super(BlockBehaviour.Properties.ofFullCopy(
                deepslate ? Blocks.DEEPSLATE_IRON_ORE : Blocks.IRON_ORE
        ).strength(hardness + (deepslate ? 1.5f : 0.0f), 3.0f));
    }
}
