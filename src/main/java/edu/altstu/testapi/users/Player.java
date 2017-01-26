package edu.altstu.testapi.users;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import javafx.util.converter.LocalDateTimeStringConverter;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Евгений
 */
@Getter
@Setter
public class Player {
    private String steamid;
    private Integer communityvisibilitystate;
    private Integer profilestate;
    private String personaname;
    private Integer lastlogoff;
    private String profileurl;
    private String avatar;
    private String avatarmedium;
    private String avatarfull;
    private Integer personastate;
    private String primaryclanid;
    private Long timecreated;
    private String personastateflags;
    private String gameextrainfo;
    private String gameid;
    private Integer commentpermission;
    private String realname;
    private String loccountrycode;
    private String locstatecode;
    private Integer loccityid;

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Id ").append(steamid).append("\n");
        buffer.append("Nickname ").append(personaname).append("\n");
        buffer.append("Real name ").append(realname).append("\n");
//        System.out.println(timecreated);
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timecreated), ZoneId.systemDefault());
        buffer.append("Registration date ").append(dateTime.toString()).append("\n");
        buffer.append("----------------------------------------").append("\n");
        return buffer.toString();
    }    
}
