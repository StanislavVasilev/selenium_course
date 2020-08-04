package task.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import task.pages.SearchFormHelper;
import task.pages.TvPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    searchForm.selectManufacturer(name1).selectManufacturer(name2);
  }

  @Step("Проверяется число найденных моделей")
  public void getSearchResultFromFilters(int count) {
    String searchCount = searchForm.getSearchResult();
    Pattern pattern = Pattern.compile("/d");
    Matcher matcher = pattern.matcher(searchCount);
    int resultCount = Integer.parseInt(matcher.group());
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
