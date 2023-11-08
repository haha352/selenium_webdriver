package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobileLink() {
        By mobileLinkLocator = By.linkText("Mobile");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileLinkLocator));
        driver.findElement(mobileLinkLocator).click();
    }

    public void clickAddToCartButton(String productName) {
        driver.findElement(By.xpath("//h2[text()='" + productName + "']/following-sibling::div/button")).click();
    }

    // You can add more methods here as needed.
}
