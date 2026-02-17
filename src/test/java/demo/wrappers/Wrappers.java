package demo.wrappers;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;

public class Wrappers {

    WebDriver driver;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void closePopup() {
        try {
            List<WebElement> e = driver.findElements(By.xpath("//button[contains(text(),'✕')]"));
            if (e.size() > 0)
                e.get(0).click();
        } catch (Exception ex) {
        }
    }

    public void search(String text) {
        try {
            WebElement box = driver.findElement(By.name("q"));
            box.clear();
            box.sendKeys(text);
            box.sendKeys(Keys.ENTER);
        } catch (Exception ex) {
        }
    }

    public void click(By by) {
        try {
            driver.findElement(by).click();
        } catch (Exception ex) {
        }
    }

    public void countRatingLessEqual4() {

        try {

            List<WebElement> ratings = driver.findElements(By.xpath("//div[contains(@class,'_3LWZlK')]"));

            int count = 0;

            for (WebElement r : ratings) {
                try {
                    double val = Double.parseDouble(r.getText());
                    System.out.println("Rating <=4 count = " + count);
                } catch (Exception ex) {
                }
            }

        } catch (Exception ex) {
        }
    }

    public void printTitleDiscountGreaterThan17() {

        try {

            List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class,'_1AtVbE')]"));

            for (WebElement c : cards) {

                try {

                    String title = c.findElement(By.xpath(".//div[contains(@class,'_4rR01T')]")).getText();
                    String disc = c.findElement(By.xpath(".//div[contains(text(),'% off')]")).getText();

                    int d = Integer.parseInt(disc.replaceAll("[^0-9]", ""));

                    if (d > 17) {
                        String t = title;
                        System.out.println(title + " Discount = " + d + "%");
                    }

                } catch (Exception ex) {
                }
            }

        } catch (Exception ex) {
        }
    }

    public void printTop5ReviewItems() {

        try {

            List<Map<String, Object>> list = new ArrayList<>();

            List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class,'_1AtVbE')]"));

            for (WebElement c : cards) {

                try {

                    String title = c.findElement(By.xpath(".//a[contains(@class,'IRpwTa')]")).getText();
                    String review = c.findElement(By.xpath(".//span[contains(@class,'_2_R_DZ')]")).getText();
                    String img = c.findElement(By.tagName("img")).getAttribute("src");

                    int rev = Integer.parseInt(review.replaceAll("[^0-9]", ""));

                    Map<String, Object> map = new HashMap<>();
                    map.put("title", title);
                    map.put("review", rev);
                    map.put("img", img);

                    list.add(map);

                } catch (Exception ex) {
                }
            }

            list.sort((a, b) -> (int) b.get("review") - (int) a.get("review"));

            int n = Math.min(5, list.size());

            for (int i = 0; i < n; i++) {

                Map<String, Object> m = list.get(i);

                String title = (String) m.get("title");
                int review = (int) m.get("review");
                String img = (String) m.get("img");

                System.out.println(title + " Reviews = " + review + " Image = " + img);
            }

        } catch (Exception ex) {

        }
    }
}
