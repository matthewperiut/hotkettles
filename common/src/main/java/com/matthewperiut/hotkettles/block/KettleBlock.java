package com.matthewperiut.hotkettles.block;

import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import com.matthewperiut.hotkettles.item.KettleItem;
import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import static com.matthewperiut.hotkettles.components.HotKettleComponents.LIQUID_LEVEL_COMPONENT;

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
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return createCodec(KettleBlock::new);
    }

    @Override
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        builder.add(KETTLE_TYPE);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getHorizontalPlayerFacing().rotateClockwise(Direction.Axis.Y).rotateClockwise(Direction.Axis.Y);
        try {
            if (context.getStack().getItem() instanceof KettleItem kettleItem) {
                return getDefaultState().with(Properties.HORIZONTAL_FACING, direction).with(KETTLE_TYPE, kettleItem.kettle_type);
            }
        } catch (Exception ignored) {

        }
        return getDefaultState().with(Properties.HORIZONTAL_FACING, direction).with(KETTLE_TYPE, 0);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 1.0, 3.0, 13.0, 9.0, 13.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new KettleBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        // With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        int state_type = state.get(KETTLE_TYPE);
        for (RegistrySupplier<Item> kettle : HotKettleItems.kettles) {
            if (kettle.get() instanceof KettleItem k) {
                if (k.kettle_type == state_type) {
                    ItemStack stack = new ItemStack(k);
                    stack.set(LIQUID_LEVEL_COMPONENT.get(), ((KettleBlockEntity) world.getBlockEntity(pos)).liquidLevel);
                    world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack));
                    return super.onBreak(world, pos, state, player);
                }
            }
        }
        return super.onBreak(world, pos, state, player);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();

        if (stack.getItem() == Items.CACTUS) {
            return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 1, true);
        }
        if (stack.getItem() == Items.WATER_BUCKET) {
            return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 2, false);
        }
        if (stack.getItem() == Items.MILK_BUCKET) {
            return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 3, false);
        }
        if (stack.getItem() == Items.LAVA_BUCKET) {
            return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 6, false);
        }
        if (stack.getItem() == Items.BUCKET) {
            if (((KettleBlockEntity)world.getBlockEntity(pos)).liquidLevel == 5) {
                if (world.getBlockState(pos).get(KETTLE_TYPE) == 2) {
                    return takeKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_FILL, Items.WATER_BUCKET);
                } else if (world.getBlockState(pos).get(KETTLE_TYPE) == 3) {
                    return takeKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_FILL, Items.MILK_BUCKET);
                } else if (world.getBlockState(pos).get(KETTLE_TYPE) == 6) {
                    return takeKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_FILL, Items.LAVA_BUCKET);
                }
            }

            return takeKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_FILL, Items.BUCKET);
        }
        if (world.getBlockState(pos).get(KETTLE_TYPE) == 2) {
            if (stack.getItem() == Items.COCOA_BEANS) {
                return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 4, true);
            }
            else if (stack.getItem() == Items.APPLE) {
                return fillKettleLiquid(world, pos, player, stack, state, SoundEvents.ITEM_BUCKET_EMPTY, 5, true);
            }
        }

        // info
//        if (hand == Hand.MAIN_HAND) {
            if (!world.isClient) {
                if (stack.isEmpty()) {
                    if (state.get(KETTLE_TYPE) == 0) {
                        player.sendMessage(Text.of("Use water bucket, milk bucket, lava bucket, or cactus on kettle to fill."), false);
                    }
                    else if (state.get(KETTLE_TYPE) == 2) {
                        player.sendMessage(Text.of("Use cocoa beans or apple on the water kettle to brew new liquid."), false);
                    }
                    else {
                        if (world.getBlockEntity(pos) instanceof KettleBlockEntity kettle) {
                            if (!kettle.hot()) {
                                player.sendMessage(Text.of("Put fire, lava, or lit furnace under kettle to heat it up."), false);
                            } else {
                                player.sendMessage(Text.of("Collect liquid with an empty mug."), false);
                            }
                        }
                    }
                }
            }
//        }


        return super.onUse(state, world, pos, player, hit);
    }

    static ActionResult fillKettleLiquid(World world, BlockPos pos, PlayerEntity player, ItemStack stack, BlockState state, SoundEvent soundEvent, int nextKettleType, boolean decrement) {
        if (!world.isClient) {
            if (decrement) {
                player.getMainHandStack().decrement(1);
            } else {
                player.setStackInHand(Hand.MAIN_HAND, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
            }
            world.setBlockState(pos, state.with(KETTLE_TYPE, nextKettleType));
            world.playSound((PlayerEntity)null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent((Entity)null, GameEvent.FLUID_PLACE, pos);
            ((KettleBlockEntity)world.getBlockEntity(pos)).setLiquidLevel(5);
            ((KettleBlockEntity)world.getBlockEntity(pos)).setLiquidHorizontalOffset(nextKettleType*2);
        }
        return ActionResult.SUCCESS;
    }

    static ActionResult takeKettleLiquid(World world, BlockPos pos, PlayerEntity player, ItemStack stack, BlockState state, SoundEvent soundEvent, Item replaced) {
        if (!world.isClient) {
            player.setStackInHand(Hand.MAIN_HAND, ItemUsage.exchangeStack(stack, player, new ItemStack(replaced)));
            world.setBlockState(pos, state.with(KETTLE_TYPE, 0));
            world.playSound((PlayerEntity)null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent((Entity)null, GameEvent.FLUID_PICKUP, pos);
            ((KettleBlockEntity)world.getBlockEntity(pos)).setLiquidLevel(0);
            ((KettleBlockEntity)world.getBlockEntity(pos)).setLiquidHorizontalOffset(0);

        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        int state_type = state.get(KETTLE_TYPE);
        for (RegistrySupplier<Item> kettle : HotKettleItems.kettles) {
            if (kettle.get() instanceof KettleItem k) {
                if (k.kettle_type == state_type) {
                    ItemStack stack = new ItemStack(k);
                    stack.set(LIQUID_LEVEL_COMPONENT.get(), ((KettleBlockEntity) world.getBlockEntity(pos)).liquidLevel);
                    return stack;
                }
            }
        }
        return super.getPickStack(world, pos, state);
    }
}
