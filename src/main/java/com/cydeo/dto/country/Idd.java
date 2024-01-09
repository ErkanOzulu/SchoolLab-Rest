
package com.cydeo.dto.country;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "root",
    "suffixes"
})
@Generated("jsonschema2pojo")
public class Idd {

    @JsonProperty("root")
    private String root;
    @JsonProperty("suffixes")
    private List<String> suffixes;

    @JsonProperty("root")
    public String getRoot() {
        return root;
    }

    @JsonProperty("root")
    public void setRoot(String root) {
        this.root = root;
    }

    @JsonProperty("suffixes")
    public List<String> getSuffixes() {
        return suffixes;
    }

    @JsonProperty("suffixes")
    public void setSuffixes(List<String> suffixes) {
        this.suffixes = suffixes;
    }

}
