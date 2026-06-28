package com.LazyFlesh.gogmod.loaders;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.LazyFlesh.gogmod.GardenOfGrindMod;
import com.LazyFlesh.gogmod.loaders.items.GravelDust;
import com.LazyFlesh.gogmod.loaders.items.Silt;
import com.LazyFlesh.gogmod.loaders.items.ThermiteBucket;
import com.LazyFlesh.gogmod.loaders.items.VolatileMass;
import com.LazyFlesh.gogmod.loaders.items.WateryMass;

import cpw.mods.fml.common.registry.GameRegistry;

public enum GoGItemList {

    ThermiteBucket("ThermiteBucket", new ThermiteBucket()),
    GravelDust("GravelDust", new GravelDust()),
    SiltDust("SiltDust", new Silt()),
    VolatileMass("VolatileMass", new VolatileMass()),
    WateryMass("WateryMass", new WateryMass()),

    // because it's a pattern to use a comma, and breaking a pattern sucks
    ;

    // =====================================

    public final String name;
    public final Item item;

    static {
        ThermiteBucket.item.setMaxStackSize(1);
    }

    GoGItemList(String name, Item item) {
        this.name = name;
        this.item = item;

        item.setUnlocalizedName(name);
        item.setTextureName(GardenOfGrindMod.MODID + ":" + name);
    }

    public ItemStack get() {
        return new ItemStack(item, 1);
    }

    public ItemStack get(int amount) {
        return new ItemStack(item, amount);
    }

    public static void registerAll() {
        for (final var entry : GoGItemList.values()) {
            GameRegistry.registerItem(entry.item, entry.name);
        }
    }
}
