package com.jabuckle.discordlightbot.restcontroller;
import com.jabuckle.discordlightbot.bots.Bot;
import com.jabuckle.discordlightbot.events.BotEvent;
import com.jabuckle.discordlightbot.events.EventFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class BotRestController {

    @Autowired
    Bot theBot;

//    @RequestMapping(value="/send", method = RequestMethod.POST)
//    public void sendBotMessageToRoom(@RequestBody String message) {
//        System.out.println("POST Message request received.");
//        System.out.println(message);
//    }

    //Create a sub folder in events (rest events?)
    //Replace the sendGreeting method on the bot with an event here
    @GetMapping(value = "/greet", produces = "application/json")
    public void getGreeting() {
        System.out.println("GET request received.");
        theBot.sendGreeting();
    }
}
