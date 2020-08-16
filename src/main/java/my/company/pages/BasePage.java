package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Родительский класс.
 * Реализует основные методы
 */

public class BasePage {

  WebDriver driver;

  /**
   * Заполнение поля
   * @param element веб элемент, передаваемый в качестве параметра
   * @param value значение, которое заносится в поле
   */
  protected void fillField(WebElement element, String value) {
    element.click();
    element.sendKeys(value);
  }

  /**
   * Клик на элемент
   * @param element  передается Веб элемент
   */
  protected void clickOnElement(WebElement element) {
    element.click();
  }

  /**
   * Наведение курсора на элемент меню
   * @param element передается Веб элемент
   */
  protected void moveToElement(WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
  }

  /**
   * Наведение курсора на элемент и клик по нему
   * @param element Передается Веб элемент
   */
  protected void moveToElementAndClick(WebElement element) {
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().build().perform();
  }

}
