package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.block.KettleBlock;
import com.matthewperiut.hotkettles.block.MugBlock;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.matthewperiut.hotkettles.util.HotKettleComponents.HOT_DRINK_COMPONENT;

public class MugItem extends BlockItem {

    public MugItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        boolean hot = stack.contains(HOT_DRINK_COMPONENT);
        if (hot) {
            return super.getTranslationKey() + "_hot";
        } else {
            return super.getTranslationKey();
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return super.use(world, user, hand);
    }

    public ActionResult place(ItemPlacementContext context) {
        ItemStack stack = context.getStack().copy();
        ActionResult result = super.place(context);
        if (result == ActionResult.CONSUME) {
            if (stack.contains(HOT_DRINK_COMPONENT)) {
                context.getWorld().setBlockState(
                        context.getBlockPos(),
                        context.getWorld().getBlockState(context.getBlockPos()).with(MugBlock.HOT, true)
                );
            }
        }
        return result;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public SoundEvent getDrinkSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            if (getTranslationKey().contains("lava")) {
                user.setOnFireFromLava();
            }
            if (getTranslationKey().contains("milk")) {
                user.clearStatusEffects();
            }
        }

        if (stack.isEmpty()) {
            return new ItemStack(HotKettleItems.empty_mug.get());
        } else {
            if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
                ItemStack itemStack = new ItemStack(HotKettleItems.empty_mug.get());
                PlayerEntity playerEntity = (PlayerEntity)user;
                if (!playerEntity.getInventory().insertStack(itemStack)) {
                    playerEntity.dropItem(itemStack, false);
                }
            }

            return stack;
        }
    }
/*
    @Override
    public boolean isFood() {
        return true;
    }

    @Override
    public @Nullable FoodComponent getFoodComponent() {
        String currentItem = getTranslationKey();

        if (HotKettles.hot_workaround) {
            if (!currentItem.contains("_hot")) {
                currentItem += "_hot";
            }
        } else {
            currentItem = currentItem.replace("_hot", "");
        }

        switch (currentItem)
        {
            case "block.hotkettles.cup_of_water":       
                return HotKettleFoodComponents.CUP_OF_WATER;

            case "block.hotkettles.cup_of_water_hot":   
                return HotKettleFoodComponents.HOT_WATER;

            case "block.hotkettles.cup_of_milk":        
                return HotKettleFoodComponents.CUP_OF_MILK;

            case "block.hotkettles.cup_of_milk_hot":    
                return HotKettleFoodComponents.STEAMED_MILK;

            case "block.hotkettles.cup_of_lava":        
                return HotKettleFoodComponents.CUP_OF_LAVA;

            case "block.hotkettles.poison":             
                return HotKettleFoodComponents.POISON;

            case "block.hotkettles.apple_cider":        
                return HotKettleFoodComponents.APPLE_CIDER;

            case "block.hotkettles.apple_cider_hot":    
                return HotKettleFoodComponents.HOT_CIDER;

            case "block.hotkettles.bitter_water":       
                return HotKettleFoodComponents.BITTER_WATER;

            case "block.hotkettles.bitter_water_hot":   
                return HotKettleFoodComponents.HOT_COCOA;

            case "block.hotkettles.hot_chocolate":      
                return HotKettleFoodComponents.HOT_CHOCOLATE;

            case "block.hotkettles.latte":              
                return HotKettleFoodComponents.LATTE;

            case "block.hotkettles.mocha":              
                return HotKettleFoodComponents.MOCHA;

            case "block.hotkettles.pumpkin_spice_latte":
                return HotKettleFoodComponents.PUMPKIN_SPICE_LATTE;

            case "block.hotkettles.rose_tea":           
                return HotKettleFoodComponents.ROSE_TEA;

            case "block.hotkettles.dandelion_tea":      
                return HotKettleFoodComponents.DANDELION_TEA;

            case "block.hotkettles.fairy_tea":          
                return HotKettleFoodComponents.FAIRY_TEA;

            default:
                return HotKettleFoodComponents.HOT_DRINK;
        }
    }
*/
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
            if (context.getWorld().getBlockEntity(context.getBlockPos()) instanceof KettleBlockEntity kettle) {
                if (!kettle.isFull()) {
                    Item i = context.getPlayer().getStackInHand(context.getHand()).getItem();
                    // 0: empty
                    // 1: poison
                    // 2: water
                    // 3: milk
                    // 4: bitter
                    // 5: apple
                    // 6: lava

                    boolean success = false;
                    BlockState kettleBlockState = context.getWorld().getBlockState(context.getBlockPos());

                    if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 0) {
                        if (i.equals(HotKettleItems.poison.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 1));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(2);
                            success = true;
                        }
                        if (i.equals(HotKettleItems.cup_of_water.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 2));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(4);
                            success = true;
                        }
                        if (i.equals(HotKettleItems.cup_of_milk.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 3));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(6);
                            success = true;
                        }
                        if (i.equals(HotKettleItems.bitter_water.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 4));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(8);
                            success = true;
                        }
                        if (i.equals(HotKettleItems.apple_cider.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 5));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(10);
                            success = true;
                        }
                        if (i.equals(HotKettleItems.cup_of_lava.get())) {
                            context.getWorld().setBlockState(context.getBlockPos(), kettleBlockState.with(KettleBlock.KETTLE_TYPE, 6));
                            kettle = (KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos());
                            kettle.setLiquidLevel(1);
                            kettle.setLiquidHorizontalOffset(12);
                            success = true;
                        }

                    }

                    if (i.equals(HotKettleItems.poison.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 1) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }
                    if (i.equals(HotKettleItems.cup_of_water.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 2) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }
                    if (i.equals(HotKettleItems.cup_of_milk.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 3) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }
                    if (i.equals(HotKettleItems.bitter_water.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 4) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }
                    if (i.equals(HotKettleItems.apple_cider.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 5) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }
                    if (i.equals(HotKettleItems.cup_of_lava.get())) {
                        if (kettleBlockState.get(KettleBlock.KETTLE_TYPE) == 6) {
                            kettle.addLiquid();
                            success = true;
                        }
                    }

                    if (success) {
                        int count = context.getPlayer().getStackInHand(context.getHand()).getCount();
                        if (count == 1) {
                            context.getPlayer().setStackInHand(context.getHand(), new ItemStack(HotKettleItems.empty_mug.get()));
                        } else {
                            context.getPlayer().getStackInHand(context.getHand()).setCount(count - 1);
                            context.getPlayer().giveItemStack(new ItemStack(HotKettleItems.empty_mug.get()));
                        }

                        return ActionResult.success(true);
                    }
                }
            }

        return super.useOnBlock(context);
    }
}
