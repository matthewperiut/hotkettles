package com.matthewperiut.hotkettles.components;

//import net.minecraft.component.type.FoodComponent;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class HotKettleFoodComponents {

//    public static final FoodComponent ALWAYS_CONSUMABLE = (new FoodComponent.Builder()).nutrition(0).saturationModifier(1.F).alwaysEdible().build();
public static final FoodComponent HOT_DRINK           = (new FoodComponent.Builder()).hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent POISON              = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.POISON, 5 * 20, 1), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.NAUSEA, 5 * 20, 1), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent CUP_OF_LAVA         = (new FoodComponent.Builder())
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent CUP_OF_WATER        = (new FoodComponent.Builder())
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent HOT_WATER           = (new FoodComponent.Builder())
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent DANDELION_TEA       = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 0), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.JUMP_BOOST, 30 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent ROSE_TEA            = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 0), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.SPEED, 30 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent FAIRY_TEA           = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.LEVITATION, 2 * 20, 0), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.SPEED, 20 * 20, 0), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent APPLE_CIDER         = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(1).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent HOT_CIDER           = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 1), 1.0F )
            /* Properties:    */                                  .hunger(2).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent CUP_OF_MILK         = (new FoodComponent.Builder()).hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent STEAMED_MILK        = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 20, 1), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();

    public static final FoodComponent BITTER_WATER        = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 45 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent HOT_COCOA           = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(0).saturationModifier(1.F).alwaysEdible().build();
    public static final FoodComponent HOT_CHOCOLATE       = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 120 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(1).saturationModifier(2.F).alwaysEdible().build();
    public static final FoodComponent LATTE               = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1), 1.0F )
            /* Properties:    */                                  .hunger(1).saturationModifier(2.F).alwaysEdible().build();
    public static final FoodComponent MOCHA               = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1), 1.0F )
            /* Properties:    */                                  .hunger(2).saturationModifier(2.F).alwaysEdible().build();
    public static final FoodComponent PUMPKIN_SPICE_LATTE = (new FoodComponent.Builder())
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1), 1.0F )
            /* Status Effect: */                                  .arch$effect( ()-> new StatusEffectInstance(StatusEffects.SPEED, 90 * 20, 0), 1.0F )
            /* Properties:    */                                  .hunger(2).saturationModifier(3.F).alwaysEdible().build();

    public static void init() {

    }
}
