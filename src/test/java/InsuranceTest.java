import my.company.steps.BaseSteps;
import my.company.steps.InsuranceFormSteps;
import my.company.steps.InsurancePageSteps;
import my.company.steps.MainSteps;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class InsuranceTest extends BaseSteps {
  MainSteps mainSteps = new MainSteps();
  InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
  InsuranceFormSteps insuranceFormSteps = new InsuranceFormSteps();

  @Test
  public void testInsurance() {
    mainSteps.stepSelectMenu("Страхование");
    mainSteps.stepSelectSubMenuItem("Страхование путешественников");
    insurancePageSteps.clickMakeInsuranceButton();
    insuranceFormSteps.makeRegisterPerson();
    HashMap<String, String> fieldData = new HashMap<>();
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
    insuranceFormSteps.clickContinueButton();
    Assert.assertEquals("Произошла непредвиденная ошибка", insuranceFormSteps.getErrorText());
  }
}
