package task.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
  @FindBy(xpath = "//a[@data-id='market']")
  private WebElement linkToMarket;

  @FindBy(xpath = "//div[@class='services-new__item-title'][text()='Маркет']/preceding-sibling::div")
  private WebElement alternativeLinkToMarket;

  public void gotoMarket() {
    try {
      clickElement(linkToMarket);
    } catch (NoSuchElementException e) {
      e.printStackTrace();
      clickElement(alternativeLinkToMarket);
    }
  }
}
