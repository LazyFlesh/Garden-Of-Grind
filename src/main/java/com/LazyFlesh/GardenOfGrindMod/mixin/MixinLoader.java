package com.LazyFlesh.GardenOfGrindMod.mixin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class MixinLoader {

    public static class LateMixinLoader implements ILateMixinLoader {

        @Override
        public String getMixinConfig() {
            return "mixins.GardenOfGrindMod.late.json";
        }

        @Override
        public @NotNull List<String> getMixins(Set<String> loadedMods) {
            return Collections.emptyList();
        }
    }

    public static class EarlyMixinLoader implements IEarlyMixinLoader {

        @Override
        public String getMixinConfig() {
            return "mixins.GardenOfGrindMod.early.json";
        }

        @Override
        public List<String> getMixins(Set<String> loadedCoreMods) {
            final List<String> mixins = new ArrayList<>();
            return mixins;
        }
    }
}
