package edu.altstu.testapi.matches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.altstu.testapi.herous.Hero;
import edu.altstu.testapi.util.HeroJsonDeserializer;
import edu.altstu.testapi.util.PlayerSlotJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
public class Player {
    @JsonProperty("account_id")
    private Long id;
    
    @JsonProperty("player_slot")
    @JsonDeserialize(using = PlayerSlotJsonDeserializer.class)
    private PlayerSlot slot;
    
    @JsonProperty("hero_id")
    @JsonDeserialize(using = HeroJsonDeserializer.class)
    private Hero hero; 

    @Override
    public String toString() {
        return "Player with id " + id + " in " + slot + " on hero " + hero;
    }
}
