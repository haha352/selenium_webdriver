package bt;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class TC02 {

    public static void main(String[] args) {

        WebDriver driver = driverFactory.getDriver();
        try {
            driver.get("http://live.techpanda.org/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement mobileCategory = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".level0"))));
            mobileCategory.click();

            List<WebElement> productItems = driver.findElements(By.cssSelector(".products-grid > li"));

            WebElement selectedProduct = findProductByName(productItems, "Sony Xperia");

            if (selectedProduct != null) {
                String expectedPrice = selectedProduct.findElement(By.cssSelector("span.price")).getText();
                clickProductImage(selectedProduct);
                String actualPrice = driver.findElement(By.cssSelector(".product-shop * .regular-price > .price")).getText();

                if (expectedPrice.equals(actualPrice)) {
                    System.out.println("Price values match!");
                } else {
                    throw new AssertionError("Price values do not match!");
                }
            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static WebElement findProductByName(List<WebElement> productItems, String productName) {
        for (WebElement product : productItems) {
            WebElement productNameElement = product.findElement(By.cssSelector(".product-name"));
            if (productNameElement.getText().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private static void clickProductImage(WebElement product) {
        WebElement productImage = product.findElement(By.cssSelector(".product-image"));
        productImage.click();
    }
}
