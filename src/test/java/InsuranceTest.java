import my.company.steps.BaseSteps;
import my.company.steps.InsuranceFormSteps;
import my.company.steps.InsurancePageSteps;
import my.company.steps.MainSteps;
import org.junit.Test;

import java.util.HashMap;

public class InsuranceTest extends BaseSteps {

  @Test
  public void testInsurance() {
    MainSteps mainSteps = new MainSteps();
    mainSteps.stepSelectMenu("Страхование", "Страхование путешественников");
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    insurancePageSteps.clickMakeInsuranceButton();
    InsuranceFormSteps insuranceFormSteps = new InsuranceFormSteps();
    insuranceFormSteps.makeRegisterPerson();
    HashMap<String, String> fieldData = new HashMap<String, String>();
    fieldData.put("Имя Застрахованного", "Станислав");
    fieldData.put("Фамилия Застрахованного", "Васильев");
    fieldData.put("Дата рождения Застрахованного", "18121985");
    fieldData.put("Фамилия Страхователя", "Васильев");
    fieldData.put("Имя Страхователя", "Станислав");
    fieldData.put("Отчество Страхователя", "Вадимович");
    fieldData.put("Дата рождения Страхователя", "18121985");
    fieldData.put("Серия паспорта", "1234");
    fieldData.put("Номер паспорта", "567890");
    fieldData.put("Дата выдачи", "22112006");
    fieldData.put("Кем выдан", "УВД АБВГД");
    insuranceFormSteps.fillAllFields(fieldData);
  }
//insuranceFormPage
//        .fillFields(insuranceFormPage.visitorSurname, "Васильев")
//          .fillFields(insuranceFormPage.visitorName, "Станислав")
//            .fillFields(insuranceFormPage.visitorBirthDate, "18121985")
//            .fillFields(insuranceFormPage.personLastName, "Васильев")
//            .fillFields(insuranceFormPage.personFirstName, "Станислав")
//            .fillFields(insuranceFormPage.personMiddleName, "Вадимович")
//            .fillFields(insuranceFormPage.personBirthDate, "18121985")
//            .fillFields(insuranceFormPage.passportSeries, "1234")
//            .fillFields(insuranceFormPage.passportNumber, "123456")
//            .fillFields(insuranceFormPage.passportDate, "22112006")
//            .fillFields(insuranceFormPage.passportIssuedBy, "АБВГД ЕЖЗКЛМН")
//            .clickButton(insuranceFormPage.continueButton);

}
