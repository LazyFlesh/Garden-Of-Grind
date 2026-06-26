package com.LazyFlesh.GardenOfGrindMod.loaders.items;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class Silt extends Item {

    @Override
    public boolean onEntityItemUpdate(EntityItem aItemEntity) {
        if (aItemEntity != null && !aItemEntity.worldObj.isRemote) {
            int tX = MathHelper.floor_double(aItemEntity.posX);
            int tY = MathHelper.floor_double(aItemEntity.posY);
            int tZ = MathHelper.floor_double(aItemEntity.posZ);
            Block tBlock = aItemEntity.worldObj.getBlock(tX, tY, tZ);
            int tMetaData = aItemEntity.worldObj.getBlockMetadata(tX, tY, tZ);
            if (tBlock == Blocks.water || tBlock == Blocks.flowing_water
                || (tBlock == Blocks.cauldron) && (tMetaData > 0)) {
                aItemEntity.setEntityItemStack(
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, aItemEntity.getEntityItem().stackSize));
                aItemEntity.delayBeforeCanPickup = 0;
                return true;
            }

        }
        return false;
    }

}
