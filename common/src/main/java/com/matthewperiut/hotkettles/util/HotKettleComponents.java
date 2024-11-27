package com.matthewperiut.hotkettles.util;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.item.HotKettleFoodComponents;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import com.mojang.serialization.Codec;
import net.minecraft.component.DataComponentType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class HotKettleComponents {
    public static final DataComponentType<Integer> LIQUID_LEVEL_COMPONENT = DataComponentType.<Integer>builder()
            .codec(Codec.intRange(0, 5))
            .packetCodec(PacketCodecs.INTEGER)
            .build();
    public static final DataComponentType<Boolean> HOT_DRINK_COMPONENT = DataComponentType.<Boolean>builder()
            .codec(Codec.BOOL)
            .packetCodec(PacketCodecs.BOOL)
            .build();

    public static void init() {
        Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier(HotKettles.MOD_ID, "liquid_level"), LIQUID_LEVEL_COMPONENT);
        Registry.register(Registries.DATA_COMPONENT_TYPE, new Identifier(HotKettles.MOD_ID, "hot_drink"), HOT_DRINK_COMPONENT);
    }

    public static FoodComponent heatDrink(ItemStack stack) {
        if (stack.getItem().equals(HotKettleItems.cup_of_water)) {
            return HotKettleFoodComponents.HOT_WATER;
        }
        if (stack.getItem().equals(HotKettleItems.apple_cider)) {
            return HotKettleFoodComponents.HOT_CIDER;
        }
        if (stack.getItem().equals(HotKettleItems.bitter_water)) {
            return HotKettleFoodComponents.HOT_COCOA;
        }
        if (stack.getItem().equals(HotKettleItems.cup_of_milk)) {
            return HotKettleFoodComponents.STEAMED_MILK;
        }
        return null;
    }
}
