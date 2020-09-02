package pages;

import hooks.Hooks;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Data
public class GooglePage {

  @FindBy(xpath = "//input[@title = 'Search']")
  private WebElement searchField;

  @FindBy(xpath = "//div[@class='r']/a[contains(.,'www.facebook.com')]/h3")
  private List<WebElement> searchResult;

  public GooglePage() {
    Hooks.getDriver().get("https://www.google.com/");
    Hooks.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    PageFactory.initElements(Hooks.getDriver(), this);
  }

  public void search(String searchText) {
    searchField.sendKeys(searchText);
    searchField.submit();
  }
}
