package com.jabuckle.discordlightbot.events;

import net.dv8tion.jda.api.entities.MessageChannel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class StatEvent implements BotEvent {

    private final String pokeAPIURI = "https://pokeapi.co/api/v2/pokemon/";
    private HashMap<String, Integer> requestedStats = new HashMap<String, Integer>();
    //Note typo in "defense" - from to PokeAPI
    private List<String> orderOfStats = Arrays.asList(new String[]{"hp", "attack", "defense", "special-attack", "special-defense", "speed"});

    @Override
    public void doAction(MessageChannel channel, List<String> commandParams) throws IOException, InterruptedException, JSONException {
        if (!verifyCommandParams(commandParams)) return;

        HttpResponse<String> statResponse = requestStatData(commandParams.get(0));

        switch (statResponse.statusCode()) {
            case 200:
                parseStatsFromResponse(statResponse);
                channel.sendMessage(getBotResponseOfStats(commandParams.get(0))).queue();
                break;
            case 404:
                channel.sendMessage("Who's that Pokemon? Enter a valid pokemon name with command. e.g $stat Pikachu").queue();
                break;
            default:
                channel.sendMessage("Internal Error: Unable to get this Pokemon's stats. Try again later!").queue();
                break;
        }
    }

    private HttpResponse<String> requestStatData(String pokemonToRrequest) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(pokeAPIURI + pokemonToRrequest))
                .build();
        HttpResponse<String> res = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(res);

        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private void parseStatsFromResponse(HttpResponse<String> textToParse) throws JSONException {
        JSONObject jsonObj = new JSONObject(textToParse.body());
        JSONArray statsArray = (JSONArray) jsonObj.get("stats");
        for (int i = 0; i < statsArray.length(); i++) {
            String statName = (String) statsArray.getJSONObject(i).getJSONObject("stat").get("name");
            Integer statVal = (Integer) statsArray.getJSONObject(i).get("base_stat");
            requestedStats.put(statName, statVal);
        }
    }

    private String getBotResponseOfStats(String requestedPokemon) {
        String botResponse = requestedPokemon.substring(0,1).toUpperCase() + requestedPokemon.substring(1) +" has the following base stats: \n";
        for (String stat: orderOfStats) {
            botResponse += stat +": " + requestedStats.get(stat) + "\n";
        }
        return botResponse;
    }

    @Override
    public boolean verifyCommandParams(List<String> commandParams) {
        return commandParams.size() == 1;
    }
}
