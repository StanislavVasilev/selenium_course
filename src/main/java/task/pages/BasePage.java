package task.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.managers.DriverManager;
import task.managers.PagesManager;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BasePage {
  protected PagesManager pagesManager = PagesManager.getApp();
  private Actions action = new Actions(DriverManager.getDriver());

  WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20, 500);

  public BasePage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  protected void waitForVisibleElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void waitAndClickElement(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
    element.click();
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


  /**
   * Если элемент есть на странице, то выполняется ожидание, пока он скроется.
   *
   * @param element передается веб элемент.
   */
  protected void waitHideElement(WebElement element) {
    boolean elementCondition = false;
    do {
      try {
        elementCondition = element.isDisplayed();
      } catch (NoSuchElementException | StaleElementReferenceException e) {
        e.printStackTrace();
      }
    } while (elementCondition);
  }

  /**
   * Переключение между вкладками браузера
   */
  public void switchToNextHandle() {
    ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
    DriverManager.getDriver().switchTo().window(tabs.get(1));
  }
}
