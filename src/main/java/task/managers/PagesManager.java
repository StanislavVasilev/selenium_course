package task.managers;

import task.pages.*;

public class PagesManager {

  private static PagesManager pageManager;
  private MainPage mainPage;
  private MarketPage marketPage;
  private SearchFormHelper searchFormHelper;
  private HeadPhonesPage headPhonesPage;
  private TvPage tvPage;

  public PagesManager() {
  }

  private PagesManager getApp() {
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

  public SearchFormHelper getSearchFormHelper() {
    if (searchFormHelper == null) {
      searchFormHelper = new SearchFormHelper();
    }
    return searchFormHelper;
  }

  public HeadPhonesPage getHeadPhonesPage() {
    if (headPhonesPage == null) {
      headPhonesPage = new HeadPhonesPage();
    }
    return headPhonesPage;
  }

  public TvPage getTvPage() {
    if (tvPage == null) {
      tvPage = new TvPage();
    }
    return tvPage;
  }

}
