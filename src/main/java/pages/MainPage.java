package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
  @FindBy(xpath = "//span[text()='Страхование']/parent::button")
  public WebElement insuranceSubMenu;

  public MainPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(insuranceSubMenu));
    this.driver = driver;
  }
}
