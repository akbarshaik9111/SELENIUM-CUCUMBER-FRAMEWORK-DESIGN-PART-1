package com.akbar.stepdefinitions;

import com.akbar.utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void tearDown() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }

    @AfterStep
    public void getScreenshot(Scenario scenario) throws IOException {
        WebDriver driver = testContextSetup.testBase.webDriverManager();
        if(scenario.isFailed()) {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(source);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
