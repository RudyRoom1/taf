package steps;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import pages.GooglePage;

@Slf4j
public class WebSteps {

  GooglePage googlePage = new GooglePage();
  List<WebElement> facebookRecords = googlePage.getSearchResult();

  public void facebookRecordForProfile(String fullName) {
    if (!facebookRecords.isEmpty()) {
      log.info("Facebook page for user with full name: {} exist", fullName);
    } else {
      log.info("Facebook page for user with full name: {} dose not exist", fullName);
    }
  }

  public void facebookProfileCheck(String fullName) {
    boolean titleContainsFullName = true;
    boolean isTitleContainsFullName = facebookRecords.stream().map(WebElement::getText).map(title -> title.contains(fullName)).collect(Collectors.toList()).contains(titleContainsFullName);

    if (!facebookRecords.isEmpty() && isTitleContainsFullName) {
      log.info("Facebook page for user with full name: {} exist", fullName);
    } else {
      log.info("Facebook page for user with full name: {} dose not exist", fullName);
    }
  }
}
