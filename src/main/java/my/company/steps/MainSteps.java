package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.MainPage;


public class MainSteps extends BaseSteps {

  MainPage mainPage = new MainPage(driver);

  @Step("Выбран пункт меню {0}")
  public void stepSelectMenu(String menuItem) {
    mainPage.openMenu(menuItem);
  }

  @Step("Выбран пункт подменю {0}")
  public void stepSelectSubMenuItem(String subMenuItem){
    mainPage.openSubMenu(subMenuItem);
  }
}
