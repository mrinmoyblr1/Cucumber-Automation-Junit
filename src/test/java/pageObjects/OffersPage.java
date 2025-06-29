package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OffersPage {
    public WebDriver driver;
    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }
    private By search = By.xpath("//input[@id='search-field']");
    private By productName = By.cssSelector("tr td:nth-child(1)");  // this css is very important
    public void searchItem(String name) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
