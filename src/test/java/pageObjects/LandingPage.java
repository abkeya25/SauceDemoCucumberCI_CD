package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);
	}

	// Elements

	@FindBy(linkText = "Login")   
	WebElement linkLogin;

	
	
		
	// Action Methods
	
	public void clickLogin()   
	{
		linkLogin.click();
	}
	
	
	
	
}
