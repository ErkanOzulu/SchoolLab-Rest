
package com.cydeo.dto.country;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "signs",
    "side"
})
@Generated("jsonschema2pojo")
public class Car {

    @JsonProperty("signs")
    private List<String> signs;
    @JsonProperty("side")
    private String side;

    @JsonProperty("signs")
    public List<String> getSigns() {
        return signs;
    }

    @JsonProperty("signs")
    public void setSigns(List<String> signs) {
        this.signs = signs;
    }

    @JsonProperty("side")
    public String getSide() {
        return side;
    }

    @JsonProperty("side")
    public void setSide(String side) {
        this.side = side;
    }

}
