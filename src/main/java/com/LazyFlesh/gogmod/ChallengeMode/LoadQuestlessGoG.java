package com.LazyFlesh.gogmod.ChallengeMode;

import com.LazyFlesh.gogmod.GardenOfGrindMod;

import betterquesting.api.storage.BQ_Settings;

public class LoadQuestlessGoG extends ModeLoader {

    public LoadQuestlessGoG() {
        GardenOfGrindMod.LOG.info("Loading Questless Garden of Grind");
        modeName = "Questless Garden of Grind";
        // disable rewards for questless gog
        BQ_Settings.noRewards = true;
        loadQuestlines();
    }

    public static void registerRecipes() {
        // do nothing. No recipe changes required yet.
    }
}
