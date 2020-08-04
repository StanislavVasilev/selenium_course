package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage extends BasePage {
  /**
   * элемент Каталог товаров
   */
  @FindBy(xpath = "//button[@role='tab']")
  private WebElement menuItem;

  @FindBy(xpath = "//span[text()='Электроника']//ancestor::button")
  private WebElement electronicsButton;

  @FindBy(xpath = "//a[text()='Электроника']/parent::div//a[text()='Телевизоры']")
  private WebElement linkToTvPage;

  @FindBy(xpath = "//a[text()='Электроника']/parent::div//a[text()='Наушники и Bluetooth-гарнитуры']")
  WebElement linkToHeadPhonesPage;

  public void selectElectronics() {
    moveToElement(electronicsButton);
  }

  public void openMenu() {
    clickElement(menuItem);
  }

  public void openSubMenuLink(String subMenuItem) {
    switch (subMenuItem) {
      case "Телевизоры":
        moveToElement(linkToTvPage);
        clickElement(linkToTvPage);
        break;
      case "Наушники и Bluetooth-гарнитуры":
        moveToElement(linkToHeadPhonesPage);
        clickElement(linkToHeadPhonesPage);
        break;
    }
  }

}
