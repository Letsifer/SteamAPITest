package edu.altstu.testapi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import edu.altstu.testapi.matches.PlayerSlot;
import edu.altstu.testapi.matches.Side;
import java.io.IOException;

/**
 *
 * @author gea
 */
public class PlayerSlotJsonDeserializer extends JsonDeserializer<PlayerSlot>{

    @Override
    public PlayerSlot deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        PlayerSlot playerSlot = new PlayerSlot();
        Integer value = jp.getIntValue();
        playerSlot.setSide(value > 128 ? Side.Dire : Side.Radiant);
        playerSlot.setSlot(value % 8);
        return playerSlot;
    }
    
}
