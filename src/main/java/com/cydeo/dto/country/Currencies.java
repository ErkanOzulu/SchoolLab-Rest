
package com.cydeo.dto.country;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EUR"
})
@Generated("jsonschema2pojo")
public class Currencies {

    @JsonProperty("EUR")
    private Eur eur;

    @JsonProperty("EUR")
    public Eur getEur() {
        return eur;
    }

    @JsonProperty("EUR")
    public void setEur(Eur eur) {
        this.eur = eur;
    }

}
