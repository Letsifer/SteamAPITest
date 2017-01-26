package edu.altstu.testapi.herous;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.altstu.testapi.BasicService;
import java.net.URL;
import java.util.List;

/**
 *
 * @author gea
 */
public class HeroesService extends BasicService{

    //private final String address = "http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1/?key=D7FD21E5F0C49A925E78DEA682AE4338&language=ru";

    private List<Hero> heroes;

    public List<Hero> getHeroes() {
        if (heroes == null) {
            try {
                addParameter("language", "ru");
                URL url = getUrl();
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
                Result result = mapper.readValue(url, Result.class);
                heroes = result.getHeroes();
            } catch (Exception e) {
                System.err.println("Esceprion in heroes service " + e);
            }
        }
        return heroes;
    }
    
    public Hero getHeroById(Integer id) {
        return getHeroes()
                .stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    protected String getApiInterface() {
        return "IEconDOTA2_570";
    }

    @Override
    protected String getMethod() {
        return "GetHeroes";
    }

    @Override
    protected String getVersion() {
        return "v1";
    }

}
