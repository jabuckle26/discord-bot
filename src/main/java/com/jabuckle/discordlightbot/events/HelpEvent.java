package com.jabuckle.discordlightbot.events;

import com.jabuckle.discordlightbot.bots.SupportedCommands;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.apache.commons.lang3.EnumUtils;

import java.util.List;

public class HelpEvent implements BotEvent {

    public void doAction(MessageChannel channel, List<String> commandParams) {
        channel.sendMessage("You can run the following commands... \r\n" + getSupportedCommandsAsString()).queue();
    }

    @Override
    public boolean verifyCommandParams(List<String> commandParams) {
        return commandParams.size() == 0;
    }

    public  String getSupportedCommandsAsString() {
        List<SupportedCommands> allCommands = EnumUtils.getEnumList(SupportedCommands.class);
        String commandsAsMessage = "";

        for (SupportedCommands command: allCommands) {
            commandsAsMessage += command.getExample() + " : " + command.getDescription() + "\r\n" ;
        }

        return commandsAsMessage;
    }
}
