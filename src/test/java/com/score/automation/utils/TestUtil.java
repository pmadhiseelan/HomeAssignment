package com.score.automation.utils;

import com.score.automation.BaseClass;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TestUtil extends BaseClass {


public enum LOCATORTYPE {ID,XPATH}
    // Assertion method to check if an element is present

    /**
     *
     * @param locatorType - Locator type enum
     * @param locator - locator string - id/xpath etc.
     */
    public static void assertElementPresent(LOCATORTYPE locatorType, String locator) {
        int size ;
        switch (locatorType) {
            case ID:
                size = driver.findElements(By.id(locator)).size();
                break;
            case XPATH:
                size = driver.findElements(By.xpath(locator)).size();
                break;
            default:
                size = 0;
                break;
        }
        Assert.assertTrue(size>0,"Element is present :" + locator);
    }

    public void isTextPresent(String expectedText){
        List<MobileElement> textElements = driver.findElements(By.xpath("//*[@text='"+ expectedText +"']"));
        Assert.assertFalse(textElements.isEmpty(),"Element exists in screen");
    }

    /**
     * This method waits until the specified element is clickable
     * @param seconds - Max number of seconds to wait
     * @param element - Element to wait
     * @param click - Clicks on the element if true
     */
    public void waitForElementClickable(int seconds, WebElement element, boolean click){
        WebDriverWait wait = new WebDriverWait(driver, seconds);

        WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(element));
        if(click) {
            elementClick.click(); // Click on the element
        }
    }
}
