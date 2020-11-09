package com.jabuckle.discordlightbot.bots;

import com.jabuckle.discordlightbot.events.*;
import com.jabuckle.discordlightbot.utils.MessageHelper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        //ToDo: exclude messages with @

        String messageText = event.getMessage().getContentRaw();
        if (MessageHelper.hasCommandFlag(messageText)) {
            System.out.println("Command Entered");
            String parsedCommand = MessageHelper.getProvidedCommand(messageText);
            if (MessageHelper.isValidCommand(parsedCommand)) {
                System.out.println("Valid command!");
                System.out.println(parsedCommand);
                BotEvent eventCommand = EventFactory.getEventType(parsedCommand);
                eventCommand.doAction(event.getChannel());
            }
        }
    }
}
