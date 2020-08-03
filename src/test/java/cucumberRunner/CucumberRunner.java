package cucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"steps", "hooks"}, plugin = {"pretty", "html:target/cucumber-html-report",
        "json:target/cucumber-report.json"})
public class CucumberRunner {

}
