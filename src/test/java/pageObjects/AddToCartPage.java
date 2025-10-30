package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage
	{
	public AddToCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//@FindBy(xpath="//button[@aria-expanded='false']")
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']")
	WebElement lnkViewCart;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
	WebElement lblTotalPrice;  //$246.40
	
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btnCheckout;
	
	@FindBy(className="shopping_cart_link")
	WebElement shoppingCartLink;
	
	@FindBy(className="cart_item")
	WebElement cartItem;
	
	@FindBy(xpath="//button[text()='Remove']")
	WebElement removeItemButton;

	public void clickItemsToNavigateToCart()
	{
		btnItems.click();
	}
	
	public void clickViewCart()
	{
		lnkViewCart.click();
	}
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	public void clickOnCheckout()
	{
		btnCheckout.click();
	}
	
	public void clickOnShoppingCartLink()
	{
		shoppingCartLink.click();
	}
	
	public void clickOnCartItem()
	{
		cartItem.click();
	}
	
	public void clickOnremoveItemButton()
	{
		removeItemButton.click();
	}
	
	
	
}
