package bt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class TC06 {

    By acccountLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[2]/div[1]/a[1]");
    By login = By.cssSelector("body.cms-index-index.cms-home:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) header.page-header div.page-header-container div.skip-content.skip-active:nth-child(6) div.links ul:nth-child(1) li.last:nth-child(6) > a:nth-child(1)");
    By emailInput = By.cssSelector("#email");

    By myWishList = By.cssSelector("body.customer-account-index.customer-account:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-left-layout div.main div.col-left.sidebar.col-left-first:nth-child(1) div.block.block-account div.block-content ul:nth-child(1) li:nth-child(😎 > a:nth-child(1)");
    By passwordInput = By.cssSelector("#pass");
    By loginButton = By.cssSelector("#send2");

    By dropdownCountry = By.xpath("//select[@id='country']");

    By regionInput = By.cssSelector("#region");
    By posCodeInput = By.cssSelector("#postcode");
    By estimateButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/button[1]");
    By stateSelect = By.cssSelector("#region_id");
    String countrySelect = "United States";
    String stateProvice = "Georgia";
    int posCode = 73100;

    By buttonInput = By.cssSelector("body.wishlist-index-index.customer-account:nth-child(2) div.wrapper:nth-child(1) div.page:nth-child(2) div.main-container.col2-left-layout div.main div.col-main:nth-child(2) div.my-account div.my-wishlist div.fieldset table.clean-table.linearize-table:nth-child(2) tbody:nth-child(2) tr.first.last.odd td.wishlist-cell4.customer-wishlist-item-cart div.cart-cell:nth-child(1) > button.button.btn-cart");
    String email;
    String password;
    WebDriver driver;

    public TC06(WebDriver driver, String email, String password) {
        this.driver = driver;
        this.email = email;
        this.password = password;
    }

    public void action (){
        login();
        clickMyWishList();
        clickButtonInput();
        selectCountry();
        inputRegion();
        inputPosCode();
        clickEstimate();
    }

    public void login() {
        goToHomePage();
        clickAccountLink();
        clickLoginButton();
        inputEmail();
        inputPassword();
        driver.findElement(loginButton).click();
    }


    public void goToHomePage() {
        driver.get("http://live.techpanda.org/");
    }

    public void quit() {
        driver.quit();
    }

    public void clickAccountLink() {
        driver.findElement(acccountLink).click();
    }

    public void clickLoginButton(){
        driver.findElement(login).click();
    }

    public void inputEmail() {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void inputPassword() {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickMyWishList(){
        driver.findElement(myWishList).click();
    }

    public void clickButtonInput(){
        driver.findElement(buttonInput).click();
    }

    public void selectCountry(){
        WebElement dropdown = driver.findElement(dropdownCountry);
        Select selectOption = new Select(dropdown);
        selectOption.selectByVisibleText(countrySelect);
    }

    public void inputRegion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElement(stateSelect).isDisplayed());
        WebElement dropdownState = driver.findElement(stateSelect);
        Select selectOption = new Select(dropdownState);
        selectOption.selectByVisibleText(stateProvice);
    }

    public void inputPosCode(){
        driver.findElement(posCodeInput).sendKeys(String.valueOf(posCode));
    }

    public void clickEstimate(){
        driver.findElement(estimateButton).click();
    }


}
