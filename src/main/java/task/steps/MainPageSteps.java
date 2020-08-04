package task.steps;

import io.qameta.allure.Step;
import task.pages.MainPage;

public class MainPageSteps {
  MainPage page = new MainPage();

  @Step("Выполняется переход с главной страницы на страницу Яндекс.Маркет")
  public void gotoMarketPage(){
    page.gotoMarket();
  }

}
