package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Register {
    private final WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public Register inputFirstName(String name) {
        sendElementKeys("firstname", name);
        return this;
    }

    public Register inputLastName(String name) {
        sendElementKeys("lastname", name);
        return this;
    }

    public Register inputEmail(String email) {
        sendElementKeys("email", email);
        return this;
    }

    public Register inputPassword(String password) {
        sendElementKeys("password", password);
        return this;
    }

    public Register inputConfirmation(String confirm) {
        sendElementKeys("confirmation", confirm);
        return this;
    }

    public WebElement findElement(String id) {
        return driver.findElement(By.cssSelector("input[name=" + id + "]"));
    }

    public void sendElementKeys(String id, String input) {
        findElement(id).sendKeys(input);
    }
}
