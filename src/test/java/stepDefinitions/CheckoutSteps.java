package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;

import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    WebDriver driver=BaseClass.getDriver();

    @Given("the user has products added to the cart")
    public void user_has_products_in_cart() {
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        try {
            // Wait for alert to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to alert
            Alert alert = driver.switchTo().alert();

            System.out.println("Alert text: " + alert.getText());

            // Click OK (accept)
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No JS alert appeared after login.");
        }*/
        driver.findElement(By.xpath("//button[contains(@id,'add-to-cart')]")).click();
    }

 
    @When("clicks on Checkout")
    public void clicks_checkout() {
        driver.findElement(By.id("checkout")).click();
    }

    @When("enters user information:")
    public void enters_user_information(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> userData = data.get(0);
        driver.findElement(By.id("first-name")).sendKeys(userData.get("First Name"));
        driver.findElement(By.id("last-name")).sendKeys(userData.get("Last Name"));
        driver.findElement(By.id("postal-code")).sendKeys(userData.get("Zip"));
    }

    @When("clicks Continue and Finish")
    public void clicks_continue_and_finish() {
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
    }

    @Then("a confirmation message {string} should be displayed")
    public void confirmation_message_displayed(String expectedMsg) {
        String actualMsg = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);
        driver.quit();
    }
}
