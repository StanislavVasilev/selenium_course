package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс страницы раздела Страхование путешественников
 */

public class InsuranceForTravelersPage extends BasePage {

  /**
   * Кнопка Оформить онлайн
   */
  @FindBy(xpath = "//b[@class='kit-button__text'][text()='Оформить онлайн']")
  public WebElement makeInsuranceButton;
  /**
   * Заголовок раздела внутри блока с кнопкой Оформить
   */
  @FindBy(xpath = "//b[text()='Оформить онлайн']/ancestor::div[@class='kit-col kit-col_xs_12 kit-col_lg-top_40']/parent::div[@class='kit-row']//h1")
  public WebElement insuranceForTravelersTitle;

  /**
   * Конструктор, принимаеющий в качестве параметра драйвер
   *
   * @param driver пронаследованный от суперкласса.
   * Выполняет инициализацию элементов на странице.
   */
  public InsuranceForTravelersPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  /**
   * Метод кликает на кнопку "ОФормить онлайн"
   * Передает ссылку на текущий объект страницы.
   */
  public InsuranceForTravelersPage clickRegisterInsuranceButton() {
    clickOnElement(makeInsuranceButton);
    return this;
  }


}
