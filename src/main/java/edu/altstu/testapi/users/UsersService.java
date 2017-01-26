package edu.altstu.testapi.users;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.altstu.testapi.BasicService;
import java.net.URL;

/**
 *
 * @author gea
 */
public class UsersService extends BasicService {

    public Player getPlayer(Long playerId) {
        try {
            addParameter("steamIds", playerId.toString());
            URL url = getUrl();
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
            AllPlayers response = mapper.readValue(url, AllPlayers.class);
            return response.getPlayers().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected String getApiInterface() {
        return "ISteamUser";
    }

    @Override
    protected String getMethod() {
        return "GetPlayerSummaries";
    }

    @Override
    protected String getVersion() {
        return "v2";
    }

}
