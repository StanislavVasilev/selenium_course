package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import my.company.managers.InitManager;

public class Hooks {

  /**
   * doc
   */
  @Before
  public static void setUp() {
    InitManager.setUp();
  }

  @After
  public static void afterMethod() {
    InitManager.quitFramework();
  }


}
