package com.matthewperiut.hotkettles.components;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import com.mojang.serialization.Codec;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.component.DataComponentType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleComponents {

    public static final Registrar<DataComponentType<?>> COMPONENT_TYPES = MANAGER.get().get(Registries.DATA_COMPONENT_TYPE);
    public static final RegistrySupplier<DataComponentType<Integer>> LIQUID_LEVEL_COMPONENT = COMPONENT_TYPES.register(Identifier.of(MOD_ID, "liquid_level"), () -> DataComponentType.<Integer>builder().codec(Codec.intRange(0, 5)).packetCodec(PacketCodecs.INTEGER).build());


    public static void init() {

    }
}
