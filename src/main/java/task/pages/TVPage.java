package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage extends BasePage {
  /**
   * Заголовок раздела на странице
   */
  @FindBy(xpath = "//h1[text()='Телевизоры']")
  private WebElement tvPageTitle;

}

