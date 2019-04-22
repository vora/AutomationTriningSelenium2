package com.qa.ascendum.test;

import com.qa.ascendum.base.TestBase;
import com.qa.ascendum.pageActions.HomePageActions;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public static final Logger log = Logger.getLogger(HomePageTest.class.getName());

    HomePageActions homepageactions = new HomePageActions();

    @Test
    public void validateHomepage() {
        homepageactions.verifyHomePageElements();
        homepageactions.checkLinks();
        homepageactions.searchData();
        homepageactions.mouseHoverServiceLink();
    }
}
