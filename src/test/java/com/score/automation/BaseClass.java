package com.score.automation;

import com.score.automation.pages.SetupPages;
import com.score.config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static AppiumDriver<MobileElement> driver;
    public static ConfigReader configReader = new ConfigReader();

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set the device capabilities and app information
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getDeviceName());
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getPlatformName());
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getPlatformVersion());

        caps.setCapability("app", configReader.getAppPath());
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, configReader.getPackageName());
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, configReader.getAppActivity());

        caps.setCapability(MobileCapabilityType.UDID, configReader.getUdid());
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getAutomationName());

        // Initialize the Driver instance
        URL remoteURL = new URL(configReader.getAppiumServerUrl());
        driver = new AndroidDriver<>(remoteURL, caps);

        //Set the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        SetupPages setupPages = new SetupPages();
        setupPages.setUpActionsClick();
    }

    @BeforeMethod
    public void appLaunch() {
        driver.activateApp(configReader.getPackageName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}