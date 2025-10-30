package stepDefinitions;

import org.testng.AssertJUnit;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.AddToCartPage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartSteps {
    WebDriver driver=BaseClass.getDriver();;
    AddToCartPage ac;
    
    @Given("the user is logged into the SauceDemo site")
    public void user_is_logged_in() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("the user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        // Already handled in @Given, included for readability
    }

    @Given("adds product {string} to the cart")
    public void add_product_to_cart(String productName) {   	
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }

    @Then("the product should be visible in the cart")
    public void product_visible_in_cart() {
    	ac.clickOnShoppingCartLink();
        AssertJUnit.assertTrue(driver.findElement(By.className("cart_item")).isDisplayed());
        //driver.quit();
    }

    @Given("the product {string} is already added to the cart")
    public void product_already_in_cart(String productName) {
        user_is_logged_in();
        add_product_to_cart(productName);
    }

    @When("the user navigates to the cart")
    public void user_navigates_to_cart() {
        ac.clickOnCartItem();
       
    }

    @When("clicks Remove on that product")
    public void remove_product() {
        ac.clickOnremoveItemButton();
    }

    @Then("the product should be removed and the cart should be empty")
    public void cart_should_be_empty() {
        boolean isEmpty = driver.findElements(By.className("cart_item")).isEmpty();
        AssertJUnit.assertTrue(isEmpty);
        driver.quit();
    }
}
