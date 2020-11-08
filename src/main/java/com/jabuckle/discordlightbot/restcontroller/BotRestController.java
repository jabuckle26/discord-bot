package com.jabuckle.discordlightbot.restcontroller;
import com.jabuckle.discordlightbot.bots.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BotRestController {

    @Autowired
    Bot theBot;

//    @RequestMapping(value="/send", method = RequestMethod.POST)
//    public void sendBotMessageToRoom(@RequestBody String message) {
//        System.out.println("POST Message request received.");
//        System.out.println(message);
//    }

    @GetMapping(value = "/greet", produces = "application/json")
    public void getGreeting() {
        System.out.println("GET request received.");
        theBot.sendGreeting();
    }
}
