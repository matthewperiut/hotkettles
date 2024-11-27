package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class EmptyMugItem extends BlockItem {
    public EmptyMugItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public boolean isFood() {
        return false;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockEntity e = context.getWorld().getBlockEntity(context.getBlockPos());
        if (e != null) {
            if (e instanceof KettleBlockEntity kettle) {
                ItemStack hand = context.getPlayer().getStackInHand(context.getHand());
                ItemStack item = kettle.takeLiquid(context.getPlayer());
                if (item != null) {
                    hand.setCount(hand.getCount() - 1);
                    if (hand.getCount() == 0) {
                        context.getPlayer().setStackInHand(context.getHand(), item);
                    } else {
                        context.getPlayer().giveItemStack(item);
                    }
                    return ActionResult.CONSUME;
                }
            }
        }
        return super.useOnBlock(context);
    }
}
