package task.steps;

import io.qameta.allure.Step;
import task.pages.MarketPage;

public class MarketPageSteps {
  MarketPage page = new MarketPage();

  @Step("Открывается меню Каталог товаров")
  public MarketPageSteps openItemsCatalog(){
    page.openMenu();
    return this;
  }

  @Step("Проверяется, что открыто меню Электроника")
  public void checkCatalogItem(){
    page.checkCatalogHeader();
  }

  @Step("Выполняется переход по ссылке в подменю {0}")
  public MarketPageSteps openSubMenuLink(String submenuItemLink){
    page.openSubMenuLink(submenuItemLink);
    return this;
  }


}
