# About Project
_More details about project is in Assignment Word file

## How to run

- Clone repo from the github link
- gitHub link :- **https://github.com/Akash-Kumar-Verma/Flipkart-Automation**
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

![Screenshot (34)](https://user-images.githubusercontent.com/55339504/215079065-41baa625-5895-4a9f-9142-8608f7934c06.png)


#### Jenkins Final

![Screenshot (38)](https://user-images.githubusercontent.com/55339504/215079118-b5613d74-b7b9-4cad-bbb7-589f0c90d399.png)


## Run from Batch File
- run RunProject.bat
- It will automatically run all tests


