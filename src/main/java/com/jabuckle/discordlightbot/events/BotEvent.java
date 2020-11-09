package com.jabuckle.discordlightbot.events;

import com.jabuckle.discordlightbot.bots.Bot;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.springframework.beans.factory.annotation.Autowired;

public interface BotEvent {

    public void doAction(MessageChannel channel);

}
