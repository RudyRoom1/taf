package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:featureFiles/ApiTestRandomUser.feature",
    glue = {"classpath:stepDefinition","classpath:config"},
    plugin = {
        "TestStepWatch"
    })
public class RunJunit {

}
