package stepDefinition;

import static config.TestConfigRandomUser.randoUser_requestSpec;
import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import randomuser_models.RandomUser;
import steps.RestApiSteps;

@Slf4j
public class MyStepDefs {

  private Response response;
  private ValidatableResponse json;
  private RequestSpecification request;
  private List<RandomUser> users;
  private final RestApiSteps restApiSteps = new RestApiSteps();


  @Given("User set specification")
  public void user_set_specification() {
    request = given().spec(randoUser_requestSpec);
  }

  @When("Endpoint {string} was set endpoint")
  public void endpoint_was_set_endpoint(String endPoint) {
    response = request.get(endPoint);
  }

  @Then("The status code is {int}")
  public void theStatusCodeIsExpectedStatus(Integer inter) {
    System.out.println(inter);
    json = response.then().statusCode(inter);
  }

  @Then("Convert json to POJO")
  public void convertJsonToPOJO() throws IOException {
    users = restApiSteps.convertJsonToPOJOModel(response);
  }

  @Then("All user have same gender")
  public void allUserHaveSameGender() {
    Assert.assertTrue("Users have different gender", restApiSteps.usersHaveSameGender(users));
  }

  @Then("Users title occurrence of Mrs, Ms and Mr")
  public void usersOccurrenceOfMrsMsAndMr() {
    restApiSteps.usersHaveTitle(users);
  }

  @Then("Users average age is lower than {string}")
  public void usersAverageAgeIsLowerThan(String averageAge) {
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(restApiSteps.usersAverageAge(users).getAsDouble()).isLessThan(Double.valueOf(averageAge));
    softAssertions.assertAll();
  }

  @Then("User password contains at least 1 digit and 1 capital, none of the passwords contains user name")
  public void userPasswordContainsAtLeastDigitAndCapitalNoneOfThePasswordsContainsUserName() {
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(restApiSteps.stringContainsCapital(users))
        .as(String.format("User password contains capital Letter: %s", restApiSteps.stringContainsCapital(users)))
        .isTrue();
    softAssertions.assertThat(restApiSteps.stringContainsDigit(users))
        .as(String.format("User password contains digit: %s", restApiSteps.stringContainsDigit(users)))
        .isTrue();
    softAssertions.assertThat(!restApiSteps.stringContainsUserName(users))
        .as(String.format("User password contains user name: %s", restApiSteps.stringContainsUserName(users)))
        .isFalse();
    softAssertions.assertAll();
  }
}
