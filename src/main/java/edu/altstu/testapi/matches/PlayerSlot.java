package edu.altstu.testapi.matches;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
public class PlayerSlot {
    private Side side;
    
    private Integer slot;

    @Override
    public String toString() {
        return "team " + side.name() + " and slot " + slot;
    }
}
