package com.matthewperiut.hotkettles.components;

import net.minecraft.component.type.FoodComponent;

public class HotKettleFoodComponents {

    public static final FoodComponent ALWAYS_CONSUMABLE = (new FoodComponent.Builder()).nutrition(0).saturationModifier(1.F).alwaysEdible().build();

    public static void init() {

    }
}
