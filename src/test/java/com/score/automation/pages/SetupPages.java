package com.score.automation.pages;

import com.score.automation.BaseClass;
import com.score.automation.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetupPages extends BaseClass {
    TestUtil testUtil = new TestUtil();
    //Welcome Page Elements & Action
    @FindBy(id = "com.fivemobile.thescore:id/action_button_text")
    WebElement getStarted_BTN;

    //Choose Fav Leagues Page
    @FindBy(id = "com.fivemobile.thescore:id/action_button_text")
    WebElement continueFav_BTN;

    //Choose Fav Teams Page
    @FindBy(id = "com.fivemobile.thescore:id/btn_allow")
    WebElement allowLocation_BTN;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    WebElement whileUsingTheApp_BTN;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name' and @text='Toronto Raptors']")
    WebElement chooseTheTeam_OPTN;

    @FindBy(id = "com.fivemobile.thescore:id/action_button_text")
    WebElement continue_BTN;

   // Notifications Page
    @FindBy(id = "com.fivemobile.thescore:id/action_button_text")
    WebElement notifiDone_BTN;

    @FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    WebElement allowNotification_BTN;

    //Landing Favourites Page
    @FindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
    WebElement scoreBetDismissal_BTN;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Leagues\"]/android.view.ViewGroup/android.widget.TextView")
    WebElement leaguesBottomNav_LNK;

    public void setUpActionsClick(){
        // Welcome Page
        getStarted_BTN.click();

        // Choose Fav Leagues Page
        continueFav_BTN.click();

        // Choose Fav Teams Page
        allowLocation_BTN.click();
        whileUsingTheApp_BTN.click();
        chooseTheTeam_OPTN.click();
        continue_BTN.click();

        // Notifications Page
        notifiDone_BTN.click();
        testUtil.waitForElementClickable(3, allowNotification_BTN, true );

        // Landing Favourites Page
        testUtil.waitForElementClickable(4, scoreBetDismissal_BTN, true );
        leaguesBottomNav_LNK.click();
    }

    public SetupPages(){
        PageFactory.initElements(driver, this);
    }

}