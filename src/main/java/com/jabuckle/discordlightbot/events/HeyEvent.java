package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;

public class HeyEvent implements BotEvent {
    @Override
    public void doAction(MessageChannel channel) {
        channel.sendMessage("Hey! How are you doing?").queue();
    }
}
