package task.steps;

import io.cucumber.java.eo.Se;
import io.qameta.allure.Step;
import org.junit.Assert;
import task.pages.SearchFormHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HeadPhonesSearchSteps {
  SearchFormHelper searchForm = new SearchFormHelper();

  @Step("Проверяется заголовок страницы Наушники и Bluetooth-гарнитуры")
  public void checkTvPageTitle() {
    Assert.assertEquals("Наушники и Bluetooth-гарнитуры", searchForm.getPageTitle());
  }

  @Step("Выполняется ввод значения {0} в поиске по полю Цена от ")
  public void fillCostFromField() {
    searchForm.fillCostFrom(10000);
  }

  @Step("Выбираются нужные модели: {0} ")
  public void selectManufactures() {
    searchForm.selectManufacturer("Beats");
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
  public void getFirstModelAndSearch() {
    String tvNameBefore = searchForm.getResultStringName(1);
    searchForm.searchFor(tvNameBefore);
    String tvNameAfter = searchForm.getResultStringName(1);
    Assert.assertEquals(tvNameBefore, tvNameAfter);
  }
}
