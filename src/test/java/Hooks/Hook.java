package Hooks;

import io.cucumber.java.Before;
import utilities.Bass_utiles;
import utilities.Fileread_Manager;

public class Hook {

    @Before
    public void beforeScenarioSetup() {
        System.out.println("🚀 Test setup started...");
        Fileread_Manager.getInstance();
        Bass_utiles.getInstance().initAPISetup();
        System.out.println("✅ Setup complete.");
    }
}
