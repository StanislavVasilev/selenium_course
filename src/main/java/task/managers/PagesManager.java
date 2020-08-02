package task.managers;

import task.pages.*;

public class PagesManager {

  private static PagesManager pageManager;
  private MainPage mainPage;
  private MarketPage marketPage;
  private ElectronicsPage electronicsPage;
  private HeadPhonesPage headPhonesPage;
  private TVPage tvPage;
  private ResultPage resultPage;

  public PagesManager() {
  }

  public PagesManager getApp() {
    if (pageManager == null) {
      pageManager = new PagesManager();
    }
    return this;
  }

  public MainPage getMainPage() {
    if (mainPage == null) {
      mainPage = new MainPage();
    }
    return mainPage;
  }

  public MarketPage getMarketPage() {
    if (marketPage == null) {
      marketPage = new MarketPage();
    }
    return marketPage;
  }

  public ElectronicsPage getElectronicsPage() {
    if (electronicsPage == null) {
      electronicsPage = new ElectronicsPage();
    }
    return electronicsPage;
  }

  public HeadPhonesPage getHeadPhonesPage() {
    if (headPhonesPage == null) {
      headPhonesPage = new HeadPhonesPage();
    }
    return headPhonesPage;
  }

  public TVPage getTvPage() {
    if (tvPage == null) {
      tvPage = new TVPage();
    }
    return tvPage;
  }

  public ResultPage getResultPage() {
    if (resultPage == null) {
      resultPage = new ResultPage();
    }
    return resultPage;
  }
}
