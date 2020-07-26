package my.company.steps;

import my.company.pages.InsuranceFormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InsuranceFormSteps extends BaseSteps {
  private final InsuranceFormPage insuranceFormPage = new InsuranceFormPage(driver);

  @Step("Нажатие на кнопку Оформить и переход на 2ю вкладку Оформление")
  public void makeRegisterPerson() {
    insuranceFormPage.clickButton(insuranceFormPage.makeInsuranceButton);
  }

  @Step("Поле {0} заполняется значением {1}")
  public void stepFillField(String field, String value) {
    insuranceFormPage.fillFields(field, value);
  }

  @Step("Заполнение полей формы:")
  public void fillAllFields(HashMap<String, String> map) {
    map.forEach(this::stepFillField);


  }

  @Step("Получение сообщения в блоке ошибок")
  public String getErrorText() {
    return insuranceFormPage.totalErrorBlock.getText();
  }
}
