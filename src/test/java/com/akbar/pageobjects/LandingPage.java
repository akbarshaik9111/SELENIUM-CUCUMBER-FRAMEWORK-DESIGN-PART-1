package com.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.xpath("//input[@type='search']");
    private By prodName = By.cssSelector(".product-name");
    private By topDealsLink = By.linkText("Top Deals");
    private By increment = By.cssSelector(".increment");
    private By addCartBtn = By.cssSelector(".product-action button");

    public void searchProduct(String shortname) {
        driver.findElement(search).sendKeys(shortname);
    }

    public String getProductName() {
        return driver.findElement(prodName).getText();
    }

    public void clickTopDealsLink() {
        driver.findElement(topDealsLink).click();
    }

    public String getLandingPageTitle() {
        return driver.getTitle();
    }

    public void addToCart(int quantity) {
        int i = quantity - 1;
        while(i > 0) {
            driver.findElement(increment).click();
            i--;
        }
        driver.findElement(addCartBtn).click();
    }
}
