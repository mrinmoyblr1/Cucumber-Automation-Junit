package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for {} shortname in the offer page")
    public void user_searched_for_same_shortname_in_the_offer_page_to_check_if_product_is_exist(String shortName) throws Throwable {
        switchToOffersPage();
        OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();
        offersPage.searchItem(shortName);
        offerPageProductName = offersPage.getProductName();
        System.out.println("The Product Name is extracted from Offer Page: " + offerPageProductName);
        Thread.sleep(5000);
    }

    public void switchToOffersPage() throws Throwable {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();  // Here we are eliminating object creation
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
    }

    @And("^validate product name in offers page matches with Landing Page$")
    public void validate_product_name_in_offers_page_matches_with_landing_page() throws Throwable {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
