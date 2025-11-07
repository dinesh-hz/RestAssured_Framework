package utilities;

import Payload.Userpayload;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.io.File;

public class DynamicVerifiertojson {

    public static void verifyUserById(Response response, String userid) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/test/resources/testdata/db.json");  // use passed path

            JsonNode jsonNode = mapper.readTree(file);

            // find user by id
            JsonNode usersjsonbody = null;
            for (JsonNode node : jsonNode.get("employees")) {  // <-- if array is inside "employees"
                if (node.has("id") && node.get("id").asText().equals(userid)) {
                    usersjsonbody = node;
                    break;
                }
            }

            if (usersjsonbody == null) {
                throw new RuntimeException("User with id " + userid + " not found in JSON");
            }

            Userpayload expectedUser = mapper.treeToValue(usersjsonbody, Userpayload.class);
            Userpayload actualUser = mapper.readValue(response.asString(), Userpayload.class);

            Assertions.assertThat(actualUser)
                    .usingRecursiveComparison()
                 // .ignoringFields("firstname")
                    .isEqualTo(expectedUser);
        } catch (Exception e) {
            throw new RuntimeException("Failed to dynamically verify response", e);
        }
        }
}
