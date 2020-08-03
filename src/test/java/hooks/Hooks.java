package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import my.company.managers.InitManager;
import my.company.steps.BaseSteps;

public class Hooks {

  /**
   * Хуки кукумбера классы с аналогами бефора, афтера и других анноттаций. Используеются вместо аннотаций junit.
   * Путь к хукам указывается в кукумбер-ранере.
   *
   * @see cucumberRunner.CucumberRunner
   */
  @Before
  public static void setUp() {
    InitManager.setUp();
  }

  /**
   * Если тест упал - создается скриншот.
   *
   * @param scenario передается сценарий кукумбера
   */
  @After
  public static void afterMethod(Scenario scenario) {
    if (scenario.isFailed()) {
      BaseSteps.takeScreenshot();
    }
    InitManager.quitFramework();
  }


}
