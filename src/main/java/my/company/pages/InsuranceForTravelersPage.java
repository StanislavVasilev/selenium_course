package my.company.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс страницы раздела Страхование путешественников
 */

public class InsuranceForTravelersPage extends BasePage {

  /**
   * Кнопка Оформить онлайн
   */
  @FindBy(xpath = "//b[@class='kit-button__text'][text()='Оформить онлайн']")
  private WebElement makeInsuranceButton;
  /**
   * Заголовок раздела внутри блока с кнопкой Оформить
   */
  @FindBy(xpath = "//b[text()='Оформить онлайн']/ancestor::div[@class='kit-col kit-col_xs_12 kit-col_lg-top_40']/parent::div[@class='kit-row']//h1")
  private WebElement insuranceForTravelersTitle;


  /**
   * Метод кликает на кнопку "ОФормить онлайн"
   * Передает ссылку на текущий объект страницы.
   */
  public InsuranceForTravelersPage clickRegisterInsuranceButton() {
    clickOnElement(makeInsuranceButton);
    return this;
  }
}