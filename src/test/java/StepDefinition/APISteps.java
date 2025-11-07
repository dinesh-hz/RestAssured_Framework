/*
package StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.json.JSONObject;
import utilities.Bass_utiles;
import utilities.TestContext;

import java.util.Map;

public class APISteps {
    private final TestContext context;

    public APISteps(TestContext context) {
        this.context = context;
    }
    Bass_utiles bassUtiles = Bass_utiles.getInstance();

    @When("User sends a GET request to {string}")
    public void userSendsAGETRequestTo(String endurl) {

        Response request = bassUtiles.getRequest(endurl);

        String requestBody = bassUtiles.getPrettyResponse(request);

        String email = JsonPath.from(requestBody).getString("data.email");

        System.out.println("my mail id " + email);

        String d = "janet.weaver@reqres.in";

        Assert.assertEquals(email, d, "the useranme didt match ");

        System.out.println(requestBody);
    }



    @When("User sends a POST request to {string} with valid credentials")
    public void user_sends_a_post_request_to_with_valid_credentials(String endpoint, DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(data);

        bassUtiles.postRequest(endpoint, jsonObject.toString());
    }

    @Then("The Response should contain to get a token")
    public void the_response_should_contain_to_get_a_token() {

        String responseBody = bassUtiles.getPrettyResponse(response);

        String token = bassUtiles.getJsonPath(responseBody, "token");
     //   String tokenactual = JsonPath.from(requestBody).getString("token");

        System.err.println("token is " + token);

        Assert.assertEquals(token, "QpwL5tke4Pnpja7X4", "user  didnt get token");
    }

    @When("User sends a PUT request to {string} with updated data")
    public void user_sends_a_put_request_to_with_updated_data(String endpoint, DataTable dataTable) {

        Map<String, String> tableMap = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(tableMap);

        bassUtiles.putRequest(endpoint, jsonObject.toString());
    }

    @When("User sends a PATCH request to {string} with partial update")
    public void user_sends_a_patch_request_to_with_partial_update(String string, DataTable dataTable) {
        Map<String, String> tableMap = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(tableMap);

        bassUtiles.patchRequest(string, jsonObject.toString());
    }

    @When("User sends a DELETE request to {string}")
    public void user_sends_a_delete_request_to(String string) {

        Response response = bassUtiles.deleteRequest(string);
    }

    @Then("The Status code should be for delete {int}")
    public void theStatusCodeShouldBeForDelete(Integer int1) {
        int currentcode = bassUtiles.getStatusCode(response);


        Assert.assertEquals(currentcode, int1.intValue(), "status code didnt match");

        if (currentcode != int1) {

            bassUtiles.getPrettyResponse(response);
        }
    }
}
*/
