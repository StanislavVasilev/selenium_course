package my.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс страницы формы с полями для оформления Страховаго полиса.
 */
public class InsuranceFormPage extends BasePage {

  /**
   * Заголовок страницы формы.
   */
  @FindBy(xpath = "//div[@class='product-title-wrapper']//h2[text()='Страхование путешественников']")
  public WebElement insuranceFormPageTitle;
  /**
   * Кнопка Оформить в нижней части страницы в 1й вкладке.
   */
  @FindBy(xpath = "//button[text()='Оформить']")
  public WebElement makeInsuranceButton;

  /**
   * Поля для заполнения. Выполняется поиск по id.
   */
  @FindBy(id = "surname_vzr_ins_0")
  public WebElement visitorSurname;

  @FindBy(id = "name_vzr_ins_0")
  public WebElement visitorName;

  @FindBy(id = "birthDate_vzr_ins_0")
  public WebElement visitorBirthDate;

  @FindBy(id = "person_lastName")
  public WebElement personLastName;

  @FindBy(id = "person_firstName")
  public WebElement personFirstName;

  @FindBy(id = "person_middleName")
  public WebElement personMiddleName;

  @FindBy(id = "person_birthDate")
  public WebElement personBirthDate;

  @FindBy(id = "passportSeries")
  public WebElement passportSeries;

  @FindBy(id = "passportNumber")
  public WebElement passportNumber;

  @FindBy(id = "documentDate")
  public WebElement passportDate;

  @FindBy(id = "documentIssue")
  public WebElement passportIssuedBy;
  /**
   * Кнопка перехода к следующей вкладке, расположена в нижней части страницы во 2й вкладке.
   */
  @FindBy(xpath = "//button[contains(text(), 'Продолжить')]")
  public WebElement continueButton;

  /**
   * Блок с итоговым сообщением об ошибке.
   */
  @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
  private WebElement totalErrorBlock;

  public WebElement getTotalErrorBlock() {

  }

  /**
   * Конструктор принимающий на вход параметр
   *
   * @param driver пронаследованный драйвер от суперкласса
   */
  public InsuranceFormPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    new WebDriverWait(driver, 10, 1000).until(ExpectedConditions.visibilityOf(insuranceFormPageTitle));
    this.driver = driver;
  }

  /**
   * Метод клика на элемент внутри страницы.
   */
  public InsuranceFormPage clickButton(WebElement element) {
    clickOnElement(element);
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
