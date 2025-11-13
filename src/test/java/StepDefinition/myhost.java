package StepDefinition;

import Payload.Addrespayload;
import Payload.Userpayload;
import builders.PayloadFactory;
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

import java.util.List;
import java.util.Map;

public class myhost {

    private final Fileread_Manager manager = Fileread_Manager.getInstance();
    Bass_utiles bassUtiles;
    TestContext context;

    public myhost(TestContext context) {
        this.context = context;
        this.bassUtiles = new Bass_utiles(context);
    }

    @Given("user send GEt request to {string}")
    public void userSendGEtRequestTo(String key) {
        String endpoint = manager.getProperty(key);
        bassUtiles.getRequest(endpoint);
    }

    @And("I verify allid should be here {string}")
    public void iVerifyAllidShouldBeHere(String key) {
        Response getResponse = context.getGetResponse();
        bassUtiles.getPrettyResponse(getResponse);
        List<Object> stringList = bassUtiles.getallValuesFromJson(getResponse, key);
        System.err.println("✅ Retrieved all id: " + stringList);

    }


    @Given("I send the get Request {string} with {string}")
    public void iSendTheGetRequestWith(String urlKey, String idKey) {

        String endpoint = manager.getProperty(urlKey);

        String updatauserid = manager.getProperty(idKey);

        Response request = bassUtiles.getRequest(endpoint + updatauserid);

        System.out.println("✅ current body :" + request.asPrettyString());

        bassUtiles.validateSchema(request, "userSchema.json");

    }

    @Then("I check the body value with {string}")
    public void iCheckTheBodyValueWith(String expectedName) {
        Response getResponse = context.getGetResponse();
        String firstname = bassUtiles.getValueFromJson(getResponse, "Firstname");
        Assert.assertEquals(firstname, expectedName, "First name mismatch");
    }

    @Given("I send  POST request to Add {string} with the following data")
    public void iSendPOSTRequestToAddWithTheFollowingData(String key, DataTable dataTable) {

        String endurl = manager.getProperty(key);

        Map<String, String> table = dataTable.asMap(String.class, String.class);

        Userpayload userbody = PayloadFactory.createUserFromData(
                table.get("firstname"),
                table.get("lastname"),
                table.get("emailid"),
                Integer.parseInt(table.get("age")),
                table.get("city"),
                table.get("landmark"),
                table.get("district"),
                table.get("skilname"),
                table.get("skillevel"),
                Integer.parseInt(table.get("experienceYears"))
        );


        bassUtiles.postRequest(endurl, userbody);


        Response postResponse = context.getPostResponse();

        String generatedId = bassUtiles.getValueFromJson(postResponse, "id");

        System.out.println("✅ created new user :" + postResponse.asString());

        //  System.out.println("id  :"+generatedId);

        context.setCurrentUserId(generatedId);

    }

    @And("verify the created user data should contain the Jsonbody")
    public void verifyTheCreatedUserDataShouldContainTheJsonbody(DataTable dataTable) {
        Map<String, String> table = dataTable.asMap(String.class, String.class);

        Response postResponse = context.getPostResponse();

        String actualEmail = bassUtiles.getValueFromJson(postResponse, "Emailid");

        Assert.assertEquals(actualEmail, table.get("emailid"), "Email mismatch");

        String actualfirstname = bassUtiles.getValueFromJson(postResponse, "Firstname");

        Assert.assertEquals(actualfirstname, table.get("firstname"), "firstname mismatch");
    }

    @Then("the Resopons stroe with userid")
    public void theResoponsStroeWithUserid() {

        Response getResponse = context.getGetResponse();

        String id = bassUtiles.getValueFromJson(getResponse, "id");

        context.setUpdataUserId(id);

        System.out.println("✅ Current user id: " + id);
    }

    @And("I send the patch Request {string} with userid")
    public void iSendThePatchRequestWithUserid(String key, DataTable dataTable) {

        Map<String, String> table = dataTable.asMap(String.class, String.class);

        Userpayload existing = context.getGetResponse().as(Userpayload.class);

        Userpayload updated = existing.toBuilder()
                .firstName(table.get("firstname"))
                .lastName(table.get("lastname"))
                .build();


        String endpoint = manager.getProperty(key);

        bassUtiles.patchRequest(endpoint + context.getCurrentUserId(), updated);

        Response patchResponse = context.getPatchResponse();

        System.out.println("✅ Updated user: " + patchResponse.asString());
    }

    @And("verify the existingUser and updatauserbody")
    public void verifyTheExistingUserAndUpdatauserbody() {

        DynamicVerifiertojson.verifyUserById(context.getGetResponse(), context.getCurrentUserId());
    }

    @And("I send the put Request {string} with new body")
    public void iSendThePutRequestWithNewBody(String urlkey, DataTable dataTable) {

        String endpoint = manager.getProperty(urlkey);

        Map<String, String> table = dataTable.asMap(String.class, String.class);

        //  Deserialization: JSON ➝ Java
        Userpayload oldRespons = context.getGetResponse().as(Userpayload.class);


        Userpayload replacebody = oldRespons.toBuilder()
                .firstName(table.get("firstname"))
                .lastName(table.get("lastname"))
                .age(Integer.valueOf(table.get("age")))
                .addres(Addrespayload.builder()
                        .city(table.get("city"))
                        .district(table.get("landmark"))
                        .landmark(table.get("district"))
                        .build())
                .skils(null) // or use empty .skils(Collections.emptyList())
                .build();


        String replaceUserId = context.getUpdataUserId();

        bassUtiles.putRequest(endpoint + replaceUserId, replacebody);

        Response putResponse = context.getPutResponse();

        System.out.println("✅ replaced user body: " + putResponse.asPrettyString());

    }

}
