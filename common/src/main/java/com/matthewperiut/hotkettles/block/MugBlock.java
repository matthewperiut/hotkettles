package com.matthewperiut.hotkettles.block;

import com.matthewperiut.hotkettles.item.HotKettleItems;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

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

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        boolean hot = state.get(HOT);
        ItemStack stack = new ItemStack(state.getBlock().asItem());
        if (!hot) {
            if (stack.getItem().equals(HotKettleItems.HOT_WATER.get())) {
                stack = new ItemStack(HotKettleItems.CUP_OF_WATER.get());
            }
            if (stack.getItem().equals(HotKettleItems.HOT_CIDER.get())) {
                stack = new ItemStack(HotKettleItems.APPLE_CIDER.get());
            }
            if (stack.getItem().equals(HotKettleItems.HOT_COCOA.get())) {
                stack = new ItemStack(HotKettleItems.BITTER_WATER.get());
            }
            if (stack.getItem().equals(HotKettleItems.STEAMED_MILK.get())) {
                stack = new ItemStack(HotKettleItems.CUP_OF_MILK.get());
            }
        }
        world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack));
        return super.onBreak(world, pos, state, player);
    }
}
