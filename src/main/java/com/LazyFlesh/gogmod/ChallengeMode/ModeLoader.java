package com.LazyFlesh.gogmod.ChallengeMode;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.LazyFlesh.gogmod.CommonProxy;
import com.hfstudio.bqapi.BQApi;
import com.hfstudio.bqapi.api.builder.Chapters;
import com.hfstudio.bqapi.api.definition.ChapterDefinition;

import betterquesting.api.utils.UuidConverter;

public class ModeLoader {

    public static final UUID STONE_AGE_UUID = UuidConverter.decodeUuid("AAAAAAAAAAAAAAAAAAAAAA==");

    public static final List<ChapterDefinition> CHAPTERS = new ArrayList<>();

    public static final String RESOURCE_MOD_ID = "gogmod";
    public static final String RESOURCE_ROOT = "quests";

    public static String modeName;

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
        CHAPTERS.add(
            Chapters.imported("Tier -1 - Dirt age")
                .resourceFolder(RESOURCE_MOD_ID, RESOURCE_ROOT)
                .lineDirectory("Tier1Dirtage-Vw_Rpd52RgmhU5Op7S0hyw==")
                .uuidFromResource()
                .orderAfter("AGardenintheSky-XmIcwZ1VTV2aWje2MH6WAQ==")
                .build());
    }

    public static String getMode() {
        if (modeName != null) return modeName;
        return "Garden of Grind";
    }

}
