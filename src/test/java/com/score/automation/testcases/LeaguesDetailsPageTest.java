package com.score.automation.testcases;

import com.score.automation.BaseClass;
import com.score.automation.pages.LeaguesDetailsPage;
import com.score.automation.pages.LeaguesLandingPage;
import com.score.automation.utils.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LeaguesDetailsPageTest extends BaseClass {
    LeaguesLandingPage leaguesLandingPage;
    LeaguesDetailsPage leagueDetailsPage;
    TestUtil testUtil = new TestUtil();
    public LeaguesDetailsPageTest(){
        super();
    }

    @DataProvider(name = "leagues")
    public Object[] leagues(){
        return new Object[]{"NBA"};
    }

    @Test(dataProvider = "leagues")
    public void leaguesLandingTest_01(String league){
        leaguesLandingPage = new LeaguesLandingPage();

        // Click on the League passed from Data Provider
        leagueDetailsPage = leaguesLandingPage.nbaLeagueClick(league);

        //Verify that the expected Page landing by checking the Title of the Page
        testUtil.isTextPresent(league);

        /* Tap on a sub-tab of our choice, Clicking on the STANDINGS tab
           Inside the same Method, Verifying the SubSection titles to ensure we are on Standings tab

           Also verified one of the table value 'TOR Raptors' under 'Conference' tab to
           confirm that we are under the expected NBA - Standings tab    */
        leagueDetailsPage.subTabClick();

        //Tap on back navigation and verify it returns to the previous page
        leagueDetailsPage.navigateBackClick();
    }
}