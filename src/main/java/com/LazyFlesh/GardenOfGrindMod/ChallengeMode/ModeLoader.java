package com.LazyFlesh.GardenOfGrindMod.ChallengeMode;

import com.hfstudio.bqapi.BQApi;
import com.hfstudio.bqapi.api.builder.Chapters;
import com.hfstudio.bqapi.api.builder.Quests;
import com.hfstudio.bqapi.api.builder.RewardBuilders;
import com.hfstudio.bqapi.api.builder.TaskBuilders;
import com.hfstudio.bqapi.api.definition.ChapterDefinition;
import com.hfstudio.bqapi.api.definition.QuestDefinition;
import com.hfstudio.bqapi.api.definition.QuestPlacementDefinition;

public class ModeLoader {

    public void loadQuestbook() {
        // load static entries
        QuestDefinition starterQuest = Quests.quest("starter_collect_logs")
            .task(
                TaskBuilders.retrieval("collect_logs")
                    .item("minecraft:log", 16, 0)
                    .consume(true)
                    .build())
            .reward(
                RewardBuilders.item("starter_reward")
                    .item("minecraft:iron_ingot", 4, 0)
                    .build())
            .build();

        ChapterDefinition chapter = Chapters.chapter("chapter_getting_started")
            .icon("minecraft:book", 1, 0)
            .quest(new QuestPlacementDefinition(starterQuest, 0, 0, 2, 2))
            .build();

        BQApi.register(chapter);
    }

}
