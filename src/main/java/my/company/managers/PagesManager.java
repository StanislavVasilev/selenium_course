package my.company.managers;

import my.company.pages.BasePage;
import my.company.pages.InsuranceForTravelersPage;
import my.company.pages.InsuranceFormPage;
import my.company.pages.MainPage;

public class PagesManager {
  private static PagesManager pagesManager;
  BasePage basePage;
  InsuranceFormPage insuranceFormPage;
  InsuranceForTravelersPage insuranceForTravelersPage;
  MainPage mainPage;

  public PagesManager() {
  }

  public static PagesManager getPagesManager() {
    if (pagesManager == null) {
      pagesManager = new PagesManager();
    }
    return pagesManager;
  }

  public BasePage getBasePage() {
    if (basePage == null) {
      basePage = new BasePage();
    }
    return basePage;
  }

  public InsuranceFormPage getInsuranceFormPage() {
    if (insuranceFormPage == null) {
      insuranceFormPage = new InsuranceFormPage();
    }
    return insuranceFormPage;
  }

  public InsuranceForTravelersPage getInsuranceForTravelersPage() {
    if (insuranceForTravelersPage == null) {
      insuranceForTravelersPage = new InsuranceForTravelersPage();
    }
    return insuranceForTravelersPage;
  }


  public MainPage getMainPage() {
    if (mainPage == null) {
      mainPage = new MainPage();
    }
    return mainPage;
  }
}
