package edu.altstu.testapi.herous;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
@JsonRootName(value = "result")
public class Result {
    private List<Hero> heroes;
    
    private Integer count;
    
    private Integer status;
}
