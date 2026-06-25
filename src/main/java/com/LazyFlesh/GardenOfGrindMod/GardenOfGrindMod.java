package com.LazyFlesh.GardenOfGrindMod;

import java.io.File;
import java.nio.file.Path;

import net.minecraft.launchwrapper.Launch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(
    modid = GardenOfGrindMod.MODID,
    version = GardenOfGrindMod.VERSION,
    name = "GardenOfGrindMod",
    acceptedMinecraftVersions = "[1.7.10]")
public class GardenOfGrindMod {

    public static final String MODID = "GardenOfGrindMod";
    public static final String VERSION = Tags.VERSION;
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "com.LazyFlesh.GardenOfGrindMod.ClientProxy",
        serverSide = "com.LazyFlesh.GardenOfGrindMod.CommonProxy")
    public static CommonProxy proxy;

    public static Path gogConfigFilepath;

    private static File minecraftHome() {
        return Launch.minecraftHome != null ? Launch.minecraftHome : new File(".");
    }

    static {
        try {
            ConfigurationManager.registerConfig(GeneralConfig.class);
        } catch (ConfigException e) {
            throw new RuntimeException(e);
        }
    }

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

        gogConfigFilepath = minecraftHome().toPath()
            .resolve("config/GardenOfGrind.cfg");
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
