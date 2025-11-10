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
            File file = new File("src/test/resources/testdata/db.json");

            JsonNode jsonNode = mapper.readTree(file);

            // find user by id
            JsonNode userbody = null;
            for (JsonNode node : jsonNode.get("employees")) {  // <-- if array is inside "employees"
                if (node.has("id") && node.get("id").asText().equals(userid)) {
                    userbody = node;
                    break;
                }
            }

            if (userbody == null) {
                throw new RuntimeException("User with id " + userid + " not found in JSON");
            }

            Userpayload expectedUser = mapper.treeToValue(userbody, Userpayload.class);
            Userpayload actualUser = mapper.readValue(response.asString(), Userpayload.class);

            Assertions.assertThat(actualUser)
                    .usingRecursiveComparison()
                  //  .ignoringFields("firstname", "Age")
                    .isEqualTo(expectedUser);
        } catch (Exception e) {
            throw new RuntimeException("Failed to dynamically verify response", e);
        }
    }
}
