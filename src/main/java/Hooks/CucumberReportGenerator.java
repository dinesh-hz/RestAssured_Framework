package Hooks;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CucumberReportGenerator {

    public static void generateReport() {

        // ️ Define the report output directory for save this reportes
        File reportOutputDirectory = new File("target/cucumber-reports/");

        //  Ensure cucumber.json exists
        List<String> jsonFiles = new ArrayList<>();
        String jsonFilePath = "target/cucumber-reports/cucumber.json";
        File jsonFile = new File(jsonFilePath);

        if (!jsonFile.exists()) {
            System.out.println("❌ ERROR: cucumber.json NOT FOUND! Report cannot be generated.");
            return;
        } else {
            jsonFiles.add(jsonFilePath);
        }

        //  Create Configuration for report customization
        Configuration configuration = new Configuration(reportOutputDirectory, "API Test Report");
        configuration.setBuildNumber("TC01");
        configuration.addClassifications("Platform", System.getProperty("os.name").toUpperCase());
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Environment", "QA");
        configuration.addClassifications("Tester", "Dinesh");

        //  Generate the report
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();

        System.out.println("✅ Cucumber HTML Report Generated Successfully!");
    }

    public static void main(String[] args) {
        generateReport();
    }
}
