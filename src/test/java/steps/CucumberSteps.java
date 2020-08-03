package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import my.company.steps.InsuranceFormSteps;
import my.company.steps.InsurancePageSteps;
import my.company.steps.MainSteps;

import java.util.Map;

public class CucumberSteps {
  MainSteps mainSteps = new MainSteps();
  InsuranceFormSteps insuranceFormSteps = new InsuranceFormSteps();
  InsurancePageSteps insurancePageSteps = new InsurancePageSteps();

  @When("^выбран пункт меню \"(.+)\"$")
  public void selectMenuItem(String menuItem) {
    mainSteps.stepSelectMenu(menuItem);
    throw new cucumber.api.PendingException();
  }

  @When("^выбран пункт подменю -\"(.+)\"$")
  public void selectSubmenuItem(String submenuItem) {
    mainSteps.stepSelectSubMenuItem(submenuItem);
    throw new cucumber.api.PendingException();
  }

  @Then("^выполнено нажатие нажатие на кнопку - Оформить онлайн")
  public void clickMakeInsuranceButton() {
    insurancePageSteps.clickMakeInsuranceButton();
    throw new cucumber.api.PendingException();
  }

  @When("^выполнено нажатие на кнопку Оформить и переход на 2ю вкладку Оформление")
  public void stepClickToMakeRegisterPerson() {
    insuranceFormSteps.makeRegisterPerson();
    throw new cucumber.api.PendingException();
  }

  @When("^заполняются поля формы")
  public void stepFillFields(DataTable dataTable) {
    Map<String, String> map = dataTable.asMap(String.class, String.class);
    map.forEach((key, value) -> insuranceFormSteps.stepFillField(key, value));
  }

  @Then("^выполнно нажатие на кнопку Продолжить")
  public void stepClickContinueButton() {
    insuranceFormSteps.clickContinueButton();
    throw new cucumber.api.PendingException();
  }

//  @Тогда("^проверка текста в ошибки")
//  public boolean checkErrorText(String text) {
//    return insuranceFormSteps.getErrorText().equals(text);
//  }
}
