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
import java.util.List;

// it is just mainte the order of json body
@JsonPropertyOrder({
        "id",
        "Firstname",
        "Lastename",
        "Age",
        "Emailid",
        "Addres",
        "Skils"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true) //any field did not here just igroe the filed frome server
@JsonInclude(JsonInclude.Include.NON_NULL) // this line just skip null value to json server
public class Userpayload implements Serializable {

    // when try post request dont need this id
    @JsonProperty("id") // this is speeling macth to the json server body
    private String Id;  // here we can use the name or with speeling miskess

    @JsonProperty("Firstname")
    private String firstName;

    @JsonProperty("Lastename")
    private String lastName;

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Emailid")
    private String emailid;

    @JsonProperty("Addres")
    private Addrespayload addres;

    @JsonProperty("Skils")
    private List<Skillpayload> skils; // advanced method


}
