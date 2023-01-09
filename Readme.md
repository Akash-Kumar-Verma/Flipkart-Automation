# About Project
_More details about project is in Assignment Word file

## How to run

- Clone repo from the github link
- gitHub link :- **https://github.com**
- run RunAssignment.bat

## Main Parameters in Configuration.properties file
- headlessMode : true or false -> to run in head or headless mode
- To change browser - change the browser in config.properties

## Important Directory

- Jar File : ./Referenced Libraries/CustomLib.jar
- Drivers : ./Resources/drivers/
- Report File : ./report/AutomationExtentReport.html
- Log File : ./logs/
- Configuration File: ./Config.properties
- Screenshots Folder: ./FailedTestsScreenshots/
- Test Data File : ./Resources/testData/TestDataForFlipkart.xlsx


## How to run through jenkins

- download jenkins.war file
- run in cmd

```
java -jar jenkins.war --httpPort=8080
```

- setup jenkins

### Screenshots

#### Jenkins Setup

![Jenkins Setup](./ReadmeScreenshots/SettingUpJenkins.jpg)

#### Jenkins Final

![Jenkins Final](./ReadmeScreenshots/jenkins.jpg)

## Run from Batch File
- run RunProject.bat
- It will automatically run all tests

### Extra Screenshots

#### Logger Screenshot

![Logger Screenshot](./ReadmeScreenshots/LoggerScreenshot.png)

