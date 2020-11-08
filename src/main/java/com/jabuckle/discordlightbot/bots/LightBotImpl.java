package com.jabuckle.discordlightbot.bots;

import com.jabuckle.discordlightbot.events.BotListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class LightBotImpl implements Bot {
    private String SECRET_TOKEN = "";
    private JDA jda;

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

    public void sendGreeting() {
        try {
            jda.getGuildById("")
                    .getTextChannelById("")
//                    .sendMessage("Hello world!")
                    .sendMessage("Hey <@>, whats up??")
                    .queue();
        } catch (Exception e) {
            System.out.println("Hit an error");
            System.out.println(e);
        }
    }
}
