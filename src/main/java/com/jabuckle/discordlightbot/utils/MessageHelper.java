package com.jabuckle.discordlightbot.utils;

import com.jabuckle.discordlightbot.bots.SupportedCommands;
import org.apache.commons.lang3.EnumUtils;

public class MessageHelper {

    public static boolean isValidCommand(String commandToCheck) {
        return EnumUtils.isValidEnum(SupportedCommands.class, commandToCheck);
    };

    public static boolean hasCommandFlag(String messageText) {
        System.out.println(messageText.startsWith("$"));
        return messageText.startsWith("$");
    };

    public static String getProvidedCommand(String messageText) {
        String[] splitString = messageText.split("\\s+");
        return splitString[0].substring(1).toUpperCase();
    };
}
