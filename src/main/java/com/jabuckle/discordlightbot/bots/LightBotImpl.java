package com.jabuckle.discordlightbot.bots;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class LightBotImpl implements Bot {
    private String SECRET_TOKEN = "SECRET TOKEN";
    private JDA jda;
    private String guildId = "<SECRET ID>";
    private String channelId = "<SECRET ID>";
    private String userId = "<SECRET ID>";

    public LightBotImpl() throws LoginException {
        try {
            jda = JDABuilder.createDefault(SECRET_TOKEN)
                    .addEventListeners(new BotListener())
                    .build();
        }
        catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            jda.getGuildById(guildId)
                    .getTextChannelById(channelId)
                    .sendMessage(message)
                    .queue();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sendGreeting() {
        sendMessage("Hey <@" + userId + ">, whats up??");
    }
}
