package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;

public class StatEvent implements BotEvent {
    @Override
    public void doAction(MessageChannel channel) {
        channel.sendMessage("Lets get some stats").queue();
    }
}
