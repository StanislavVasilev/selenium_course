package task.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import task.pages.SearchFormHelper;
import task.pages.TvPage;

public class TvSearchSteps {
  SearchFormHelper searchForm = new SearchFormHelper();
  TvPage page = new TvPage();

  @Step("Проверяется заголовок страницы Телевизоры")
  public void checkTvPageTitle() {
    Assert.assertEquals("Телевизоры", searchForm.getPageTitle());
  }

  @Step("Выполняется ввод значения {0} в поиске по полю Цена от ")
  public void fillCostFromField(int sum) {
    searchForm.fillCostFrom(sum);
  }

  @Step("Выбираются нужные модели: {0} и {1}")
  public void selectManufactures(String name1, String name2) {
    searchForm.selectManufacturer(name1);
    searchForm.selectManufacturer(name2);
  }

  @Step("Проверяется число найденных моделей")
  public void getSearchResultFromFilters(int count) {
    int resultCount = searchForm.getSearchResultCount();
    Assert.assertEquals(count, resultCount);
  }


  @Step("Выбрана первая модель из списка, выполнен поиск по ее наименованию и проверка, что в результатах поиска та модель, которую искали")
  public void getFirstModelAndSearch(int resultNumber) {
    String tvNameBefore = searchForm.getResultStringName(resultNumber);
    searchForm.searchFor(tvNameBefore);
    String tvNameAfter = searchForm.getResultStringName(resultNumber);
    Assert.assertEquals(tvNameBefore, tvNameAfter);
  }
}
