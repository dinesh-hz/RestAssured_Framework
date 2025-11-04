package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.Bass_utiles;
import utilities.Fileread_Manager;

public class myhost  {


    Bass_utiles bassUtiles = Bass_utiles.getInstance();
    Response response;
    Fileread_Manager manager = Fileread_Manager.getInstance();


    @Given("user send GEt request to {string}")
    public void userSendGEtRequestTo(String endurl) {
        String endpoint = manager.getProperty(endurl);

        response = bassUtiles.getRequest(endpoint);
    }

    @And("The User name should be {string}")
    public void theUserNameShouldBe(String expectname) {
        String responseBody = bassUtiles.getResponseBody();
        String firstName = bassUtiles.jsonpathfrom(responseBody, "first_name");
        System.out.println("this is of id:2 user name is : "+firstName);
        Assert.assertEquals(expectname,firstName,"the firstname isnot  match");
    }


}
