package StepDefinition;


import utilities.Bass_utiles;
import utilities.Fileread_Manager;
import utilities.TestContext;

public class APISteps {

    private final Fileread_Manager manager = Fileread_Manager.getInstance();
    Bass_utiles bassUtiles;
    TestContext context;


    public APISteps(TestContext context) {
        this.context = context;
        this.bassUtiles = new Bass_utiles(context);
    }





}
