import org.junit.Assert;
import org.junit.Test;
import pages.InsuranceForTravelersPage;
import pages.InsuranceFormPage;
import pages.MainPage;

public class InsuranceTest extends TestBase {

  @Test
  public void testInsurance() {
    /**
     * Используя наследованный драйвер выполняется переход на страницу из переменной, взятой из параметра.
     */
    driver.get(baseUrl);
    /**
     * Инициализируется главная страница, после чего выполняется действие по переходу через меню
     */
    MainPage mainPage = new MainPage(driver);
    mainPage.openMenu().openSubMenu();
    /**
     * Инициализируется страница Страхование путешественников, проверяется заголовок страницы,
     * после чего выполняется переход на страницу оформления страхового полиса
     */
    InsuranceForTravelersPage insuranceForTravelersPage = new InsuranceForTravelersPage(driver);
    String insuranceForTravelersTitle = insuranceForTravelersPage.insuranceForTravelersTitle.getText();
    Assert.assertEquals("Страхование путешественников", insuranceForTravelersTitle);
    insuranceForTravelersPage.clickRegisterInsuranceButton();
    /**
     * Инициализируется страница формы
     * Выполняется заполнение полей формы с использованием "fluent-интерфейса" - шаблона построения выполнения методов одного за другим.
     * После заполнения форм выполняется попытка продолжить и проверка сообщения об ошибке.
     */
    InsuranceFormPage insuranceFormPage = new InsuranceFormPage(driver);
    insuranceFormPage.clickButton(insuranceFormPage.makeInsuranceButton);
    insuranceFormPage
            .fillFields(insuranceFormPage.visitorSurname, "Васильев")
            .fillFields(insuranceFormPage.visitorName, "Станислав")
            .fillFields(insuranceFormPage.visitorBirthDate, "18121985")
            .fillFields(insuranceFormPage.personLastName, "Васильев")
            .fillFields(insuranceFormPage.personFirstName, "Станислав")
            .fillFields(insuranceFormPage.personMiddleName, "Вадимович")
            .fillFields(insuranceFormPage.personBirthDate, "18121985")
            .fillFields(insuranceFormPage.passportSeries, "1234")
            .fillFields(insuranceFormPage.passportNumber, "123456")
            .fillFields(insuranceFormPage.passportDate, "22112006")
            .fillFields(insuranceFormPage.issuedBy, "АБВГД ЕЖЗКЛМН")
            .clickButton(insuranceFormPage.continueButton);
    String errorText = insuranceFormPage.totalErrorBlock.getText();
    Assert.assertEquals("При заполнении данных произошла ошибка", errorText);
  }


}
