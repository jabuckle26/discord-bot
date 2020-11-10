package com.jabuckle.discordlightbot.bots;

import com.jabuckle.discordlightbot.events.*;
import com.jabuckle.discordlightbot.utils.MessageHelper;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        //ToDo: exclude messages with @

        String messageText = event.getMessage().getContentRaw();
        if (MessageHelper.hasCommandFlag(messageText)) {
            String parsedCommand = MessageHelper.getProvidedCommand(messageText);
            if (MessageHelper.isValidCommand(parsedCommand)) {
                List<String> commandParams = MessageHelper.getSubmittedCommandParameters(messageText);
                BotEvent eventCommand = EventFactory.getEventType(parsedCommand);
                if (eventCommand.verifyCommandParams(commandParams)) {
                    try {
                        eventCommand.doAction(event.getChannel(), commandParams);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    event.getChannel().sendMessage("Invalid number of paramerters submmitted for this command. Please use $help for more info").queue();
                }
            }
        }
    }
}
