package com.LazyFlesh.gogmod.ChallengeMode;

import static com.dreammaster.scripts.IScriptLoader.missing;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.mixerNonCellRecipes;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.multiblockRockBreakerRecipes;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.simpleWasherRecipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.LazyFlesh.gogmod.GardenOfGrindMod;
import com.LazyFlesh.gogmod.loaders.GoGItemList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.common.items.IDMetaTool01;
import gregtech.common.items.MetaGeneratedTool01;
import gregtech.common.tileentities.machines.basic.MTERockBreaker;

public class LoadSkyblock extends ModeLoader {

    public LoadSkyblock() {
        GardenOfGrindMod.LOG.info("Loading Skyblock");
        modeName = "Skyblock";
        this.loadQuestlines();
    }

    public static void registerRecipes() {
        GardenOfGrindMod.LOG.info("Registering recipes for Skyblock");

        try {
            if (Mods.CropsNH.isModLoaded()) {
                GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                        getModItem(Mods.CropsNH.getID(), "cropSticks", 1),
                        new ItemStack(Items.bone, 1),
                        new ItemStack(Items.bone, 1),
                        new ItemStack(Items.bone, 1),
                        new ItemStack(Items.bone, 1)));

                GameRegistry.addRecipe(
                    new ShapelessOreRecipe(
                        getModItem(Mods.CropsNH.getID(), "cropSticks", 1),
                        new ItemStack(Items.arrow, 1),
                        new ItemStack(Items.arrow, 1),
                        new ItemStack(Items.arrow, 1),
                        new ItemStack(Items.arrow, 1)));
            }
            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    GoGItemList.VolatileMass.get(1),
                    new ItemStack(Items.fire_charge, 1),
                    new ItemStack(Items.coal, 1),
                    new ItemStack(Items.bone, 1),
                    new ItemStack(Items.bone, 1)));

            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    GoGItemList.WateryMass.get(1),
                    "aa ",
                    "aa ",
                    "   ",
                    'a',
                    NHItemList.MaceratedPlantmass.get(1)));

            if (Mods.PamsHarvestCraft.isModLoaded()) GameRegistry.addRecipe(
                new ShapedOreRecipe(GoGItemList.WateryMass.get(1), "aaa", "aaa", "aaa", 'a', "listAlljuice"));

            GameRegistry.addRecipe(
                new ShapedOreRecipe(NHItemList.MaceratedPlantmass.get(1), "aaa", "a a", "aaa", 'a', "treeSapling"));
            GameRegistry.addRecipe(
                new ShapedOreRecipe(NHItemList.MaceratedPlantmass.get(1), "aaa", "a a", "aaa", 'a', "treeLeaves"));
            if (Mods.PamsHarvestCraft.isModLoaded()) {
                GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                        NHItemList.MaceratedPlantmass.get(1),
                        "aaa",
                        "a a",
                        "aaa",
                        'a',
                        "listAllveggie"));
                GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                        NHItemList.MaceratedPlantmass.get(1),
                        "aaa",
                        "a a",
                        "aaa",
                        'a',
                        "listAllfruit"));
                GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                        NHItemList.MaceratedPlantmass.get(1),
                        "aaa",
                        "a a",
                        "aaa",
                        'a',
                        "listAllmushroom"));
            }
            GameRegistry.addRecipe(
                new ShapedOreRecipe(NHItemList.MaceratedPlantmass.get(1), "aaa", "a a", "aaa", 'a', "sugarcane"));

            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    MetaGeneratedTool01.INSTANCE
                        .getToolWithStats(IDMetaTool01.HARDHAMMER.ID, 1, Materials.Flint, Materials.Wood, null),
                    "XX ",
                    "XXS",
                    "XX ",
                    'X',
                    Items.flint,
                    'S',
                    Items.stick));

            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    GoGItemList.GravelDust.get(1),
                    "ba ",
                    "   ",
                    "   ",
                    'a',
                    "craftingToolHardHammer",
                    'b',
                    getModItem(Mods.Minecraft.ID, "gravel", 1, 0, missing)));

            GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                    GoGItemList.SiltDust.get(1),
                    "craftingToolHardHammer",
                    new ItemStack(Blocks.sand)));

            GameRegistry.addRecipe(
                new ShapedOreRecipe(
                    GoGItemList.ThermiteBucket.get(1),
                    "abc",
                    "abc",
                    " e ",
                    'a',
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnetite, 1),
                    'b',
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1),
                    'c',
                    GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1),
                    'e',
                    new ItemStack(Items.bucket, 1)));
        } catch (Exception e) {
            MainRegistry.LOGGER.error("A Garden of Grind Skyblock recipe went wrong:");
            e.printStackTrace();
        }

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.gravel), 1))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.YellowLimonite, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tetrahedrite, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.CassiteriteSand, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Zinc, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Silver, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(1)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.gravel), 1, WILDCARD))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.VanadiumMagnetite, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Chalcopyrite, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Galena, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Coal, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Diamond, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Graphite, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(2)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_MV / 2)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.gravel), 1, WILDCARD))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Aluminium, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Galena, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Sphalerite, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Bauxite, 1),
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Ilmenite, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Neodymium, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(3)
            .duration(50 * TICKS)
            .eut(TierEU.RECIPE_HV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.sand), 1, WILDCARD))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.CassiteriteSand, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetSand, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silver, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Asbestos, 1),
                GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.Mica, 1))
            .outputChances(50_00, 40_00, 25_00, 15_00, 10_00, 10_00)
            .circuit(1)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.sand), 1, WILDCARD))
            .itemOutputs(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Spessartine, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Electrotine, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.GraniticMineralSand, 1),
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.BasalticMineralSand, 1))
            .outputChances(50_00, 30_00, 25_00, 25_00, 10_00, 10_00)
            .circuit(2)
            .duration(1 * SECONDS)
            .eut(TierEU.RECIPE_MV)
            .addTo(centrifugeRecipes);

        GTValues.RA.stdBuilder()
            .itemOutputs(new ItemStack(Item.getItemFromBlock(Blocks.cobblestone), 1))
            .fluidInputs(new FluidStack(FluidRegistry.WATER, 10), new FluidStack(FluidRegistry.LAVA, 0))
            .circuit(1)
            .duration(50 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(mixerNonCellRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.gravel), 2, WILDCARD))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Magnetite, 3))
            .circuit(1)
            .duration(5 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(simpleWasherRecipes);

        GTValues.RA.stdBuilder()
            .itemInputs(new ItemStack(Item.getItemFromBlock(Blocks.sand), 2, WILDCARD))
            .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustImpure, Materials.CassiteriteSand, 3))
            .circuit(1)
            .duration(5 * TICKS)
            .eut(TierEU.RECIPE_ULV)
            .addTo(simpleWasherRecipes);

        if (Mods.AppliedEnergistics2.isModLoaded()) {
            GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L))
                .circuit(6)
                .itemOutputs(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1L))
                .duration(16 * TICKS)
                .eut(TierEU.RECIPE_LV)
                .addTo(multiblockRockBreakerRecipes);

            MTERockBreaker.addRockBreakerRecipe(
                b -> b.sideBlocks(Blocks.water)
                    .anywhereBlocks(Blocks.lava)
                    .inputItem(GTOreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L), true)
                    .circuit(6)
                    .outputItem(getModItem(AppliedEnergistics2.ID, "tile.BlockSkyStone", 1L))
                    .duration(16 * TICKS));

        }
    }

    public void registerOre() {
        Object[] ores = new Object[] {};
        for (int i = 0; i < ores.length; ++i) {

        }
    }

}
