package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeadPhonesPage extends BasePage {
  /**
   * Заголовок раздела на странице
   */
  @FindBy(xpath = "//h1[text()='Наушники и Bluetooth-гарнитуры']")
  private WebElement tvPageTitle;

}
