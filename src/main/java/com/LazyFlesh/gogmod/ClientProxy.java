package com.LazyFlesh.gogmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class ClientProxy extends CommonProxy {

    private boolean instantRespawn = false;
    public KeyBinding toggleInstantRespawn;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance()
            .bus()
            .register(this);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        toggleInstantRespawn = new KeyBinding("gog.InstantRespawn.keydesc", Keyboard.KEY_END, "Garden of Grind");
        ClientRegistry.registerKeyBinding(toggleInstantRespawn);
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (toggleInstantRespawn.isPressed()) {
            instantRespawn = !instantRespawn;
            Minecraft.getMinecraft().thePlayer
                .addChatMessage(new ChatComponentText("Instant respawn: " + instantRespawn));
        }
    }

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) {
        if (event.gui instanceof GuiGameOver && instantRespawn) {
            event.setCanceled(true);
            Minecraft.getMinecraft().thePlayer.respawnPlayer();
        }
    }
}
