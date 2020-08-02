package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
  private static final PropertyManager property = new PropertyManager().getInstance();
  private static WebDriver driver;

  private static WebDriver initDriver() {
    switch (property.getProperty("browser")) {
      case "firefox":
        System.setProperty("", "");
        driver = new FirefoxDriver();
        break;
      default:
        System.setProperty("", "");
        driver = new ChromeDriver();
        break;
    }
    return driver;
  }

  public static WebDriver getDriver() {
    if (driver==null){
      initDriver();
    }
    return driver;
  }

  public void stopDriver() {
    driver.quit();
    driver = null;
  }
}
