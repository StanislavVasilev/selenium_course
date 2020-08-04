package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализован для поиска на странице выбранного раздела. Для всех разделов эти элементы и методы одинаковы.
 */
public class SearchFormHelper extends BasePage {

  /**
   * Поле поискового фильтра "Цена от"
   */
  @FindBy(name = "Цена от")
  private WebElement costFrom;

  /**
   * Тултип, который показывает количество результатов поиска
   */
  @FindBy(xpath = "//div[contains(text(), 'Найдено')]")
  private WebElement result;

  /**
   * Блок с результатами поиска
   */
  @FindBy(xpath = "//div[@data-zone-name='SearchResults']")
  private WebElement resultItem;

  /**
   * Поле ввода строкового поискового запроса под шапкой страницы.
   */
  @FindBy(id = "header-search")
  private WebElement searchField;

  /**
   * Кнопка Найти справа от поля ввода строкового запроса.
   */
  @FindBy(xpath = "//div[text()='Найти']/parent::button[@type='submit']")
  private WebElement searchButton;

  /**
   * Блок с элементами фильтра Производитель.
   */
  @FindBy(xpath = "//legend[text()='Производитель']/parent::fieldset/ul")
  private WebElement manufacturersList;

  /**
   * Ввод значения сумма в поле фильтра Цена от
   *
   * @param sum принимает значение суммы ОТ
   */
  public void fillCostFrom(String sum) {
    fillField(costFrom, sum);
  }

  /**
   * Получение текста из тултипа, в котором пишется количество результатов поиска.
   *
   * @return строковое значение количества получившихся результатов
   */
  public String getSearchResult() {
    waitForVisibleElement(result);
    return result.getText();
  }

  /**
   * Метод получает список наименований из результатов поиска.
   *
   * @return возвращается список телевизоров в порядке добавления.
   */
  public List<String> getResultList() {
    List<String> stringList = new ArrayList<>();
    List<WebElement> list = resultItem.findElements(By.xpath("//div[@data-zone-name='SearchResults']//a[@title]"));
    list.forEach(webElement -> stringList.add(webElement.getAttribute("title")));
    return stringList;
  }

  /**
   * @param resultItemNumber передается порядковый номер списка найденных телевизоров
   */
  public String getResultStringName(int resultItemNumber) {
    List<String> list = getResultList();
    return list.get(resultItemNumber);
  }

  /**
   * Заполнение поискового поля ввода
   *
   * @param name наименование элемента
   */
  private void fillSearchField(String name) {
    fillField(searchField, name);
  }

  /**
   * Выполнение поиска
   *
   * @param name
   */
  public void searchFor(String name) {
    fillSearchField(name);
    clickElement(searchButton);
  }


  /**
   * Выбор производиетеля
   *
   * @param manufacturerName принимает наименование производителя как входной параметр.
   */
  public void selectManufacturer(String manufacturerName) {
    String base = "Производитель ";
    switch (manufacturerName) {
      case "LG":
        manufacturersList.findElement(By.name(base + "LG")).click();
        break;
      case "Samsung":
        manufacturersList.findElement(By.name(base + "Samsung")).click();
        break;
      case "Beats":
        manufacturersList.findElement(By.name(base + "Beats")).click();
        break;
    }
  }

}
