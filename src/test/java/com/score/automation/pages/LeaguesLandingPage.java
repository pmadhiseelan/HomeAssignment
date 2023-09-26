package com.score.automation.pages;

import com.score.automation.BaseClass;
import com.score.automation.utils.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LeaguesLandingPage extends BaseClass {
    TestUtil testUtil = new TestUtil();
    String leagueXpath = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/league_name_text' and @text='%s']";

    public LeaguesLandingPage(){
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @param league - League name
     * @return - new LeagueDetailspage instance
     */
    public LeaguesDetailsPage nbaLeagueClick(String league) {
        leagueXpath = String.format(leagueXpath, league);
        testUtil.waitForElementClickable(2, driver.findElement(By.xpath(leagueXpath)),true);
        return new LeaguesDetailsPage(league);
    }
}