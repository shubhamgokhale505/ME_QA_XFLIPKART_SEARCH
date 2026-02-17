package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;
    Wrappers wrappers;

    @BeforeTest
    public void startBrowser() {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wrappers = new Wrappers(driver);
    }

    @Test
    public void testCase01() {
        System.out.println("TestCase01 Start");

        wrappers.openURL("https://www.flipkart.com");
        wrappers.closePopup();
        wrappers.search("Washing Machine");
        wrappers.click(By.xpath("//div[text()='Popularity']"));
        wrappers.countRatingLessEqual4();

        
    }

    @Test
    public void testCase02() {
        System.out.println("TestCase02 Start");

        wrappers.openURL("https://www.flipkart.com");
        wrappers.closePopup();
        wrappers.search("iPhone");
        wrappers.printTitleDiscountGreaterThan17();
        
    }


    @Test
    public void testCase03() {
        System.out.println("TestCase03 Start");

        wrappers.openURL("https://www.flipkart.com");
        wrappers.closePopup();
        wrappers.search("Coffee Mug");
        wrappers.click(By.xpath("//div[text()='4★ & above']"));
        wrappers.printTop5ReviewItems();
        
    }

    @AfterTest
    public void endTest() {
        driver.close();
        driver.quit();

    }
}