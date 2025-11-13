package runners;


//@RunWith(Cucumber.class)

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt",

        glue = {"StepDefinition", "Hooks"},
        dryRun = false,
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"html:target/Easycucumber/rerunnercucumber.html"})
public class Rerunner extends AbstractTestNGCucumberTests {


}
