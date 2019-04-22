package com.qa.ascendum.pageActions;

import com.qa.ascendum.base.BaseActions;
import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageLocators.HomePageLocators;


public class HomePageActions extends TestBase {

    BaseActions baseActions = new BaseActions();
    HomePageLocators homePageLocators = new HomePageLocators();

    String enterText = "testing blog";
    String searchText = enterText;

    public void verifyHomePageElements() {
        baseActions.checkIfWebElementIsPresent(homePageLocators.link_services);
        baseActions.checkIfWebElementIsPresent(homePageLocators.link_resources);
        baseActions.checkIfWebElementIsPresent(homePageLocators.link_careers);
        baseActions.checkIfWebElementIsPresent(homePageLocators.link_contact);

    }

    public void checkLinks() {
        baseActions.checkAllAnchorTags();
    }

    public void searchData() {
        baseActions.searchText(homePageLocators.textBox_search, enterText);
        baseActions.clickLinksAndButtons(homePageLocators.icon_search);
        baseActions.retrievedSearchResults(homePageLocators.searcResults, searchText);
    }

    public void mouseHoverServiceLink()
    {
        baseActions.mousehover(homePageLocators.link_services);
        baseActions.clickLinksAndButtons(homePageLocators.tab_secondItem);
    }

}
