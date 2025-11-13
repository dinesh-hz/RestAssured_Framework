package StepDefinition;

import io.cucumber.java.en.Then;
import utilities.Bass_utiles;
import utilities.TestContext;

public class CommonSteps {

    private final TestContext context;
    private final Bass_utiles bassUtiles;

    public CommonSteps(TestContext context) {
        this.context = context;
        this.bassUtiles = new Bass_utiles(context);
    }

    @Then("The Status code should be {int} and Type {string}")
    public void theStatusCodeShouldBeAndType(int expected, String type) {

        Bass_utiles.requestType requestType = Bass_utiles.requestType.valueOf(type.toLowerCase());

        bassUtiles.getStatusCode(requestType, expected);
    }



}
