import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class InsuranceTest extends TestBase {

  @Test
  public void testInsurance() {
    driver.get(baseUrl);
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

}
