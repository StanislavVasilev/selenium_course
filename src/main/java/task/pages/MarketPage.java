package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage extends BasePage {
  /**
   * элемент Каталог товаров
   */
//  @FindBy(xpath = "//button[@role='tab']")
  @FindBy(xpath = "//span[text()='Каталог товаров']")
  private WebElement menuItem;
  /**
   * Локатор тултипа, который закрывает собой кнопку Каталог Товаров. Этот тултип открывается на странице маркета при переходе к ней.
   */
  @FindBy(xpath = "//span[contains(text(), 'Напишите, какой товар вам нужен')]")
  private WebElement tooltip;

  @FindBy(xpath = "//span[text()='Да, спасибо']/parent::button")
  private WebElement closePopupButton;

  @FindBy(xpath = "//span[text()='Электроника']//ancestor::button")
  private WebElement electronicsButton;

  @FindBy(xpath = "//a[text()='Электроника']/parent::div//a[text()='Телевизоры']")
  private WebElement linkToTvPage;

  @FindBy(xpath = "//a[text()='Электроника']/parent::div//a[text()='Наушники и Bluetooth-гарнитуры']")
  WebElement linkToHeadPhonesPage;

  private void selectElectronics() {
    moveToElement(electronicsButton);
  }

  public void openMenu() {
    switchToNextHandle();
    clickElement(closePopupButton);
    clickElement(tooltip);
    moveToElement(menuItem);
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

  public void checkCatalogHeader() {
  }
}
