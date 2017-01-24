package edu.altstu.testapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.IntStream;

/**
 *
 * @author Евгений
 */
public class Main {

    private String address = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key=D7FD21E5F0C49A925E78DEA682AE4338&SteamIDs="
            + "(76561198074290718,76561198087274995,76561198281494851,76561198194103706)";

    private void work() {
        try {
            URL url = new URL(address);
//            URLConnection connection = url.openConnection();
//            InputStream inputStream = connection.getInputStream();
            
            ObjectMapper mapper = new ObjectMapper();
            
            Head response = mapper.readValue(url, Head.class);
            System.out.println(response);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
