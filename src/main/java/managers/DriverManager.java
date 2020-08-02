package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private final PropertyManager property = new PropertyManager().getInstance();
  WebDriver driver;

  public WebDriver initDriver() {
    switch (property.getProperty("browser")) {
      case "firefox":
        driver = new FirefoxDriver();
        break;
      default:
        driver = new ChromeDriver();
        break;
    }
    return driver;
  }

  public WebDriver getDriver() {
    return initDriver();
  }

  public void stopDriver() {
    driver.quit();
    driver == null;
  }
}
