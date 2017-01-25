package edu.altstu.testapi.matches;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.altstu.testapi.util.AddressMaker;
import java.net.URL;

/**
 *
 * @author gea
 */
public class MatchesService {

    public static String MyId32 = "127009267";
    private static final String apiInterface = "IDOTA2Match_570";
    private static final String matchHistoryMethod = "GetMatchHistory";
    private static final String version = "v1";
    private AddressMaker addressMaker = new AddressMaker(version, matchHistoryMethod, apiInterface);
    
    private final static String heroIdParameter = "hero_id";
    private final static String accountIdParameter = "account_id";
    
    public AllMatches getAllMatchesByHero(Integer heroId) {
        try {
            addressMaker.addParameter(accountIdParameter, MyId32);
            addressMaker.addParameter(heroIdParameter, heroId.toString());
            String result = addressMaker.getFullAddress();
            System.err.println("address " + result);
            URL url  = new URL(result);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
            AllMatches allMatches = mapper.readValue(url, AllMatches.class);
            return allMatches;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
