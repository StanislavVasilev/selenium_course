package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Когда;
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

  @Когда("Выполнен переход на страницу раздела {string}")
  public void gotoTvPage(String arg0) {
    marketPageSteps.checkCatalogItem().openSubMenuLink(arg0);
  }

  @When("^Выполнена проверка заголовка страницы")
  public void checkPageTitle() {
    tvSearchSteps.checkTvPageTitle();
  }

  @When("^Выполнен поиск телевизоров стоимостью от (\\d+) и фирмой производителем: \"(.+)\" и \"(.+)\"$")
  public void searchTv(int sum, String name1, String name2) {
    tvSearchSteps.fillCostFromField(sum);
    tvSearchSteps.selectManufactures(name1, name2);
  }

  @Then("^проверка, что ожидаемое и фактическое количество найденных моделей равны (\\d+)")
  public void checkSearchResultCount(int count) {
    tvSearchSteps.getSearchResultFromFilters(count);
  }

  @When("^Из списка в результатах поиска взят (\\d+) элемент, по нему выполнен поиск и проверка, что в результатах поиска он есть$")
  public void checkTvInResults(int modelNumber) {
    tvSearchSteps.getFirstModelAndSearch(modelNumber);
  }

}
