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
        System.out.println("WAIT INITIALIZED");
    }

    // Navigate to Flipkart
    public void openFlipkart() {
        System.out.println("Navigate flipkart");
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

    // Search product
    public void searchProduct(String product) {
        try {

            System.out.println("TypeElement " + product);

            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.name("q")));

            searchBox.clear();
            searchBox.sendKeys(product);
            searchBox.sendKeys(Keys.ENTER);

        } catch (Exception e) {
            System.out.println("TypeElement FAILED");
        }
    }

    // Sort results
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

    // Rating extraction
    public void printRatingLessThanFour() {
        try {

            List<WebElement> ratings = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//div[contains(@class,'_3LWZlK')]")));

            int count = 0;

            for (WebElement r : ratings) {

                String ratingText = r.getText();
                System.out.println("GetElementText " + ratingText);

                if (ratingText.startsWith("4")
                        || ratingText.startsWith("3")
                        || ratingText.startsWith("2")
                        || ratingText.startsWith("1")) {
                    count++;
                }
            }

            System.out.println("Rating count <=4 " + count);

        } catch (Exception e) {
            System.out.println("Rating extraction failed");
        }
    }

    // Discount extraction
    public void printIphoneDiscount() {

        try {

            // WAIT FOR RESULTS TO LOAD
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'% off')]")));

            List<WebElement> discounts = driver.findElements(
                    By.xpath("//div[contains(text(),'% off')]"));

            System.out.println("Discount elements found = " + discounts.size());

            for (WebElement d : discounts) {

                
                String discountText = d.getText();

                
                System.out.println("GetElementText -> " + discountText);

                if (discountText.contains("% off")) {

                    int discountValue = Integer.parseInt(
                            discountText.replaceAll("[^0-9]", ""));

                    if (discountValue > 17) {

                        WebElement parent = d.findElement(By.xpath("./../../.."));

                        String title = parent.findElement(
                                By.xpath(".//div[contains(@class,'_4rR01T')]")).getText();

                        System.out.println("Product -> " + title);
                        System.out.println("Discount -> " + discountText);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Discount extraction failed");
        }
    }

    // Review extraction
    public void printMugReviewsAndImages() {

        try {

            List<WebElement> reviews = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(
                            By.xpath("//span[contains(text(),'Ratings')]")));

            List<WebElement> images = driver.findElements(
                    By.xpath("//img[contains(@class,'_396cs4')]"));

            for (int i = 0; i < Math.min(5, reviews.size()); i++) {

                String review = reviews.get(i).getText();
                String img = images.get(i).getAttribute("src");

                System.out.println("GetElementText " + review);
                System.out.println("ImageURL " + img);
            }

        } catch (Exception e) {
            System.out.println("Review extraction failed");
        }
    }

    // Click rating filter
    public void clickFourStarFilter() {

        try {

            WebElement filter = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[contains(text(),'4') and contains(text(),'above')]")));

            filter.click();
            System.out.println("Clicked 4 star filter");

        } catch (Exception e) {
            System.out.println("Filter click failed");
        }
    }
}
