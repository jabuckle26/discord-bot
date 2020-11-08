package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        //String messageText = event.getMessage().getContentRaw();
        MessageChannel channel = event.getChannel();
        channel.sendMessage("Here's a reply.... :) ").queue();
    }
}
