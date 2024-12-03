package com.matthewperiut.hotkettles.components;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
//import net.minecraft.component.ComponentType;
//import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleComponents {

//    public static final Registrar<ComponentType<?>> COMPONENT_TYPES = MANAGER.get().get(Registries.DATA_COMPONENT_TYPE);
//    public static final RegistrySupplier<ComponentType<Integer>> LIQUID_LEVEL_COMPONENT = COMPONENT_TYPES.register(Identifier.of(MOD_ID, "liquid_level"), () -> ComponentType.<Integer>builder().codec(Codec.intRange(0, 5)).packetCodec(PacketCodecs.INTEGER).build());


    public static void init() {

    }
}
