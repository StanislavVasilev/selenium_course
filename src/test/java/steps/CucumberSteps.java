package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import my.company.steps.InsuranceFormSteps;
import my.company.steps.InsurancePageSteps;
import my.company.steps.MainSteps;
import org.junit.Assert;

import java.util.Map;

public class CucumberSteps {
  MainSteps mainSteps = new MainSteps();
  InsuranceFormSteps insuranceFormSteps = new InsuranceFormSteps();
  InsurancePageSteps insurancePageSteps = new InsurancePageSteps();

  @When("^выбран пункт меню \"(.+)\"$")
  public void selectMenuItem(String menuItem) {
    mainSteps.stepSelectMenu(menuItem);
  }

  @When("^выбран пункт подменю -\"(.+)\"$")
  public void selectSubmenuItem(String submenuItem) {
    mainSteps.stepSelectSubMenuItem(submenuItem);
  }

  @Then("^выполнено нажатие нажатие на кнопку - Оформить онлайн")
  public void clickMakeInsuranceButton() {
    insurancePageSteps.clickMakeInsuranceButton();
  }

  @When("^выполнено нажатие на кнопку Оформить и переход на 2ю вкладку Оформление")
  public void stepClickToMakeRegisterPerson() {
    insuranceFormSteps.makeRegisterPerson();
  }

  @When("^заполняются поля формы")
  public void stepFillFields(DataTable dataTable) {
    Map<String, String> map = dataTable.asMap(String.class, String.class);
    map.forEach((key, value) -> insuranceFormSteps.stepFillField(key, value));
  }

  @When("^выполнно нажатие на кнопку Продолжить")
  public void stepClickContinueButton() {
    insuranceFormSteps.clickContinueButton();
  }

  @Then("^проверка текста ошибки$")
  public void checkErrorText(){
    String errorText = insuranceFormSteps.getErrorText();
    Assert.assertEquals("Hello world", errorText);
  }

}
