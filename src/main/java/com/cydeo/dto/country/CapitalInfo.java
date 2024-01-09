
package com.cydeo.dto.country;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latlng"
})
@Generated("jsonschema2pojo")
public class CapitalInfo {

    @JsonProperty("latlng")
    private List<Double> latlng;

    @JsonProperty("latlng")
    public List<Double> getLatlng() {
        return latlng;
    }

    @JsonProperty("latlng")
    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

}
