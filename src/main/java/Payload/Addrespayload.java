package Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@JsonPropertyOrder({
        "City",
        "Landmark",
        "District"
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = false)//any field did not here
@JsonInclude(JsonInclude.Include.NON_NULL) // this line just skip null value to json server
public class Addrespayload implements Serializable {

    @JsonProperty("City")
    private String city;

    @JsonProperty("LandMark")
    private String landmark;

    @JsonProperty("District")
    private String district;


}
