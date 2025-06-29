package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/test/java/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");


        // result = testConditions ? value1 : value2
        // Here if the testConditions is true then it will return value1 or else it will return value2
        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else {
                System.setProperty("webdriver.chome.driver", System.getProperty("user.dir") + "//src/test/java/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
