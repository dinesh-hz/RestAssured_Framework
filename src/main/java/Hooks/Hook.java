package Hooks;

import io.cucumber.java.Before;
import utilities.Bass_utiles;
import utilities.Fileread_Manager;
import utilities.TestContext;

public class Hook {

    private final TestContext context;
    private Bass_utiles bassUtiles;

    public Hook(TestContext context) {
        this.context = context;
        bassUtiles = new Bass_utiles(context);

    }

    @Before
    public void beforeScenarioSetup() {


        System.out.println("🚀 Test setup started...");
        Fileread_Manager.getInstance();
        bassUtiles.setBaseUrl();
        System.out.println("✅ Setup complete.");
    }
}
