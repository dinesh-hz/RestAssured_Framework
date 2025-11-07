package Payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
