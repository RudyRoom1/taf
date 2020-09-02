package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:featureFiles/RandomUserGoogleCheck.feature",
    glue = {"classpath:stepDefinition","classpath:config","classpath:hooks"},
    junit = "--step-notifications",
    plugin = {
        "TestStepWatch"
    })
public class RunWebJunit {

}
