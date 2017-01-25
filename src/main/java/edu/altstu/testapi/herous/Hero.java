package edu.altstu.testapi.herous;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author gea
 */
@Getter
@Setter
public class Hero {
    private Integer id;
    
    private String name;
    
    @JsonProperty("localized_name")
    private String localizedName;

    @Override
    public String toString() {
        return localizedName;
    }
}
