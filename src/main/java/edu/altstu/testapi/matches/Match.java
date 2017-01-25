package edu.altstu.testapi.matches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.altstu.testapi.util.JsonDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
public class Match {

    @JsonProperty("match_id")
    private Long id;

    @JsonProperty("start_time")
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime startTime;

    @JsonProperty("players")
    private List<Player> players;

    @JsonProperty("match_seq_num")
    private Long matchSeqNum;

    @JsonProperty("lobby_type")
    private Integer lobbyType;
    @JsonProperty("radiant_team_id")
    private Integer radiantTeamId;
    @JsonProperty("dire_team_id")
    private Integer direTeamId;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("Match #");
        buffer.append(id).append("\n");
        buffer.append("Starts on").append(startTime).append("\n");
        buffer.append("Players list\n");
        players.stream()
                .forEach(player -> buffer.append(player).append("\n"));
        return buffer.toString();
    }

}

/*
@JacksonXmlProperty(isAttribute = true, localName =  "DateTime")
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @JsonDeserialize(using = DateTimeJsonDeserializer.class)
    private LocalDateTime dateTime;
*/
