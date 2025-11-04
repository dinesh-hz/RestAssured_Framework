package StepDefinition;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.Bass_utiles;

public class CommonSteps {

   // private Response response;

    Bass_utiles bassUtiles = Bass_utiles.getInstance();


    @Then("The Status code should be {int}")
    public void theStatusCodeShouldBe(Integer expectedStatusCode ) {

        int currentcode = bassUtiles.getStatusCode();
       // System.out.println(currentcode);
        if (currentcode == expectedStatusCode ) {
            Assert.assertEquals(currentcode, expectedStatusCode , "status code isnt match");
        }else {
            System.out.println("as expected statuscode "+expectedStatusCode +"but got "+currentcode);
        }
    }
}
