package com.matthewperiut.hotkettles.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class HotKettleFoodComponents {

    public static final FoodComponent HOT_DRINK = (new FoodComponent.Builder()).hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static void init() {

    }
}
