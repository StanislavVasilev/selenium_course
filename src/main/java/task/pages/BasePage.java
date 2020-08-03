package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import task.managers.DriverManager;
import task.managers.PagesManager;

public class BasePage {
  protected PagesManager pagesManager = new PagesManager();
  private Actions action = new Actions(DriverManager.getDriver());

  public void pagesManager() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  public void clickElement(WebElement element) {
    element.click();
  }

  public void fillField(WebElement element, String value) {
    element.sendKeys(value);
  }

  public void moveToElement(WebElement element) {
    action.moveToElement(element);
  }

}
