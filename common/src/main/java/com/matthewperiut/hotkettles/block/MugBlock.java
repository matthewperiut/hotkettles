package com.matthewperiut.hotkettles.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class MugBlock extends Block {
    public static final Property<Boolean> HOT = BooleanProperty.of("hot");
    public static final Property<Boolean> UPSIDE_DOWN = BooleanProperty.of("upside_down");

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(UPSIDE_DOWN);
        builder.add(HOT);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        boolean isSneaking = context.getPlayer().isSneaking();
        boolean hot = context.getStack().getDamage() == 1;

        return getDefaultState().with(UPSIDE_DOWN, isSneaking).with(HOT, hot);
    }

    public MugBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(HOT, false).with(UPSIDE_DOWN, true));
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
