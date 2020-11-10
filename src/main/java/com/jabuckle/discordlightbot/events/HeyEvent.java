package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class HeyEvent implements BotEvent {
    @Override
    public void doAction(MessageChannel channel, List<String> commandParams) {
        channel.sendMessage("Hey! How are you doing?").queue();
    }

    @Override
    public boolean verifyCommandParams(List<String> commandParams) {
        return commandParams.size() == 0;
    }
}
