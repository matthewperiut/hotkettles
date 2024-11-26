package com.matthewperiut.hotkettles.mixin;

import com.matthewperiut.hotkettles.item.MugItem;
import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShapelessRecipe.class)
public abstract class ShapelessRecipeMixin {

    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    private void stopColdDrinks(RecipeInputInventory recipeInputInventory, World world, CallbackInfoReturnable<Boolean> cir) {
        boolean hot = false;

        for (int i = 0; i < recipeInputInventory.size(); i++) {
            ItemStack itemStack = recipeInputInventory.getStack(i);
            if (!itemStack.isEmpty() && itemStack.getItem() instanceof MugItem) {
                hot = itemStack.getOrCreateNbt().getBoolean("hot");
                break;
            }
        }

        if (!hot) {
            cir.setReturnValue(false);
        }
    }
}