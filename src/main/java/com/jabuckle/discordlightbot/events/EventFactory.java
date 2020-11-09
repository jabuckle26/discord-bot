package com.jabuckle.discordlightbot.events;

public class EventFactory {

    public static BotEvent getEventType(String command) {
        switch (command) {
            case "HELP":
                return new HelpEvent();
            case "STAT":
                return new StatEvent();
            case "HEY":
                return new HeyEvent();
            case "SUNSHINE":
                return new SunshineEvent();
            default:
                return null;
        }
    }
}
