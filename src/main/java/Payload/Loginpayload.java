package Payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = false) //any field did not here
@JsonInclude(JsonInclude.Include.NON_NULL) // this line just skip null value to json server
public class Loginpayload implements Serializable {

    // this is for post method to put key and value in

    /*
     * JSONObject jsonObject = new JSONObject();
     *
     * jsonObject.put("email", "eve.holt@reqres.in");
     *
     * jsonObject.put("password", "cityslicka");
     */

    private String Email;
    private String password;
}
