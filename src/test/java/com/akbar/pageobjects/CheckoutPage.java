package com.akbar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartBag = By.cssSelector("img[alt='Cart']");
    By checkOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    By promoBtn = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[text()='Place Order']");
    By prodname = By.cssSelector(".product-name");

    public void clickOnCartBagBtn() {
        driver.findElement(cartBag).click();
    }

    public void clickOnChkOutBtn() {
        driver.findElement(checkOutButton).click();
    }

    public void checkoutItems() {
        driver.findElement(cartBag).click();
        driver.findElement(checkOutButton).click();
    }

    public Boolean verifyyPromoBtn() {
        return driver.findElement(promoBtn).isDisplayed();
    }

    public Boolean	verifyPlaceOrderBtn() {
        return driver.findElement(placeOrder).isDisplayed();
    }

    public String getProductName() {
        return driver.findElement(prodname).getText();
    }
}
