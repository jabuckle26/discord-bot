package com.jabuckle.discordlightbot.bots;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class LightBotImpl implements Bot {
    private String SECRET_TOKEN = "Nzc1MDM1Mzc1ODMxMDg5MTkz.X6gd8Q.Jn_DRaRxZxmTD3K9RVS0IwS6IEw";
    private JDA jda;
    private String guildId = "775038095648882688";
    private String channelId = "775038095648882692";
    private String userId = "339461936104341505";

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
//                    .sendMessage("Hello world!")
                    .sendMessage(message)
                    .queue();
        } catch (Exception e) {
            System.out.println("Hit an error");
            System.out.println(e);
        }
    }

    public void sendGreeting() {
        sendMessage("Hey <@" + userId + ">, whats up??");
    }

    public void respondToHelpCommand() {
        sendMessage("Helping you.....");
    }
}
