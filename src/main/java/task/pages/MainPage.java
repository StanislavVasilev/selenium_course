package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
  @FindBy(xpath = "//a[@data-id='market']")
  private WebElement linkToMarket;

  public void gotoMarket() {
    clickElement(linkToMarket);
  }
}
