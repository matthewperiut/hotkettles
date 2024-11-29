package com.matthewperiut.hotkettles.components;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.component.type.ConsumableComponents.drink;

public class HotKettlesConsumableComponents {

    public static final ConsumableComponent POISON              = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 5 * 20, 1)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5 * 20, 1))).build();
    public static final ConsumableComponent CUP_OF_LAVA         = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).build();
    public static final ConsumableComponent CUP_OF_WATER        = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).build();
    public static final ConsumableComponent HOT_WATER           = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).build();
    public static final ConsumableComponent DANDELION_TEA       = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 0)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 30 * 20, 0))).build();
    public static final ConsumableComponent ROSE_TEA            = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 0)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 30 * 20, 0))).build();
    public static final ConsumableComponent FAIRY_TEA           = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2 * 20, 0)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20, 0)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 20, 0)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 20, 0))).build();
    public static final ConsumableComponent APPLE_CIDER         = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 0))).build();
    public static final ConsumableComponent HOT_CIDER           = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 10 * 20, 1))).build();
    public static final ConsumableComponent CUP_OF_MILK         = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).build();
    public static final ConsumableComponent STEAMED_MILK        = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 20, 1))).build();
    public static final ConsumableComponent BITTER_WATER        = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 45 * 20, 0))).build();
    public static final ConsumableComponent HOT_COCOA           = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 0))).build();
    public static final ConsumableComponent HOT_CHOCOLATE       = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 120 * 20, 0))).build();
    public static final ConsumableComponent LATTE               = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1))).build();
    public static final ConsumableComponent MOCHA               = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1))).build();
    public static final ConsumableComponent PUMPKIN_SPICE_LATTE = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK)
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1)))
            /* Status Effect: */                                  .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 90 * 20, 0))).build();
            
    public static void init() {

    }
}
