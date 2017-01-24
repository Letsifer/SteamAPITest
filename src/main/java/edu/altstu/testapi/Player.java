package edu.altstu.testapi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Date;
import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Евгений
 */
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
    private Integer locstatecode;
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

    
    
    public Integer getLoccityid() {
        return loccityid;
    }

    public void setLoccityid(Integer loccityid) {
        this.loccityid = loccityid;
    }
    

    public Integer getLocstatecode() {
        return locstatecode;
    }

    public void setLocstatecode(Integer locstatecode) {
        this.locstatecode = locstatecode;
    }
    

    public String getLoccountrycode() {
        return loccountrycode;
    }

    public void setLoccountrycode(String loccountrycode) {
        this.loccountrycode = loccountrycode;
    }
    
    

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
    
    

    public Integer getCommentpermission() {
        return commentpermission;
    }

    public void setCommentpermission(Integer commentpermission) {
        this.commentpermission = commentpermission;
    }
    

    public String getSteamid() {
        return steamid;
    }

    public void setSteamid(String steamid) {
        this.steamid = steamid;
    }

    public Integer getCommunityvisibilitystate() {
        return communityvisibilitystate;
    }

    public void setCommunityvisibilitystate(Integer communityvisibilitystate) {
        this.communityvisibilitystate = communityvisibilitystate;
    }

    public Integer getProfilestate() {
        return profilestate;
    }

    public void setProfilestate(Integer profilestate) {
        this.profilestate = profilestate;
    }

    public String getPersonaname() {
        return personaname;
    }

    public void setPersonaname(String personaname) {
        this.personaname = personaname;
    }

    public Integer getLastlogoff() {
        return lastlogoff;
    }

    public void setLastlogoff(Integer lastlogoff) {
        this.lastlogoff = lastlogoff;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarmedium() {
        return avatarmedium;
    }

    public void setAvatarmedium(String avatarmedium) {
        this.avatarmedium = avatarmedium;
    }

    public String getAvatarfull() {
        return avatarfull;
    }

    public void setAvatarfull(String avatarfull) {
        this.avatarfull = avatarfull;
    }

    public Integer getPersonastate() {
        return personastate;
    }

    public void setPersonastate(Integer personastate) {
        this.personastate = personastate;
    }

    public String getPrimaryclanid() {
        return primaryclanid;
    }

    public void setPrimaryclanid(String primaryclanid) {
        this.primaryclanid = primaryclanid;
    }

    public Long getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(Long timecreated) {
        this.timecreated = timecreated;
    }

    public String getPersonastateflags() {
        return personastateflags;
    }

    public void setPersonastateflags(String personastateflags) {
        this.personastateflags = personastateflags;
    }

    public String getGameextrainfo() {
        return gameextrainfo;
    }

    public void setGameextrainfo(String gameextrainfo) {
        this.gameextrainfo = gameextrainfo;
    }

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }
    
    
}
