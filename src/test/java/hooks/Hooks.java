package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import webdriver.WebDrivers;

public class Hooks {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  @SneakyThrows
  @Before
  public void before() {
    driver = WebDrivers.createWebDriver();
  }

  @After(order = 1)
  public void tearDown() {
    WebDrivers.exitDriver();
  }
}
