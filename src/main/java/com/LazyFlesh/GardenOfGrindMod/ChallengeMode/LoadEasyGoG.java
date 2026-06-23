package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;

public class LoadEasyGoG extends ModeLoader {

    public LoadEasyGoG() {
        GardenOfGrindMod.LOG.info("Loading Easy Garden of Grind");

    }

    @Override
    public void loadQuestbook() {
        // load mode-specific quests

        // load static entries
        super.loadQuestbook();
    }
}
