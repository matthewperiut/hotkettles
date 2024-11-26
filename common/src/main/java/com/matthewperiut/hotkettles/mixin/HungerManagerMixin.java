package com.matthewperiut.hotkettles.mixin;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.item.MugItem;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public class HungerManagerMixin {
    @Inject(method = "eat", at = @At(value = "HEAD"))
    void captureMugHotness_hotkettles(Item item, ItemStack stack, CallbackInfo info) {
        if (item instanceof MugItem mugItem) {
            HotKettles.hot_workaround = stack.getOrCreateNbt().getBoolean("hot");
        }
    }
}
