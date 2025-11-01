package StepDefinition;

import base_Test_clas.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.json.JSONObject;

public class APISteps {

    BaseTest baseTest = new BaseTest();

    @When("User sends a GET request to {string}")
    public void userSendsAGETRequestTo(String string) {

        baseTest.sendRequest("GET", string);

        String requestBody = baseTest.getRequestBody();

        String email = JsonPath.from(requestBody).getString("data.email");

        System.out.println("my mail id " + email);

        String d = "janet.weaver@reqres.in";

        Assert.assertEquals(email, d, "the useranme didt match ");

        baseTest.getprettyprint();
    }

    @Then("The Status code should be {int}")
    public void theStatusCodeShouldBe(Integer int1) {

        int currentcode = baseTest.getstatuscode();

        Assert.assertEquals(currentcode, int1, "status code didnt match");

        if (currentcode != int1) {

            baseTest.getprettyprint();
        }
    }

    @When("User sends a POST request to {string} with valid credentials")
    public void user_sends_a_post_request_to_with_valid_credentials(String endpoint, DataTable dataTable) {

        var data = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(data);

        baseTest.sendRequest("POST", endpoint, jsonObject.toString());
    }

    @Then("The Response should contain to get a token")
    public void the_response_should_contain_to_get_a_token() {

        String requestBody = baseTest.getRequestBody();

        String tokenactual = JsonPath.from(requestBody).getString("token");

        System.err.println("token is " + tokenactual);

        Assert.assertEquals(tokenactual, "QpwL5tke4Pnpja7X4", "user  didnt get token");
    }

    @When("User sends a PUT request to {string} with updated data")
    public void user_sends_a_put_request_to_with_updated_data(String endpoint, DataTable dataTable) {

        var data = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(data);

        baseTest.sendRequest("PUT", endpoint, jsonObject.toString());
    }

    @When("User sends a PATCH request to {string} with partial update")
    public void user_sends_a_patch_request_to_with_partial_update(String string, DataTable dataTable) {
        var data = dataTable.asMap(String.class, String.class);

        JSONObject jsonObject = new JSONObject(data);

        baseTest.sendRequest("PATCH", string, jsonObject.toString());
    }

    @When("User sends a DELETE request to {string}")
    public void user_sends_a_delete_request_to(String string) {

        baseTest.sendRequest("DELETE", string);
    }

    @Then("The Status code should be for delete {int}")
    public void theStatusCodeShouldBeForDelete(Integer int1) {
        int currentcode = baseTest.getstatuscode();

        Assert.assertEquals(currentcode, int1.intValue(), "status code didnt match");

        if (currentcode != int1) {

            baseTest.getprettyprint();
        }
    }
}
