package com.matthewperiut.hotkettles.item;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.matthewperiut.hotkettles.HotKettles.MANAGER;
import static com.matthewperiut.hotkettles.HotKettles.MOD_ID;

public class HotKettleItemGroups {
    public static final Registrar<ItemGroup> TABS = MANAGER.get().get(Registries.ITEM_GROUP);
    public static final RegistrySupplier<ItemGroup> KETTLE_TAB = TABS.register(Identifier.of(MOD_ID, "kettle_tab"), () ->
            CreativeTabRegistry.create(Text.translatable("tab.hotkettles.kettle"),
                    () -> new ItemStack(HotKettleItems.kettle.get())));

    public static void init() {

    }
}
