package com.adamkerr.mccourse.block;

import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class RedstoneSlab extends SlabBlock {


    public RedstoneSlab(Properties properties) {
        super(properties.hardnessAndResistance(3f, 10f).sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE));
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        return 15;
    }
}