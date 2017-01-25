package edu.altstu.testapi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import edu.altstu.testapi.herous.Hero;
import edu.altstu.testapi.herous.HeroesService;
import java.io.IOException;

/**
 *
 * @author gea
 */
public class HeroJsonDeserializer extends JsonDeserializer<Hero> {

    private HeroesService heroesService = new HeroesService();
    
    @Override
    public Hero deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        Integer value = jp.getIntValue();
        return heroesService.getHeroById(value);
    }

}
