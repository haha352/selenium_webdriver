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
import java.util.stream.Collectors;

@Test
public class TC01 {

    public static void verifyProductSort() {
        WebDriver driver = driverFactory.getDriver();

        try {
            driver.get("http://live.techpanda.org/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            WebElement mobileBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".level0")));
            mobileBtn.click();

            By sortSelector = By.cssSelector(".sort-by > select");
            WebElement sortDropdown = driver.findElement(sortSelector);
            sortDropdown.click();

            By sortNameOption = By.cssSelector(".sort-by > select > option:nth-child(2)");
            WebElement sortNameBtn = driver.findElement(sortNameOption);
            sortNameBtn.click();

            List<WebElement> productElements = driver.findElements(By.cssSelector(".product-name > a"));
            List<String> productNames = productElements.stream().map(WebElement::getText).collect(Collectors.toList());

            if (isSorted(productNames)) {
                System.out.println("The list is sorted!");
            } else {
                throw new AssertionError("The list is not sorted!");
            }

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static boolean isSorted(List<String> elements) {
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).compareTo(elements.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
