package edu.altstu.testapi;

import edu.altstu.testapi.users.Head;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.altstu.testapi.herous.Hero;
import edu.altstu.testapi.herous.HeroesService;
import edu.altstu.testapi.matches.AllMatches;
import edu.altstu.testapi.matches.MatchesService;
import edu.altstu.testapi.users.UsersService;
import edu.altstu.testapi.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Евгений
 */
public class Main {

//    private String address = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key=D7FD21E5F0C49A925E78DEA682AE4338&SteamIDs="
//            + "(76561198074290718,76561198087274995,76561198281494851,76561198194103706)";
    private String address = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?";

//    public String[] getIds() {
//        return new String[]{"8074290718", "8087274995", "8281494851", " 8194103706)"};
//    }
//
//    public String convertIdTo64(String id) {
//        return "7656119" + id;
//    }
//
//    public String getKey() {
//        return "D7FD21E5F0C49A925E78DEA682AE4338";
//    }
//
//    public String getKeyParameter() {
//        return "key=" + getKey();
//    }
//
//    public String getSteamIdsParameter() {
//        String[] ids = getIds();
//        int index = new Random().nextInt(ids.length);
//        return "steamids=" + convertIdTo64(ids[index]);
//    }
//
    private void work() {
        try {
            UsersService usersService = new UsersService();
            System.out.println(usersService.getPlayer(76561198074290718L));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private String matchId = "2927748513";
//
//    private void getMatchDetails() {
////        String matchAddress = "http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1/?";
////        matchAddress += getKeyParameter();
////        matchAddress += "&match_id=" + matchId;
//        try {
////            URL url = new URL(matchAddress);
////            URLConnection connection = url.openConnection();
////            InputStream inputStream = connection.getInputStream();
////
////            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
////
////            String line = null;
////            while ((line = reader.readLine()) != null) {
////                System.out.println(line);
////            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    private void getHerousDetails() {
        List<Hero> heroes = new HeroesService().getHeroes().stream().sorted((hero1, hero2) -> hero1.getId().compareTo(hero2.getId())).collect(Collectors.toList());
        System.out.println("size = " + heroes.size());
        for (int i = 1; i < heroes.size(); i++) {
            if (heroes.get(i).getId() != heroes.get(i - 1).getId() + 1) {
                System.out.println("not found between " + heroes.get(i).getId() + " and " + heroes.get(i - 1).getId());
            }
        }
        heroes
                .stream()
                //.sorted((hero1, hero2) -> hero1.getLocalizedName().compareTo(hero2.getLocalizedName()))

                .forEach(hero -> System.out.println(hero));
    }

    public void printUsersGamesOnHero() {
        Integer heroId = 4;
        Long user = 127009267L;
        MatchesService matchesService = new MatchesService();
        matchesService
                .getAllUsersMatchesByHero(user, heroId)
                .getMatches()
                .stream()
                .forEach(match -> System.out.println(matchesService.printMatchResult(match)));

    }

    public void testConvertTo64() {
        Long user = 127009267L;
        System.out.println(Util.convert32BitIdTo64Bit(user));
    }

    public static void main(String[] args) {
//        new Main().work();
        new Main().printUsersGamesOnHero();
//        new Main().getHerousDetails();
//        new Main().testConvertTo64();
    }
}
