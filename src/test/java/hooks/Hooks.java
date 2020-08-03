package hooks;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import my.company.managers.InitManager;
import my.company.steps.BaseSteps;

public class Hooks {

  /**
   * doc
   */
  @Before
  public static void setUp() {
    InitManager.setUp();
  }

  @After
  public static void afterMethod(Scenario scenario) {
    if (scenario.isFailed()) {
      BaseSteps.takeScreenshot();
    }
    InitManager.quitFramework();
  }


}
