package my.company.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс страницы формы с полями для оформления Страховаго полиса.
 */
public class InsuranceFormPage extends BasePage {


  /**
   * Заголовок страницы формы.
   */
  @FindBy(xpath = "//div[@class='product-title-wrapper']//h2[text()='Страхование путешественников']")
  private WebElement insuranceFormPageTitle;
  /**
   * Кнопка Оформить в нижней части страницы в 1й вкладке.
   */
  @FindBy(xpath = "//button[text()='Оформить']")
  private WebElement makeInsuranceButton;

  /**
   * Поля для заполнения. Выполняется поиск по id.
   */
  @FindBy(id = "surname_vzr_ins_0")
  private WebElement visitorSurname;

  @FindBy(id = "name_vzr_ins_0")
  private WebElement visitorName;

  @FindBy(id = "birthDate_vzr_ins_0")
  private WebElement visitorBirthDate;

  @FindBy(id = "person_lastName")
  private WebElement personLastName;

  @FindBy(id = "person_firstName")
  private WebElement personFirstName;

  @FindBy(id = "person_middleName")
  private WebElement personMiddleName;

  @FindBy(id = "person_birthDate")
  private WebElement personBirthDate;

  @FindBy(id = "passportSeries")
  private WebElement passportSeries;

  @FindBy(id = "passportNumber")
  private WebElement passportNumber;

  @FindBy(id = "documentDate")
  private WebElement passportDate;

  @FindBy(id = "documentIssue")
  private WebElement passportIssuedBy;
  /**
   * Кнопка перехода к следующей вкладке, расположена в нижней части страницы во 2й вкладке.
   */
  @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
  private WebElement continueButton;

  /**
   * Блок с итоговым сообщением об ошибке.
   */
  @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
  private WebElement totalErrorBlock;

  public WebElement getTotalErrorBlock() {
    return totalErrorBlock;
  }


  /**
   * Метод клика на элемент внутри страницы.
   */
  public InsuranceFormPage clickButton(String buttonName) {
    switch (buttonName) {
      case "Оформить":
        clickOnElement(makeInsuranceButton);
        break;
      case "Продолжить":
        clickOnElement(continueButton);
        break;
    }
    return this;
  }

  /**
   * Метод заполнения полей.
   *
   * @param value принимает на вход значение, которое в поле заносится
   */

  public InsuranceFormPage fillFields(String target, String value) {
    switch (target) {
      case "Фамилия Застрахованного":
        fillField(visitorSurname, value);
        break;
      case "Имя Застрахованного":
        fillField(visitorName, value);
      case "Дата рождения застрахованного":
        fillField(visitorBirthDate, value);
        break;
      case "Фамилия Страхователя":
        fillField(personLastName, value);
        break;
      case "Имя Страхователя":
        fillField(personFirstName, value);
        break;
      case "Отчество Страхователя":
        fillField(personMiddleName, value);
        break;
      case "Дата рождения Страхователя":
        fillField(personBirthDate, value);
        break;
      case "Серия паспорта":
        fillField(passportSeries, value);
        break;
      case "Номер паспорта":
        fillField(passportNumber, value);
        break;
      case "Дата выдачи паспорта":
        fillField(passportDate, value);
        break;
      case "Кем выдан":
        fillField(passportIssuedBy, value);
        break;
    }
    return this;
  }


}
