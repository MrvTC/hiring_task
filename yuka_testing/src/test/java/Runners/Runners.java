package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin   = {"pretty", "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        publish  = true,
        features = {"src/test/resources/Features"},
        glue     = {"org.yukaTest.StepDefinitions"},
        tags     ="",
        dryRun   = false
)
public class Runners {
}