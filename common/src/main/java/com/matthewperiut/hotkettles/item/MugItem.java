package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.MugBlock;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
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

public class MugItem extends BlockItem {

    public MugItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        boolean hot = stack.hasNbt() && stack.getNbt().contains("hot");
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
        ActionResult result = super.place(context);
        if (result == ActionResult.CONSUME) {
            if (context.getStack().hasNbt() && context.getStack().getNbt().contains("hot")) {
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
            user.removeStatusEffect(StatusEffects.POISON);
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

    @Override
    public boolean isFood() {
        return true;
    }

    @Override
    public @Nullable FoodComponent getFoodComponent() {
        String currentItem = getTranslationKey();

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

        //return HotKettleFoodComponents.HOT_DRINK;
    }


}
