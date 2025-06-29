package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("^User is on GreenCart landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
        System.out.println("Browser opened successfully.........");

    }

    @When("^User searched with shortname (.+) and extracted the actual name of the Product$")
    public void userSearchedWithShortnameAndExtractedTheActualNameOfTheProduct(String shortName) throws Throwable {

        landingPage.searchItem(shortName);
        Thread.sleep(5000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("The Product Name is extracted from Home Page: " + testContextSetup.landingPageProductName);
    }


    @When("Added {string} items of the selected product to cart")
    public void added_items_product(String quantity) throws InterruptedException {

        Thread.sleep(5000);
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
        Thread.sleep(5000);
    }
}
