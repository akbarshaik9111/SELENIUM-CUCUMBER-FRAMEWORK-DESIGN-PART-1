package com.akbar.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;

    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
        Properties props = new Properties();
        props.load(fis);
        String url = props.getProperty("url");
        String browser_props = props.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_props;

        if(driver == null) {
            if(browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else {
                System.out.println("Invalid Browser");
            }

            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        return driver;
    }
}
