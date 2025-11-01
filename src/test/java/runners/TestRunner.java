package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

// this is only run for junit test from junit pakges
@CucumberOptions(features = "./src/test/resources/feature_files",

        glue = {"StepDefinition", "Helpers"},

        dryRun = false,
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty",

                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/cucumber.json",

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}, // just chek failled sceainer faile name save to the text file
        publish = true,
        tags = ("@try")

)
public class TestRunner extends AbstractTestNGCucumberTests {

    /*
     * Verify Check if something is present (e.g. if a field exists or is not null).
     * Validate Check if something has the correct/expected value.
     */
}
