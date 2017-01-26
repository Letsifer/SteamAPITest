package edu.altstu.testapi.matches;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.altstu.testapi.BasicService;
import edu.altstu.testapi.herous.HeroesService;
import edu.altstu.testapi.users.UsersService;
import edu.altstu.testapi.util.AddressMaker;
import edu.altstu.testapi.util.Util;
import java.net.URL;

/**
 *
 * @author gea
 */
public class MatchesService extends BasicService {

    private static final String apiInterface = "IDOTA2Match_570";
    private static final String matchHistoryMethod = "GetMatchHistory";
    private static final String version = "v1";

    private final static String heroIdParameter = "hero_id";
    private final static String accountIdParameter = "account_id";

    private UsersService usersService = new UsersService();
//    private HeroesService heroesService = new HeroesService();

    public AllMatches getAllUsersMatchesByHero(Long userId32, Integer heroId) {
        try {
            addParameter(accountIdParameter, userId32.toString());
            addParameter(heroIdParameter, heroId.toString());
            URL url = getUrl();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
            AllMatches allMatches = mapper.readValue(url, AllMatches.class);
            return allMatches;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String printMatchResult(Match match) {
        StringBuffer buffer = new StringBuffer("Match #");
//        System.err.println("Match checking number is " + match.getId());
        buffer.append(match.getId()).append("\n");
        buffer.append("Starts on").append(match.getStartTime()).append("\n");
        buffer.append("Players list\n");
        match.getPlayers().stream()
                .forEach(player -> {
                    System.err.println("32bitid = " + player.getId());
                    Long newId = Util.convert32BitIdTo64Bit(player.getId());
                    System.err.println("64newId = " + newId);
                    edu.altstu.testapi.users.Player user = usersService.getPlayer(newId);
                    System.err.println("user personalName = " + (user == null || user.getPersonaname() == null ? "ouuups" : user.getPersonaname()));
                    buffer
                            .append("Player ")
                            .append(user == null ? "!!!noname!!!" : user.getPersonaname())
                            .append(" playes in slot")
                            .append(player.getSlot())
                            .append(" on hero ")
                            .append(player.getHero())
                            .append("\n");
                });
        buffer.append("------------------------------------------------------------");
        return buffer.toString();
    }

    @Override
    protected String getApiInterface() {
        return apiInterface;
    }

    @Override
    protected String getMethod() {
        return matchHistoryMethod;
    }

    @Override
    protected String getVersion() {
        return version;
    }

}
