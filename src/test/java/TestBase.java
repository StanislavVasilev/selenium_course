import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
  protected static WebDriver driver;
  protected static String baseUrl;
  public static Properties properties = TestProperties.getInstance().getProperties();

  @BeforeClass
  public static void setUp() throws Exception {
    switch (properties.getProperty("browser")) {
      case "firefox":
        System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
        driver = new FirefoxDriver();
        break;
      case "chrome":
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        break;
      default:
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }
    baseUrl = properties.getProperty("app.url");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    driver.quit();
  }

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

  protected boolean isElementPresent(String locator) {
    try {
      driver.findElement(By.xpath(locator));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
