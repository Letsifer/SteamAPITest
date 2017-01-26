package edu.altstu.testapi.users;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Евгений
 */
@JsonRootName("response")
@Getter
@Setter
public class AllPlayers {

    private List<Player> players = new ArrayList<>();

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("Players:\n");
        players.stream()
                .forEach(player -> {
                    buffer.append(player.toString()).append("\n");
                });
        return buffer.toString();
    }

}
