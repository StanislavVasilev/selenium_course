package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import task.pages.MainPage;
import task.steps.MainPageSteps;
import task.steps.MarketPageSteps;
import task.steps.TvSearchSteps;

public class ScenarioTvStepsDefinitions {
  MainPageSteps mainPageSteps = new MainPageSteps();
  MarketPageSteps marketPageSteps = new MarketPageSteps();
  TvSearchSteps tvSearchSteps = new TvSearchSteps();

  @When("^Выполнен переход на страницу Яндекс.Маркет$")
  public void gotoMarketPage() {
    mainPageSteps.gotoMarketPage();
  }

  @Then("^Выполнен переход на страницу раздела \"([^\"]*)\" $")
  public void gotoTvPage(String name) {
    marketPageSteps.openItemsCatalog().openSubMenuLink(name);
  }

  @When("^Выполнена проверка заголовка страницы")
  public void checkPageTitle() {
    tvSearchSteps.checkTvPageTitle();
  }

  @When("^Выполнен поиск телевизоров стоимостью от (\\d+) и фирмой производителем: \"([^\"]*)\" и \"([^\"]*)\"$")
  public void searchTv(int sum, String name1, String name2) {
    tvSearchSteps.fillCostFromField(20000);
    tvSearchSteps.selectManufactures(name1, name2);
  }

  @When("^проверено, что количество ожидаемых равно (\\d+) и оно равно фактическому $")
  public void checkSearchResultCount() {
    tvSearchSteps.getSearchResultFromFilters(500);
  }

  @When("^Из списка ТВ в результатах поиска взят (\\d+) элемент, по нему выполнен поиск и проверка, что в результатах поиска он есть$")
  public void checkTvInResults() {
    tvSearchSteps.getFirstModelAndSearch(1);
  }

}
