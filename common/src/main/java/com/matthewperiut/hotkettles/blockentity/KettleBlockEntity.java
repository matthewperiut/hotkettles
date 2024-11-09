package com.matthewperiut.hotkettles.blockentity;

import com.matthewperiut.hotkettles.block.KettleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class KettleBlockEntity extends BlockEntity {
    public boolean dirX = false;
    public int liquidHorizontalOffset = 0;
    public int liquidLevel = 2;

    public KettleBlockEntity(BlockPos pos, BlockState state) {
        super(HotKettleBlockEntities.kettle_block_entity_type.get(), pos, state);
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        if (dir == Direction.EAST || dir == Direction.WEST) {
            dirX = true;
        }
        if (state.get(KettleBlock.KETTLE_TYPE) == 0) {
            liquidLevel = 0;
        } else {
            liquidLevel = 5;
        }
        liquidHorizontalOffset = (state.get(KettleBlock.KETTLE_TYPE) * 2);
    }
}
