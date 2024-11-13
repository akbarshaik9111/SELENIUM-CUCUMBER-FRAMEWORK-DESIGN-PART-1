package com.akbar.utils;

import com.akbar.pageobjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public String landingpage_prodname;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }
}
