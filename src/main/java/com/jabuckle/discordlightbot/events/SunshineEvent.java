package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;

public class SunshineEvent implements BotEvent {
    @Override
    public void doAction(MessageChannel channel) {
        channel.sendMessage("You are my sunshine!").queue();
    }
}
