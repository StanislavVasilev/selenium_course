package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.InsuranceForTravelersPage;


public class InsurancePageSteps extends BaseSteps{

  @Step("Нажатие на кнопку Оформить онлайн")
  public void clickMakeInsuranceButton() {
    new InsuranceForTravelersPage().clickRegisterInsuranceButton();
  }
}
