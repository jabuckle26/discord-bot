package com.jabuckle.discordlightbot.bots;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SupportedCommands {
    HELP ("/help", "A help command"),
    STAT ("/stat", "Command to get a pokemon stats."),
    HEY ("/hey", "Command to make the bot say hi."),
    SUNSHINE ("/sunshine", "Command to brighten your day.");

    public String example;
    public String description;

    SupportedCommands(String example, String description) {
        this.example = example;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getExample() {
        return example;
    }
}
