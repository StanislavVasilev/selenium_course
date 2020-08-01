package my.company.steps;

import io.qameta.allure.Step;
import my.company.pages.MainPage;


public class MainSteps extends BaseSteps {

  MainPage mainPage = new MainPage(driver);

  @Step("Выбран пункт меню {0}, выбран пункт подменю {1}")
  public void stepSelectMenu(String menuItem, String subMenuItem) {
    mainPage.openMenu(menuItem).openSubMenu(subMenuItem);
  }
}
