package utilities;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestContext {

    private Response getResponse;
    private Response postResponse;
    private Response patchResponse;
    private Response putResponse;
    private Response deleteResponse;
    private String currentUserId; //  get and can use delete user id
    private String updataUserId; // patch and put


}
