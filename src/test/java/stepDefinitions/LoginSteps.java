package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.ExcelReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

public class LoginSteps {
    WebDriver driver=BaseClass.getDriver();
    LoginPage lp=new LoginPage(driver);
    List<HashMap<String, String>> datamap; //Data driven
 

    @Given("enters username {string} and password {string}")
    public void enters_username_and_password(String username, String password) {
      
    	BaseClass.getLogger().info("Entering email and password.. ");
       	lp.setEmail(username);
        lp.setPassword(password);
    }

    @When("clicks the Login button")
    public void clicks_the_login_button() {
          	 lp.clickLogin();
         BaseClass.getLogger().info("clicked on login button...");
    }

    @Then("the user should be redirected to the Products page")
    public void redirected_to_products_page() {
    	//driver=BaseClass.getDriver();
       // String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User not redirected to Products page!", lp.getProducePageURL().contains("inventory"));
      
    }

    @Then("an error message should be displayed as {string}")
    public void error_message_displayed(String expectedMessage) {
        String actualMessage = lp.getErrorMsgTxt();
        Assert.assertEquals(expectedMessage, actualMessage);
        
    }
    
    //*******   Data Driven test **************
    @Given("the user passing email and password with excel row {string}")
    public void check_user_navigates_to_product_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=ExcelReader.data(System.getProperty("user.dir")+"\\testData\\SauceLabDemoTestData-Initial.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String exp_res= datamap.get(index).get("res");

        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);

        lp.clickLogin();
        
        
        
        try
        {
        	
            boolean targetpage=lp.getProducePageURL().contains("inventory");
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                   // MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                   // myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("LockedUser"))
            {
                if(targetpage==true)
                {
               //     macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
    
    @Then("verify the user should be redirected to the product Page as per results with excel row {string}")
    public void verify_the_user_should_be_redirected_to_the_product_Page_as_per_results_with_excel_row(String rows)
    {
    	datamap=ExcelReader.data(System.getProperty("user.dir")+"\\testData\\SauceLabDemoTestData-Initial.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
       
        String exp_res= datamap.get(index).get("res");

       
        
        
        
        try
        {
        	
            boolean targetpage=lp.getProducePageURL().contains("inventory");
            System.out.println("target page: "+ targetpage);
            if(exp_res.equals("Valid"))
            {
                if(targetpage==true)
                {
                   // MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver());
                   // myaccpage.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }

            if(exp_res.equals("LockedUser"))
            {
                if(targetpage==true)
                {
               //     macc.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
      }
    
}
