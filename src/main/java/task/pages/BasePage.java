package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.managers.DriverManager;
import task.managers.PagesManager;

public class BasePage {
  public PagesManager pagesManager = new PagesManager();
  private Actions action = new Actions(DriverManager.getDriver());

  WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10, 200);

  public void pagesManager() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  protected void waitForVisibleElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void clickElement(WebElement element) {
    element.click();
  }

  protected void fillField(WebElement element, String value) {
    element.clear();
    element.sendKeys(value);
  }

  protected void moveToElement(WebElement element) {
    action.moveToElement(element);
  }


}
