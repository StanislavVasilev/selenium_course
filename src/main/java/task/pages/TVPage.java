package task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPage extends BasePage {

  @FindBy(xpath = "//h1[text()='Телевизоры']")
  private WebElement tvPageTitle;

  @FindBy(name = "Цена от")
  private WebElement element;

  @FindBy(xpath = "//legend[text()='Производитель']/parent::fieldset/ul")
  private WebElement manufacturersList;

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

