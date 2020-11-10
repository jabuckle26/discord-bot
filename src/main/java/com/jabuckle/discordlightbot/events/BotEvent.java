package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface BotEvent {

    public void doAction(MessageChannel channel, List<String> commandParams) throws IOException, InterruptedException, JSONException;

    public boolean verifyCommandParams(List<String> commandParams);

}
