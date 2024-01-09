
package com.cydeo.dto.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "googleMaps",
    "openStreetMaps"
})
@Generated("jsonschema2pojo")
public class Maps {

    @JsonProperty("googleMaps")
    private String googleMaps;
    @JsonProperty("openStreetMaps")
    private String openStreetMaps;

    @JsonProperty("googleMaps")
    public String getGoogleMaps() {
        return googleMaps;
    }

    @JsonProperty("googleMaps")
    public void setGoogleMaps(String googleMaps) {
        this.googleMaps = googleMaps;
    }

    @JsonProperty("openStreetMaps")
    public String getOpenStreetMaps() {
        return openStreetMaps;
    }

    @JsonProperty("openStreetMaps")
    public void setOpenStreetMaps(String openStreetMaps) {
        this.openStreetMaps = openStreetMaps;
    }

}
