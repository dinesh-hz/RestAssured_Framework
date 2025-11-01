package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileread_Manager {

    public void file_reader() throws FileNotFoundException {

        FileInputStream file = new FileInputStream("./src/test/resources/config.properties");

        Properties properties = new Properties();

        try {

            properties.load(file);
        } catch (Exception e) {

            e.printStackTrace();
        }

        contText.starturl = properties.getProperty("baseURI");
    }
    //dkdk
}
