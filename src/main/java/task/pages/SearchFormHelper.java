package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
   * Решено не использовать.
   */

  @FindBy(xpath = "//legend[text()='Производитель']/parent::fieldset/ul")
  private WebElement manufacturersList;

  /**
   * Чекбоксы LG и Samsung, а так же beats на странице наушников(не реализовано) в списке.
   */

  @FindBy(xpath = "//input[@type='checkbox'][@name='Производитель LG']/following-sibling::div")
  private WebElement checkBoxLg;

  @FindBy(xpath = "//input[@type='checkbox'][@name='Производитель Samsung']/following-sibling::div")
  private WebElement getCheckBoxSamsung;

  @FindBy(xpath = "//input[@type='checkbox'][@name='Производитель Beats']/following-sibling::div")
  private WebElement getCheckBoxBeats;

  /**
   * Заголовок раздела на странице
   */

  @FindBy(xpath = "//h1")
  private WebElement tvPageTitle;

  /**
   * Метод получает строку заголовка страницы
   */
  public String getPageTitle() {
    waitForVisibleElement(tvPageTitle);
    return tvPageTitle.getText();
  }

  /**
   * Ввод значения сумма в поле фильтра Цена от
   *
   * @param sum принимает значение суммы ОТ
   */
  public void fillCostFrom(int sum) {
    fillField(costFrom, Integer.toString(sum));
  }

  /**
   * Получение текста из тултипа, в котором пишется количество результатов поиска.
   *
   * @return строковое значение количества получившихся результатов
   */
  public int getSearchResultCount() {
    waitForVisibleElement(result);
    String searchCount = result.getText();
    return Integer.parseInt(searchCount.replaceAll("\\D+", ""));
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
    return list.get(resultItemNumber - 1);
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
    switch (manufacturerName) {
      case "LG":
        waitAndClickElement(checkBoxLg);
        break;
      case "Samsung":
        waitAndClickElement(getCheckBoxSamsung);
        break;
      case "Beats":
        waitAndClickElement(getCheckBoxBeats);
        break;
    }
  }

}
