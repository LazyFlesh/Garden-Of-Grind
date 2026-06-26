package com.LazyFlesh.GardenOfGrindMod.loaders.meteors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.LazyFlesh.GardenOfGrindMod.GardenOfGrindMod;
import com.google.gson.JsonSyntaxException;

public class meteors {

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
                                    fileContent.set(i, "    \"gregtech:gt.blockores2:817:53\",");
                                    break;
                                } else if (fileContent.get(i)
                                    .startsWith("    \"OREDICT:oreTengamRaw:")) {
                                        fileContent.set(i, "    \"OREDICT:oreTengamRaw:20\"");
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
                                        fileContent.set(i, "    \"etfuturum:ancient_debris:0:10\"");
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
