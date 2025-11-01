package Helpers;

import base_Test_clas.BaseTest;
import io.cucumber.java.Before;
import utilities.Fileread_Manager;

import java.io.FileNotFoundException;

public class Hook extends BaseTest {

    Fileread_Manager file_rad = new Fileread_Manager();

    @Before
    public void beforeScenario() {
        try {
            file_rad.file_reader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        setup();
    }
}
