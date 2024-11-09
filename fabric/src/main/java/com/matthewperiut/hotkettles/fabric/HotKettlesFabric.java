package com.matthewperiut.hotkettles.fabric;

import com.matthewperiut.hotkettles.HotKettles;
import net.fabricmc.api.ModInitializer;

public class HotKettlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        HotKettles.init();
    }
}
