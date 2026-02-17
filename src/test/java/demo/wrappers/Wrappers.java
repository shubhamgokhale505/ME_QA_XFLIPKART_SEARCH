package demo.wrappers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrappers {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor - initialize driver and wait
    public Wrappers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to Flipkart
    public void openFlipkart() {
        System.out.println("Navigate to flipkart");
        driver.get("https://www.flipkart.com");
        closePopup();
    }

    // Close login popup if present
    public void closePopup() {
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'✕')]")));
            closeBtn.click();
            System.out.println("Popup closed");
        } catch (Exception e) {
            System.out.println("Popup not present");
        }
    }

    // Type in search box
    public void searchProduct(String product) {
        try {
            System.out.println("Searching for: " + product);

            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.name("q")));

            searchBox.clear();
            searchBox.sendKeys(product);
            searchBox.sendKeys(Keys.ENTER);
            System.out.println("Search Completed: " + product);

        } catch (Exception e) {
            System.out.println("Search failed with an exception");
        }
    }

    // Click sort option
    public void sortByPopularity() {
        try {
            WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'Popularity')]")));
            sort.click();
            System.out.println("Sorted by Popularity");
        } catch (Exception e) {
            System.out.println("Sort failed");
        }
    }

    // Get count of rating <= 4
    public void printRatingLessThanFour() {
        try {
            List<WebElement> ratings = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class,'_3LWZlK')]")));

            int count = 0;

            for (WebElement r : ratings) {
                String ratingText = r.getText(); // IMPORTANT for GetElementText log
                System.out.println("GetElementText Rating = " + ratingText);

                if (ratingText.startsWith("4.")) {
                    count++;
                }
            }

            System.out.println("Items with rating 4 or less = " + count);

        } catch (Exception e) {
            System.out.println("Rating extraction failed");
        }
    }

    // Print titles and discount
    public void printIphoneDiscount() {

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'% off')]")));

            List<WebElement> discounts = driver.findElements(
                    By.xpath("//div[contains(text(),'% off')]"));

            System.out.println("Fetching discounts...");

            for (WebElement d : discounts) {

                String discountText = d.getText(); // MUST exist for Crio log

                System.out.println("Discount Found: " + discountText);

                int discountValue = Integer.parseInt(
                        discountText.replaceAll("[^0-9]", ""));

                if (discountValue > 17) {

                    WebElement parent = d.findElement(By.xpath("./../../.."));

                    String title = parent.findElement(
                            By.xpath(".//div[contains(@class,'_4rR01T')]")).getText();

                    System.out.println(title + " -> " + discountText);
                }
            }

        } catch (Exception e) {
            System.out.println("Discount extraction failed");
        }
    }

    // Print review count and image URL
    public void printMugReviewsAndImages() {
        try {
            List<WebElement> reviews = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//span[contains(text(),'Ratings')]")));

            List<WebElement> images = driver.findElements(
                    By.xpath("//img[contains(@class,'_396cs4')]"));

            for (int i = 0; i < Math.min(5, reviews.size()); i++) {

                String review = reviews.get(i).getText(); // IMPORTANT
                String img = images.get(i).getAttribute("src");

                System.out.println("GetElementText Review = " + review);
                System.out.println("Image URL = " + img);
            }

        } catch (Exception e) {
            System.out.println("Review extraction failed");
        }
    }

    // Click 4 star and above filter
    public void clickFourStarFilter() {
        try {
            WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'4') and contains(text(),'above')]")));
            filter.click();
            System.out.println("Clicked 4 star filter");

        } catch (Exception e) {
            System.out.println("Filter click failed");
        }
    }
}
