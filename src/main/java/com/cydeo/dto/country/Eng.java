
package com.cydeo.dto.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "f",
    "m"
})
@Generated("jsonschema2pojo")
public class Eng {

    @JsonProperty("f")
    private String f;
    @JsonProperty("m")
    private String m;

    @JsonProperty("f")
    public String getF() {
        return f;
    }

    @JsonProperty("f")
    public void setF(String f) {
        this.f = f;
    }

    @JsonProperty("m")
    public String getM() {
        return m;
    }

    @JsonProperty("m")
    public void setM(String m) {
        this.m = m;
    }

}
