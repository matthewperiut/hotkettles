package com.matthewperiut.hotkettles.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class KettleItem extends BlockItem {
    public int kettle_type = 0;

    public KettleItem(Block block, Settings settings, int kettle_type) {
        super(block, settings);
        this.kettle_type = kettle_type;
    }
}
