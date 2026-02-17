package demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;

import demo.wrappers.Wrappers;

public class TestCases {

    ChromeDriver driver;
    Wrappers wrappers;

    @BeforeTest
    public void startBrowser() {

        System.setProperty("java.util.logging.config.file", "logging.properties");

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);

        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(
                ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
                "build/chromedriver.log");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wrappers = new Wrappers(driver);
    }

    // Test Case 1 - Washing Machine rating check
    @Test
    public void testCase01() {

        System.out.println("TestCase01 Start");

        wrappers.openFlipkart();
        wrappers.searchProduct("Washing Machine");
        wrappers.sortByPopularity();
        wrappers.printRatingLessThanFour();
    }

    // Test Case 2 - iPhone discount check
    @Test
    public void testCase02() {

        System.out.println("TestCase02 Start");

        wrappers.openFlipkart();
        wrappers.searchProduct("iPhone");
        wrappers.printIphoneDiscount();
    }

    // Test Case 3 - Coffee Mug review check
    @Test
    public void testCase03() {

        System.out.println("TestCase03 Start");

        wrappers.openFlipkart();
        wrappers.searchProduct("Coffee Mug");
        wrappers.clickFourStarFilter();
        wrappers.printMugReviewsAndImages();
    }

    @AfterTest
    public void endTest() {

        driver.close();
        driver.quit();
    }
}
