package com.akbar.stepdefinitions;

import com.akbar.pageobjects.CheckoutPage;
import com.akbar.pageobjects.LandingPage;
import com.akbar.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CheckoutPageTest {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageTest(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String shortname) {
        checkoutPage.clickOnCartBagBtn();
        checkoutPage.clickOnChkOutBtn();
        String act_prodname = checkoutPage.getProductName().split("-")[0].trim();
        Assert.assertTrue(act_prodname.contains("Tom"));
    }

    @Then("Verify user has ability to enter promocode and place the order")
    public void verify_user_has_ability_to_enter_promocode_and_place_the_order() {
        Assert.assertTrue(checkoutPage.verifyyPromoBtn());
        Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
    }
}
