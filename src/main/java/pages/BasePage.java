package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
  WebDriver driver;

  protected void fillField(String locator, String value) {
    driver.findElement(By.xpath(locator)).click();
    driver.findElement(By.xpath(locator)).sendKeys(value);
  }

  protected void clickOnElement(String locator) {
    driver.findElement(By.xpath(locator)).click();
  }

  protected void moveToElement(String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
  }

  protected void moveToElementAndClick(String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().build().perform();
  }
}
