package com.matthewperiut.hotkettles.blockentity;

import com.matthewperiut.hotkettles.HotKettles;
import com.matthewperiut.hotkettles.block.KettleBlock;
import com.matthewperiut.hotkettles.item.HotKettleItems;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class KettleBlockEntity extends BlockEntity {
    public boolean dirX = false;
    public int liquidHorizontalOffset = 0;
    public int liquidLevel = 0;

    public boolean isFull() {
        return liquidLevel == 5;
    }

    public void addLiquid() {
        if (liquidLevel == 0) {
            setLiquidLevel(liquidLevel + 1);
        } else {
            setLiquidLevel(liquidLevel + 2);
        }
        if (liquidLevel > 5) {
            setLiquidLevel(5);
        }
    }

    public boolean hot() {
        Block block = getWorld().getBlockState(pos.down()).getBlock();

        return block == Blocks.LAVA || block == Blocks.LAVA_CAULDRON || block == Blocks.FIRE
                || block == Blocks.SOUL_FIRE || block == Blocks.TORCH || block == Blocks.SOUL_TORCH
                || (block == Blocks.FURNACE && getWorld().getBlockState(pos.down()).get(Properties.LIT))
                || (block == Blocks.BLAST_FURNACE && getWorld().getBlockState(pos.down()).get(Properties.LIT));
    }

    public ItemStack takeLiquid(PlayerEntity player) {

        if (liquidLevel > 0) {
            if (liquidLevel - 2 < 0) {
                setLiquidLevel(0);
            } else {
                setLiquidLevel(liquidLevel - 2);
            }
        } else {
            return null;
        }



        // 0: empty
        // 1: poison
        // 2: water
        // 3: milk
        // 4: bitter
        // 5: apple
        // 6: lava
        int type = liquidHorizontalOffset / 2;

        if (liquidLevel <= 0) {
            setLiquidLevel(0);
            setLiquidHorizontalOffset(0);
            world.setBlockState(pos, world.getBlockState(pos).with(KettleBlock.KETTLE_TYPE, 0));
        }

        switch (type) {
            case 0:
                return null;
            case 1:
                return new ItemStack(HotKettleItems.POISON.get());
            case 2:
                if (hot()) {
                    return new ItemStack(HotKettleItems.HOT_WATER.get());
                } else {
                    player.sendMessage(Text.of("You can make this drink hot by putting lava, torch, or lit furnace underneath kettle"), true);
                    return new ItemStack(HotKettleItems.CUP_OF_WATER.get());
                }
            case 3:
                if (hot()) {
                    return new ItemStack(HotKettleItems.STEAMED_MILK.get());
                } else {
                    player.sendMessage(Text.of("You can make this drink hot by putting lava, torch, or lit furnace underneath kettle"), true);
                    return new ItemStack(HotKettleItems.CUP_OF_MILK.get());
                }
            case 4:
                if (hot()) {
                    return new ItemStack(HotKettleItems.HOT_COCOA.get());
                } else {
                    player.sendMessage(Text.of("You can make this drink hot by putting lava, torch, or lit furnace underneath kettle"), true);
                    return new ItemStack(HotKettleItems.BITTER_WATER.get());
                }
            case 5:
                if (hot()) {
                    return new ItemStack(HotKettleItems.HOT_CIDER.get());
                } else {
                    player.sendMessage(Text.of("You can make this drink hot by putting lava, torch, or lit furnace underneath kettle"), true);
                    return new ItemStack(HotKettleItems.APPLE_CIDER.get());
                }
            case 6:
                return new ItemStack(HotKettleItems.CUP_OF_LAVA.get());
        }

        return null;
    }

    public KettleBlockEntity(BlockPos pos, BlockState state) {
        super(Registries.BLOCK_ENTITY_TYPE.get(Identifier.of(HotKettles.MOD_ID, "kettle")), pos, state);
        Direction dir = state.get(Properties.HORIZONTAL_FACING);
        if (dir == Direction.EAST || dir == Direction.WEST) {
            dirX = true;
        }
        liquidHorizontalOffset = (state.get(KettleBlock.KETTLE_TYPE) * 2);
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, KettleBlockEntity kettleBlockEntity) {
        // Your tick logic here
    }

    // Override the writeNbt method to save liquidLevel and liquidHorizontalOffset to NBT
    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("LiquidLevel", this.liquidLevel);
        nbt.putInt("LiquidHorizontalOffset", this.liquidHorizontalOffset);
    }

    // Override the readNbt method to load liquidLevel and liquidHorizontalOffset from NBT
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.liquidLevel = nbt.getInt("LiquidLevel");
        this.liquidHorizontalOffset = nbt.getInt("LiquidHorizontalOffset");
    }

    // Override toInitialChunkDataNbt to send the initial data to the client
    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    // Override toUpdatePacket to send updates to the client

    @Override
    public @Nullable net.minecraft.network.packet.Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    // Method to set the liquid level and notify the client
    public void setLiquidLevel(int level) {
        if (this.liquidLevel != level) {
            this.liquidLevel = level;
            markDirty();
            if (this.world != null) {
                this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 3);
            }
        }
    }

    // Method to set the liquid horizontal offset and notify the client
    public void setLiquidHorizontalOffset(int offset) {
        if (this.liquidHorizontalOffset != offset) {
            this.liquidHorizontalOffset = offset;
            markDirty();
            if (this.world != null) {
                this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 3);
            }
        }
    }
}
