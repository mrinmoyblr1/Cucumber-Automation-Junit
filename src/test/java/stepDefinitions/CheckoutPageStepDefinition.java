package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.checkoutPage();
    }

    @Then("Verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }

    @Then("^User proceeds to Checkout and validate the (.+) items in the checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_the_checkout_page(String name) throws InterruptedException {
        checkoutPage.getCheckoutItems();
        Thread.sleep(5000);
    }
}
