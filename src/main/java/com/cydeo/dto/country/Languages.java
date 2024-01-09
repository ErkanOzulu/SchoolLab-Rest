
package com.cydeo.dto.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deu"
})
@Generated("jsonschema2pojo")
public class Languages {

    @JsonProperty("deu")
    private String deu;

    @JsonProperty("deu")
    public String getDeu() {
        return deu;
    }

    @JsonProperty("deu")
    public void setDeu(String deu) {
        this.deu = deu;
    }

}
