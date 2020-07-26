package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс главной страницы
 */
public class MainPage extends BasePage {

  /**
   * Элемент меню
   */
  @FindBy(xpath = "//span[text()='Страхование']/parent::button")
  public WebElement insuranceMenu;
  /**
   * Элемент подменю
   */
  @FindBy(xpath = "//span[text()='Страхование']/ancestor::li//a[text()='Страхование путешественников']")
  public WebElement insSubMenuItemInsuranceForTravelers;

  /**
   * Конструктор класса с передаваемым параметром
   *
   * @param driver пронаследованный от суперкласса драйвер
   *               Реализовано явное ожидание заголовка страницы(может быть лишнее)
   */
  public MainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  /**
   * Метод выплняет открытие выпадающего подменю по наведению на кнопку основного меню
   */
  public MainPage openMenu(String target) {
    switch (target) {
      case "Страхование":
        moveToElement(insuranceMenu);
        break;
    }
    return this;
  }

  /**
   * Метод выполняет наведение и открытие элемента выпадающего подменю
   */
  public MainPage openSubMenu(String target) {
    switch (target) {
      case "Страхование путешественников":
        moveToElementAndClick(insSubMenuItemInsuranceForTravelers);
        break;
    }
    return this;
  }

}
