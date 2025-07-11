package com.matthewperiut.hotkettles.item;

import com.matthewperiut.hotkettles.blockentity.KettleBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.component.Component;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.jetbrains.annotations.Nullable;

import static com.matthewperiut.hotkettles.block.KettleBlock.KETTLE_TYPE;
import static com.matthewperiut.hotkettles.components.HotKettleComponents.LIQUID_LEVEL_COMPONENT;

public class KettleItem extends BlockItem {
    public int kettle_type = 0;

    public KettleItem(Block block, Settings settings, int kettle_type) {
        super(block, settings.maxCount(1));
        this.kettle_type = kettle_type;
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("block." + Registries.ITEM.getId(this).toString().replace(":", "."));
    }

    // hacky but it'll do
    // seemingly place's item placement context is wrong, giving air for getStack.
    public static int liquidLevel = -1;

    @Override
    public @Nullable ItemPlacementContext getPlacementContext(ItemPlacementContext context) {
        if (context.getStack().contains(LIQUID_LEVEL_COMPONENT.get())) {
            liquidLevel = context.getStack().get(LIQUID_LEVEL_COMPONENT.get());
        } else {
            liquidLevel = -1;
        }
        return super.getPlacementContext(context);
    }

    public ActionResult place(ItemPlacementContext context) {
        ActionResult result = super.place(context);
        if (result == ActionResult.SUCCESS) {

            if (liquidLevel > -1) {
                ((KettleBlockEntity) context.getWorld().getBlockEntity(context.getBlockPos())).setLiquidLevel(liquidLevel);
            } else {
                if (context.getWorld().getBlockState(context.getBlockPos()).get(KETTLE_TYPE) == 0) {
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
