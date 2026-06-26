package com.LazyFlesh.GardenOfGrindMod.loaders.meteors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;
import com.LazyFlesh.GardenOfGrindMod.GeneralConfig;
import com.google.gson.JsonSyntaxException;

public class meteors {

    private static final String[] saltOre = new String[] { "    \"gregtech:gt.blockores2:817:72\",",
        "    \"gregtech:gt.blockores2:817:53\",", "    \"gregtech:gt.blockores2:817:53\",",
        "    \"gregtech:gt.blockores2:817:72\"," };
    private static final String[] tengamOre = new String[] { "    \"OREDICT:oreTengamRaw:1\"",
        "    \"OREDICT:oreTengamRaw:20\"", "    \"OREDICT:oreTengamRaw:20\"", "    \"OREDICT:oreTengamRaw:1\"" };
    private static final String[] debris = new String[] { "    \"etfuturum:ancient_debris:0:2\"",
        "    \"etfuturum:ancient_debris:0:10\"", "    \"etfuturum:ancient_debris:0:10\"",
        "    \"etfuturum:ancient_debris:0:2\"" };

    public static void overrideConfig() {
        File file = new File("config/BloodMagic/meteors");
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                try {
                    if (f.isDirectory()) {
                        continue;
                    } else if (f.getName()
                        .startsWith("CheatyVeryLow")) {
                            List<String> fileContent = new ArrayList<>(Files.readAllLines(f.toPath()));

                            for (int i = 0; i < fileContent.size(); i++) {
                                if (fileContent.get(i)
                                    .startsWith("    \"gregtech:gt.blockores2:817:")) {
                                    fileContent.set(i, saltOre[GeneralConfig.challengeMode]);
                                    break;
                                } else if (fileContent.get(i)
                                    .startsWith("    \"OREDICT:oreTengamRaw:")) {
                                        fileContent.set(i, tengamOre[GeneralConfig.challengeMode]);
                                        break;
                                    }
                            }

                            Files.write(f.toPath(), fileContent);
                        } else if (f.getName()
                            .startsWith("AncientDebris")) {
                                List<String> fileContent = new ArrayList<>(Files.readAllLines(f.toPath()));

                                for (int i = 0; i < fileContent.size(); i++) {
                                    if (fileContent.get(i)
                                        .startsWith("    \"etfuturum:ancient_debris:0:")) {
                                        fileContent.set(i, debris[GeneralConfig.challengeMode]);
                                        break;
                                    }
                                }

                                Files.write(f.toPath(), fileContent);
                            }
                } catch (IOException | JsonSyntaxException e) {
                    GardenOfGrindMod.LOG.error("Problem modifying meteor config.");
                    e.printStackTrace();
                }
            }
        }
    }
}
