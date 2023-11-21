package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
dryRun = false,
monochrome = true,		
features="src/test/resources/Features", glue= {"StepDefinitions"},
plugin = {"pretty","html:target/HtmlReports1/report.html"}
)
public class TestRunner{

}
