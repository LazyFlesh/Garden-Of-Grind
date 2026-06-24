package com.LazyFlesh.GardenOfGrindMod.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class GardenOfGrindCommands extends CommandBase {

    @Override
    public String getCommandName() {
        return "gog";
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("GardenOfGrind", "gardenofgrind", "GoG");
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/gog <mode|dragonfight> [args...]";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 1) {
            printHelpFull(sender);
            return;
        }
        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "add": {
                if (sender.canCommandSenderUseCommand()) {
                    sender.addChatMessage(new ChatComponentTranslation("commands.error.perm"));
                    break;
                }

                if (args.length != 3) {
                    throw new WrongUsageException("/energy_network add <username> <EU>");
                }
            }
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        List<String> completions = new ArrayList<>();
        String currentArg = args.length == 0 ? "" : args[args.length - 1].trim();

        if (args.length == 1) {
            Stream.of("mode", "dragontime")
                .filter(s -> s.startsWith(currentArg))
                .forEach(completions::add);
        } else if (args.length == 2) {
            String subCommand = args[0].toLowerCase();
            if ("mode".equals(subCommand)) {
                Stream.of("GardenOfGrind", "GardenOfGrindless", "Skyblock", "QuestlessGardenOfGrind")
                    .filter(s -> s.startsWith(currentArg))
                    .forEach(completions::add);
            } else if ("dragontime".equals(subCommand)) {
                Stream.of("true", "false")
                    .filter(s -> s.startsWith(currentArg))
                    .forEach(completions::add);
            }
        }

        return completions;
    }

    private void printHelpFull (ICommandSender sender) {
        sender.addChatMessage(new ChatComponentText("Usage: /gog <subcommand> [args...]"));
        sender.addChatMessage(new ChatComponentText(" Subcommands:"));
        sender.addChatMessage(
            new ChatComponentText(
                "  mode <mode> - Set Garden Of Grind mode to <mode> (requires permission level 2)"));
        sender.addChatMessage(
            new ChatComponentText(
                "  dragontime <true/false> - Turns modded chunk population on/off. Requires server restart. (requires permission level 2)"));
    }
}

