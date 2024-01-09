
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
public class NativeName {

    @JsonProperty("deu")
    private Deu deu;

    @JsonProperty("deu")
    public Deu getDeu() {
        return deu;
    }

    @JsonProperty("deu")
    public void setDeu(Deu deu) {
        this.deu = deu;
    }

}
