package com.matthewperiut.hotkettles.block;

import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import com.matthewperiut.hotkettles.item.KettleItem;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class KettleBlock extends BlockWithEntity {
    public static final IntProperty KETTLE_TYPE = IntProperty.of("kettle_type", 0, 6);

    // Kettles
    // 0: empty
    // 1: poison
    // 2: water
    // 3: milk
    // 4: bitter
    // 5: apple
    // 6: lava

    public KettleBlock(Settings settings) {
        super(settings.luminance((state) -> state.get(KETTLE_TYPE) == 6 ? 12 : 0));
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(KETTLE_TYPE, 0));
    }

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(KETTLE_TYPE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getHorizontalPlayerFacing();
        try {
            if (context.getStack().getItem() instanceof KettleItem kettleItem) {
                return getDefaultState().with(Properties.HORIZONTAL_FACING, direction).with(KETTLE_TYPE, kettleItem.kettle_type);
            }
        } catch (Exception ignored) {

        }
        return getDefaultState().with(Properties.HORIZONTAL_FACING, direction).with(KETTLE_TYPE, 0);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KettleBlockEntity(pos, state);
    }
//    for later versions
//    @Override
//    protected MapCodec<? extends Kettle> getCodec() {
//        return createCodec(Kettle::new);
//    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
//        // Make sure to check world.isClient if you only want to tick only on serverside.
//        return checkType(type, HotKettleBlockEntities.kettle_block_entity_type.get(), KettleBlockEntity::tick);
//        //for later versions:
//        //return validateTicker(type, ExampleMod.DEMO_BLOCK_ENTITY, DemoBlockEntity::tick);
//    }
}
