package com.akbar.stepdefinitions;

import com.akbar.pageobjects.LandingPage;
import com.akbar.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingpageTest {

    WebDriver driver;
    String landingpage_prodname;
    TestContextSetup testContext;
    LandingPage landingPage;

    public LandingpageTest(TestContextSetup testContext) {
        this.testContext = testContext;
        this.landingPage = testContext.pageObjectManager.getLandingPage();
    }

    @Given("User is on GreenKart home page")
    public void user_is_on_green_kart_home_page() {
        Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
    }

    @When("^User searched with short name (.+) and extracted actual name of product$")
    public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
        landingPage.searchProduct(shortname);
        Thread.sleep(1000);
        testContext.landingpage_prodname = landingPage.getProductName().split("-")[0].trim();
    }

    @When("Added {string} items of the selected product to cart")
    public void added_items_of_the_selected_product_to_cart(String quantity) {
        landingPage.addToCart(Integer.parseInt(quantity));
    }
}
