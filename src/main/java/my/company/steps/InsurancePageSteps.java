package my.company.steps;

import my.company.pages.InsuranceForTravelersPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsurancePageSteps extends BaseSteps {

  @Step("Нажатие на кнопку Оформить")
  public void clickMakeInsuranceButton() {
    new InsuranceForTravelersPage(driver).clickRegisterInsuranceButton();
  }
}
