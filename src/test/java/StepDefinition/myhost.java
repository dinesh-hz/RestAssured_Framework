package StepDefinition;

import Payload.Userpayload;
import builders.UserPayloadBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.Bass_utiles;
import utilities.DynamicVerifiertojson;
import utilities.Fileread_Manager;
import utilities.TestContext;

import java.util.Map;

public class myhost {

    private final Fileread_Manager manager = Fileread_Manager.getInstance();
    Bass_utiles bassUtiles ;
    TestContext context ;
    private String currentUserId;

    public myhost(TestContext context) {
        this.context = context;
        this.bassUtiles = new Bass_utiles(context);
    }


    @Given("user sends GET request to {string}")
    public void userSendsGETRequestTo(String key) {
        String endpoint = manager.getProperty(key);
        bassUtiles.getRequest(endpoint);
    }

    @And("The User name should be {string}")
    public void theUserNameShouldBe(String expectedName) {
        String body = bassUtiles.getPrettyResponse(context.getGetResponse());
        String firstName = bassUtiles.getValueFromJson(body, "first_name");
        System.out.println("✅ Retrieved user name: " + firstName);
        Assert.assertEquals(firstName, expectedName, "First name mismatch");
    }

    @Given("the user sends a POST request to {string} with the following data")
    public void theUserSendsAPOSTRequestTo(String key, DataTable data) throws JsonProcessingException {
        Map<String, String> map = data.asMap(String.class, String.class);
        String endpoint = manager.getProperty(key);

        Userpayload user = UserPayloadBuilder.createUserFromData(
                map.get("firstname"), map.get("lastname"), map.get("emailid"),
                Integer.parseInt(map.get("age")), map.get("city"), map.get("landmark"), map.get("district"));

        String json = new ObjectMapper().writeValueAsString(user);
        bassUtiles.postRequest(endpoint, json);
    }

    @And("the created user data should contain")
    public void theCreatedUserDataShouldContain(DataTable data) {
        Map<String, String> map = data.asMap(String.class, String.class);
        String body = bassUtiles.getPrettyResponse(context.getPostResponse());
        String actualEmail = bassUtiles.getValueFromJson(body, "emailid");
        Assert.assertEquals(actualEmail, map.get("emailid"), "Email mismatch after POST");
    }

    @Given("I send the get Request {string} with {string}")
    public void iSendTheGetRequestWith(String urlKey, String idKey) {

        String endpoint = manager.getProperty(urlKey);
        String id = manager.getProperty(idKey);
        Response request = bassUtiles.getRequest(endpoint + id);
        System.out.println("current body :" + request.asPrettyString());
    }

    @Then("the Resopons stroe with userid")
    public void theResoponsStroeWithUserid() {

        currentUserId = bassUtiles.getValueFromJson(context.getGetResponse().asString(), "id");
        System.out.println("✅ Current user id: " + currentUserId);
    }

    @And("I send the patch Request {string} with userid")
    public void iSendThePatchRequestWithUserid(String key, DataTable dataTable) {

        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Userpayload existing = context.getGetResponse().as(Userpayload.class);

        Userpayload updated = existing.toBuilder()
                .firstname(map.get("firstname"))
                .Age(Integer.parseInt(map.get("age")))
                .build();

        String endpoint = manager.getProperty(key);
        bassUtiles.patchRequest(endpoint + currentUserId, updated);
        System.out.println("✅ Updated user: " + context.getPatchResponse().asPrettyString());
    }

    @And("verify the existingUser and updatauserbody")
    public void verifyTheExistingUserAndUpdatauserbody() {

        DynamicVerifiertojson.verifyUserById(context.getGetResponse(), currentUserId);
    }
}
