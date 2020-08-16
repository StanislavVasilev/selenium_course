package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.InsuranceFormPage;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class InsuranceFormSteps extends BaseSteps{
  private final InsuranceFormPage insuranceFormPage = new InsuranceFormPage();

  @Step("Нажатие на кнопку Оформить и переход на 2ю вкладку Оформление")
  public void makeRegisterPerson() {
    insuranceFormPage.clickButton("Оформить");
  }

  @Step("Поле {0} заполняется значением {1}")
  public void stepFillField(String field, String value) {
    insuranceFormPage.fillFields(field, value);
  }

  @Step("Заполнение полей формы:")
  public void fillAllFields(HashMap<String, String> map) {
    map.forEach(this::stepFillField);
  }

  @Step("Нажатие кнопки Продолжить")
  public void clickContinueButton() {
    insuranceFormPage.clickButton("Продолжить");
  }

  @Step("Получение сообщения в блоке ошибок")
  public String getErrorText() {
    String s = "";
    try {
      s = insuranceFormPage.getTotalErrorBlock().getText();
    } catch (NoSuchElementException e) {
      e.printStackTrace();
    }
    return s;
  }
}
