package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.LazyFlesh.GardenOfGrindMod.CommonProxy;
import com.LazyFlesh.GardenOfGrindMod.GeneralConfig;
import com.hfstudio.bqapi.BQApi;
import com.hfstudio.bqapi.api.builder.Chapters;
import com.hfstudio.bqapi.api.definition.ChapterDefinition;

import betterquesting.api.utils.UuidConverter;

public class ModeLoader {

    public static final UUID STONE_AGE_UUID = UuidConverter.decodeUuid("AAAAAAAAAAAAAAAAAAAAAA==");

    public static final List<ChapterDefinition> CHAPTERS = new ArrayList<>();

    public static final String RESOURCE_MOD_ID = "GardenOfGrindMod";
    public static final String RESOURCE_ROOT = "quests";

    public static boolean registered;

    public void loadQuestlines() {
        if (CommonProxy.bqApi) {
            // load questline, above getting started
            initChapters();
            register();
        }
    }

    public ModeLoader() {}

    public static void register() {
        if (registered) {
            return;
        }
        for (ChapterDefinition chapter : CHAPTERS) {
            BQApi.register(chapter);
        }
        registered = true;
    }

    private static void initChapters() {
        CHAPTERS.add(
            Chapters.imported("AGardenInTheSky")
                .resourceFolder(RESOURCE_MOD_ID, RESOURCE_ROOT)
                .lineDirectory("AGardenintheSky-XmIcwZ1VTV2aWje2MH6WAQ==")
                .uuidFromResource()
                .orderAfter(STONE_AGE_UUID)
                .build());
    }

    public static String getMode() {
        switch (GeneralConfig.challengeMode) {
            case 0 -> {
                return "Garden of Grind";
            }
            case 1 -> {
                return "Skyblock";
            }
            case 2 -> {
                return "Garden of Grindless";
            }
            case 3 -> {
                return "Questless Garden of Grind";
            }

        }
        return "Garden of Grind";
    }

}
