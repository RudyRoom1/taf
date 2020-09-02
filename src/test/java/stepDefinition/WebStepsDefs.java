package stepDefinition;

import static config.TestConfigRandomUser.randoUser_requestSpec;
import static io.restassured.RestAssured.given;

import context.ContextKeyEnums;
import context.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import pages.GooglePage;
import randomuser_models.RandomUser;
import steps.RestApiSteps;
import steps.WebSteps;

@Slf4j
public class WebStepsDefs {

  private GooglePage googlePage = new GooglePage();
  private RequestSpecification request;
  private Response response;
  private static final String RANDOM_USER_END_POINT = "api/?page=1&results=3";
  private RestApiSteps restApiSteps = new RestApiSteps();
  private WebSteps webSteps = new WebSteps();
  private String fullName = "";
  ScenarioContext scenarioContext = new ScenarioContext();


  @Given("Get random user")
  public void user_set_specification() {
    request = given().spec(randoUser_requestSpec);
    response = request.get(RANDOM_USER_END_POINT);
    scenarioContext.setContext(ContextKeyEnums.USER_LIST.name(),restApiSteps.convertJsonToPOJOModel(response));
  }

  @Then("Search the user in google")
  public void searchTheUserInGoogle() {
    List<RandomUser> randomUsers = scenarioContext.getContext(ContextKeyEnums.USER_LIST.name());
    fullName = restApiSteps.collectFullName(randomUsers.get(0));
    googlePage.search(fullName);
    scenarioContext.setContext(ContextKeyEnums.FULL_NAME.name(),fullName);
  }

  @Then("Check facebook page for random user is exist")
  public void checkFacebookPageForRandomUserIsExist() {
    scenarioContext.getContext(ContextKeyEnums.FULL_NAME.name());
    webSteps.facebookProfileCheck(fullName);
  }
}
