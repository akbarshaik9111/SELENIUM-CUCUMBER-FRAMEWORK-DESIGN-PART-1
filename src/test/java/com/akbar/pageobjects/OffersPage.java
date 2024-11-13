package com.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@id='search-field']");
    private By prodName = By.xpath("//table//td[1]");

    public void searchProduct(String shortname) {
        driver.findElement(search).sendKeys(shortname);
    }

    public String getProduct() {
        return driver.findElement(prodName).getText();
    }
}
