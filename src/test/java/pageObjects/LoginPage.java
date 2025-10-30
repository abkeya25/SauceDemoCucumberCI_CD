package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import io.cucumber.java.en.Then;




public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "user-name")
	WebElement txtEmailAddress;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "login-button")
	WebElement btnLogin;

	@FindBy(css = "h3[data-test='error']")
	WebElement errorMsg;
	

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public String getErrorMsgTxt() {
		try {
			return (errorMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	
	public String getProducePageURL() {
		
			return (driver.getCurrentUrl());		

	}
	

}
