package com.akbar.stepdefinitions;

import com.akbar.pageobjects.LandingPage;
import com.akbar.pageobjects.OffersPage;
import com.akbar.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OffersPageTest {

    String offerspage_prodname;
    TestContextSetup testContext;
    OffersPage offersPage;

    public OffersPageTest(TestContextSetup testContext) {
        this.testContext = testContext;
        this.offersPage = testContext.pageObjectManager.getOffersPage();
    }

    @Then("^User searched for (.+) short name in offers page$")
    public void user_searched_for_same_short_name_in_offers_page(String shortname) throws InterruptedException {
        switchToOffersPage();
        Thread.sleep(1000);
        offersPage.searchProduct(shortname);
        Thread.sleep(1000);
        offerspage_prodname = offersPage.getProduct();
    }

    @Then("Validates the product name in offers page matches in landing page")
    public void validates_the_product_name_in_offers_page_matches_in_landing_page() {
        Assert.assertEquals(offerspage_prodname, testContext.landingpage_prodname);
    }

    public void switchToOffersPage() {
        LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
        landingPage.clickTopDealsLink();
        testContext.genericUtils.switchToChildWindow();
    }
}
