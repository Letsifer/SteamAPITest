package edu.altstu.testapi.matches;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@JsonRootName("result")
@Getter
@Setter
public class AllMatches {

    private Integer status;
    @JsonProperty("num_results")
    private String numResults;
    @JsonProperty("total_results")
    private String totalResults;
    @JsonProperty("results_remaining")
    private String resultsRemaining;

    private List<Match> matches = new ArrayList<>();

    @Override
    public String toString() {
        String result = numResults + " of " + totalResults + "\n";
        StringBuffer buffer = new StringBuffer(result);
        matches.stream().forEach(match -> buffer.append(match).append("------------------------------------------\n"));
        return buffer.toString();
    }

}
