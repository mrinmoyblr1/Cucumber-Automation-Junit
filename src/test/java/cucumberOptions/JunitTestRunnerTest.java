package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features"
        , glue = "stepDefinitions"
        , tags = "@PlaceOrder or @OffersPage"
        , plugin = {"pretty", "html:target/cucumber.html"
        , "json:target/cucumber.json"
        , "junit:target/cukes.xml"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        , "rerun:target/failed_scenarios.txt"
}
)
public class JunitTestRunnerTest {
}
