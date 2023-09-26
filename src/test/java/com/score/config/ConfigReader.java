package com.score.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private String appiumServerUrl;
    private String platformVersion;
    private String udid;
    private String appPath;
    private String packageName;
    private String platformName;
    private String appActivity;
    private String deviceName;
    private String automatioName;
    public ConfigReader(){
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
            prop.load(fis);
            fis.close();
            appiumServerUrl = prop.getProperty("appiumServer");
            appPath = System.getProperty("user.dir") + "/" + prop.getProperty("appPath");
            packageName = prop.getProperty("packageName");
            appActivity = prop.getProperty("appActivity");
            automatioName = prop.getProperty("automationName");
            deviceName = prop.getProperty("deviceName");
            platformName = prop.getProperty("platformName");
            platformVersion = prop.getProperty("platformVersion");
            udid = prop.getProperty("ud_id");

        } catch (
                IOException e) {
            System.out.println("Error reading config file.");
            e.printStackTrace();
        }
    }

    //Access the properties from the file
    public String getAppiumServerUrl() {
        return appiumServerUrl;
    }
    public String getDeviceName(){
        return deviceName;
    }
    public String getPlatformName() {
        return platformName;
    }
    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAppPath() {
        return appPath;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getAppActivity(){
        return appActivity;
    }

    public String getUdid(){
        return udid;
    }

    public String getAutomationName(){
        return automatioName;
    }

}
