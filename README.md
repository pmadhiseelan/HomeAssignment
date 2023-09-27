**Requirements:**

appium version : 1.22.3

java version "11.0.20" 2023-07-18 LTS

node version : v20.7.0

**Mobile/Device Requirement:**

Real Device: Pixel 5a

Android Version: 13

**App Version Details:**

The Score App’s apk file was downloaded from ‘https://apkpure.com/‘ and has been placed in project’s root folder.

File Name: theScore_Sports_News_Scores_23.12.0_Apkpure.apk

**Framework Details:**

- Implemented Page Object Model (POM)
- WebElements and their corresponding methods and actions have been encapsulated within the Pages class.
- Mobile Capabilities are Managed and centralized in the Base Class
- Test cases have been defined within the 'LeaguesPageTest' class.
- Reusable Methods are Located in the TestUtils file
- Project configuration Details are read from the Config Properties file
- Designed the framework to run from the real mobile device (Pixel 5a). To run on a different Android device, 
Update the appropriate device capabilities in Config.properties file.

**Running the Tests:**

To run the test you need to execute the following command from inside the project directory.

Run the ‘Appium’ server from Desktop before running the following command.

mvn clean install

Or

mvn run
