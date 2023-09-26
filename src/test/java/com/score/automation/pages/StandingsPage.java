package com.score.automation.pages;

import com.score.automation.BaseClass;
import com.score.automation.utils.TestUtil;
import org.openqa.selenium.support.PageFactory;

public class StandingsPage extends BaseClass {
    TestUtil testUtil = new TestUtil();
    public StandingsPage(){
        PageFactory.initElements(driver, this);
    }
    public void verifyStandingSubTabs(){
        //Verify that we are on the correct tab by verifying the Title of the Sub tabs
        testUtil.isTextPresent("CONFERENCE");
        testUtil.isTextPresent("DIVISION");
        testUtil.isTextPresent("OVERALL");

        //Table value from Conference Tab
        testUtil.isTextPresent("TOR Raptors");
    }
}
