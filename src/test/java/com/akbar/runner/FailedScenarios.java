package com.akbar.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@target\\failed_scenarios.txt",
        glue = "com.akbar.stepdefinitions",
        monochrome = true,
        dryRun = false,
        tags = "@PlaceOrder or @OffersPage",
        plugin = {"pretty", "html:target\\cucumber.html",
                "json:target\\cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class FailedScenarios extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
