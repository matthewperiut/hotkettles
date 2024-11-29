package com.matthewperiut.hotkettles.edible;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.component.type.ConsumableComponents.drink;

public class HotKettlesConsumableComponents {

    public static final ConsumableComponent TEST_CONSUMABLE_COMPONENT = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 1, 0))).build();

    public static void init() {

    }
}
