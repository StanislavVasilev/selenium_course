package my.company.pages;

import my.company.managers.DriverManager;
import my.company.managers.PagesManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * Родительский класс.
 * Реализует основные методы
 */

public class BasePage {

  protected PagesManager manager = PagesManager.getPagesManager();
  protected Actions action = new Actions(DriverManager.getDriver());

  public BasePage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  /**
   * Заполнение поля
   *
   * @param element веб элемент, передаваемый в качестве параметра
   * @param value   значение, которое заносится в поле
   */
  protected void fillField(WebElement element, String value) {
    element.click();
    element.sendKeys(value);
  }

  /**
   * Клик на элемент
   *
   * @param element передается Веб элемент
   */
  protected void clickOnElement(WebElement element) {
    element.click();
  }

  /**
   * Наведение курсора на элемент меню
   *
   * @param element передается Веб элемент
   */
  protected void moveToElement(WebElement element) {
    action.moveToElement(element).build().perform();
  }

  /**
   * Наведение курсора на элемент и клик по нему
   *
   * @param element Передается Веб элемент
   */
  protected void moveToElementAndClick(WebElement element) {
    action.moveToElement(element).click().build().perform();
  }

}
