package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.block.KettleBlock;
import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;

import static com.matthewperiut.hotkettles.util.HotKettleComponents.LIQUID_LEVEL_COMPONENT;

public class KettleItem extends BlockItem {
    public int kettle_type = 0;

    public KettleItem(Block block, Settings settings, int kettle_type) {
        super(block, settings.maxCount(1));
        this.kettle_type = kettle_type;
    }

    @Override
    public String getTranslationKey() {
        return "block." + Registries.ITEM.getId(this).toString().replace(":", ".");
    }

    public ActionResult place(ItemPlacementContext context) {
        ActionResult result = super.place(context);
        if (result == ActionResult.CONSUME) {
            if (context.getStack().contains(LIQUID_LEVEL_COMPONENT.get())) {
                int liquidLevel = context.getStack().get(LIQUID_LEVEL_COMPONENT.get());
                ((KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos())).setLiquidLevel(liquidLevel);
            } else {
                if (kettle_type == 0) {
                    ((KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos())).setLiquidLevel(0);
                } else {
                    ((KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos())).setLiquidLevel(5);
                }
            }
        }
        return result;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        if (stack.contains(LIQUID_LEVEL_COMPONENT.get())) {
            int liquidLevel = stack.get(LIQUID_LEVEL_COMPONENT.get());
            int result = (int) (liquidLevel * 2.6f);
            return result;
        }
        return 13;
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return 0x00FF00; // Replace with desired RGB color
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        if (stack.contains(LIQUID_LEVEL_COMPONENT.get())) {
            int liquidLevel = stack.get(LIQUID_LEVEL_COMPONENT.get());
            return liquidLevel != 5;
        }
        return false;
    }
}
