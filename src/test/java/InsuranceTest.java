import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class InsuranceTest {
  private final WebDriver driver = getDriver();

  private WebDriver getDriver() {
    System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
    return new ChromeDriver();
  }
  
  @Before
  public void init() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://www.sberbank.ru/ru/person");
  }

  @Test
  public void testInsurance() {
    moveToElement("//span[text()='Страхование']/parent::button");
    moveToElementAndClick("//span[text()='Страхование']/ancestor::li//a[text()='Страхование путешественников']");
    String text = driver.findElement(By.xpath("//b[text()='Оформить онлайн']/ancestor::div[@class='kit-col kit-col_xs_12 kit-col_lg-top_40']/parent::div[@class='kit-row']//h1")).getText();
    Assert.assertEquals("Страхование путешественников", text);
    clickOnElement("//b[@class='kit-button__text'][text()='Оформить онлайн']");
    clickOnElement("//button[text()='Оформить']");
    fillField("//input[@id='surname_vzr_ins_0']", "Васильев");
    fillField("//input[@id='name_vzr_ins_0']", "Станислав");
    fillField("//input[@id='birthDate_vzr_ins_0']", "18121985");
    fillField("//input[@id='person_lastName']", "Васильев");
    fillField("//input[@id='person_firstName']", "Станислав");
    fillField("//input[@id='person_middleName']", "Вадимович");
    fillField("//input[@id='person_birthDate']", "18121985");
    fillField("//input[@id='passportSeries']", "1234");
    fillField("//input[@id='passportNumber']", "567890");
    fillField("//input[@id='documentDate']", "22112006");
    fillField("//input[@id='documentIssue']", "УВД МВД ГКЧП EКЛМН");
    clickOnElement("//button[contains(text(), 'Продолжить')]");
    String errorText = driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText();
    Assert.assertEquals("При заполнении данных произошла ошибка", errorText);
  }

  @After
  public void close() {
    driver.quit();
  }

  private void fillField(String locator, String value) {
    driver.findElement(By.xpath(locator)).click();
    driver.findElement(By.xpath(locator)).sendKeys(value);
  }

  private void clickOnElement(String locator) {
    driver.findElement(By.xpath(locator)).click();
  }

  private void moveToElement(String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).build().perform();
  }

  private void moveToElementAndClick(String locator) {
    WebElement element = driver.findElement(By.xpath(locator));
    Actions actions = new Actions(driver);
    actions.moveToElement(element).click().build().perform();
  }
}
