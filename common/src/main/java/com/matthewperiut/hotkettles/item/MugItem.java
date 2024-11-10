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
        user.getStackInHand(hand).getOrCreateNbt().putBoolean("hot", true);
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
        return HotKettleFoodComponents.HOT_DRINK;
    }


}
