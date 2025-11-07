package Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;


@JsonPropertyOrder({
        "id",
        "firstname",
        "lastename",
        "age",
        "emailid",
        "addres",
        "skils"
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Userpayload implements Serializable {

    @JsonProperty("id")
    private String id;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastename")
    private String lastename;

    @JsonProperty("age")
    private int Age;

    @JsonProperty("emailid")
    private String Emailid;

    @JsonProperty("addres")
    private Addrespayload addres;

    @JsonProperty("skils")
    private List<Skillpayload> skils; // advanced method

    //  private  List<String> skiles; // output :  "skills": ["Java", "Selenium", "API Testing"]
//        List<String> skills = Arrays.asList("Java", "Selenium", "API Testing");
}
