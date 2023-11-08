package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCouponCode(String couponCode) {
        driver.findElement(By.id("coupon_code")).sendKeys(couponCode);
    }

    public void clickApplyCouponButton() {
        driver.findElement(By.cssSelector("button[name='apply_coupon']")).click();
    }

    public String getDiscountText() {
        return driver.findElement(By.cssSelector(".cart-discount")).getText();
    }

    public double getProductPrice(String productName) {
        String priceText = driver.findElement(By.xpath("//a[text()='" + productName + "']/following-sibling::span")).getText();
        // You should parse the price text and convert it to a double for calculations.
        // For example, remove currency symbols, commas, and convert to a double.
        return Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
    }

    // You can add more methods here as needed.
}
