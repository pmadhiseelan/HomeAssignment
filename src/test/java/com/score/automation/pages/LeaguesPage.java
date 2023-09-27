package com.score.automation.pages;

import com.score.automation.BaseClass;
import com.score.automation.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaguesPage extends BaseClass {
    TestUtil testUtil = new TestUtil();
    StandingsPage standingsPage = new StandingsPage();
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Standings']")
    WebElement standings_TAB;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement navigateBack_BTN;

    /**
     * Initialize Page factory elements in constructor
     */
    public LeaguesPage() {
        PageFactory.initElements(driver, this);
    }

    public void subTabClick() {
        standings_TAB.click();
        //Verify standing sub tabs
        standingsPage.verifyStandingSubTabs();
    }

    public void navigateBackClick() {
        //Tap on the Up navigation button
        navigateBack_BTN.click();
        //Verify that back navigation returns you to the previous page by checking the title of the page
        testUtil.isTextPresent("Leagues");
    }
}