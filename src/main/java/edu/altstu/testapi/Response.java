package edu.altstu.testapi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Евгений
 */
public class Response {
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

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
