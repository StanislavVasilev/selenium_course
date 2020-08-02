package my.company.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import org.junit.Assert;

import java.util.Map;

public class CucumberSteps {
  MainSteps mainSteps = new MainSteps();
  InsuranceFormSteps insuranceFormSteps = new InsuranceFormSteps();
  InsurancePageSteps insurancePageSteps = new InsurancePageSteps();

  @When("^выбран пункт меню \"(.*)\"$")
  public void stepSelectMenuItem(String menuItem) {
    mainSteps.stepSelectMenu(menuItem);
  }

  @When("^выбран пункт подменю - \"(.*)\"$")
  public void stepSelectSubMenuItem(String submenuItem) {
    mainSteps.stepSelectSubMenuItem(submenuItem);
  }

  @When("^выполнено нажатие нажатие на кнопку - Оформить онлайн")
  public void stepClickMakeInsuranceButton() {
    insurancePageSteps.clickMakeInsuranceButton();
  }

  @When("выполнено нажатие на кнопку Оформить и переход на 2ю вкладку Оформление")
  public void stepClickToMakeRegisterPerson() {
    insuranceFormSteps.makeRegisterPerson();
  }

  @When("заполняются поля: ")
  public void stepFillFields(DataTable dataTable) {
    Map<String, String> map = dataTable.asMap(String.class, String.class);
    map.forEach((key, value) -> insuranceFormSteps.stepFillField(key, value));
  }

  @Когда("выполнно нажатие на кнопку Продолжить")
  public void stepClickContinueButton() {
    insuranceFormSteps.clickContinueButton();
  }

  @Then("^проверка текста в ошибки")
  public void checkErrorText(String text){
    Assert.assertEquals(insuranceFormSteps.getErrorText(), text);
  }
}
