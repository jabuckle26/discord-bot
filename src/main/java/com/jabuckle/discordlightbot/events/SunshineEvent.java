package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class SunshineEvent implements BotEvent {
    @Override
    public void doAction(MessageChannel channel, List<String> commandParams) {
        channel.sendMessage("You are my sunshine!").queue();
    }

    @Override
    public boolean verifyCommandParams(List<String> commandParams) {
        return commandParams.size() == 0;
    }
}
