package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
//import pacematic.QAClickAppTests.QAClickLoginDDTTest;
import resources.Base;

public class OrangeHRMStepDefinition extends Base
{
	public static Logger log=LogManager.getLogger(OrangeHRMStepDefinition.class.getName());
	
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	 @Given("^User is on Login page$")
	    public void user_is_on_login_page() throws Throwable 
	    {
	       
		 driver=initializeDriver();
		 driver.get(getURLOrangeHRM());
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		
		
		
		
		boolean isOnLoginPage = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLoginPage,"StepFail: Not on Login page");
		log.info("StepPass: Currently on Login page");
		
	    }
	    
	    @When("^User clicks on login button by entering username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	    public void user_clicks_on_login_button_by_entering_username_as_something_and_password_as_something(String username, String password) throws Throwable {
	        
	    	lp.getTxtBoxUsername().sendKeys(username);
	    	lp.getTxtBoxPassword().sendKeys(password);
	    	lp.getBtnLogin().click();
	    	
	    		    	
	    }

	  
	    @Then("^Login Success is \"([^\"]*)\"$")
	    public void login_success_is_something(String strArg1) throws Throwable 
	    {
	       	    	
	         boolean isLoginSuccess;
	         
	    	if(strArg1.equals("true"))
	    	{
	    	isLoginSuccess=hp.getTxtPIMHeader().isDisplayed();//driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	    	Assert.assertTrue(isLoginSuccess,"StepFail: Login is unsuccessful");
	    	//Assert.assertTrue(isLoginSuccess,"StepFail: Login is unsuccessful" );
	    	log.info("StepPass: Login is successful");
		    	
	    	}
	    	else
	    	{
	    		
					try
					{
						isLoginSuccess=hp.getTxtPIMHeader().isDisplayed();//driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
					   } catch (Exception e)
					 {
						// TODO Auto-generated catch block
						isLoginSuccess=false;
						e.printStackTrace();
					}
						
					//Assert.assertTrue(isLoginSuccess, "StepFail: Login is successful with invalid credentila");
					Assert.assertFalse(isLoginSuccess,"StepFail: Login is successful with invalid credentila");
					log.info("StepPass: Login is unsuccessful with invalid credentila");
					
			
	    	}	
	    		
	    	}
	    	
	    

	    
	    
	   

	  
	    
	    @And("^Username display is \"([^\"]*)\"$")
	    public void username_display_is_something(String strArg1) throws Throwable 
	    {
	    	//System.out.println("Username is :" +isOnHomePage);
	    	String username;
	    	//Assert.assertEquals(strArg1,"true");
	    	if(strArg1.equals("true"))
	    	{
	    		
	    	
	    	    username=hp.getTxtLoggedInUser().getText();//.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).getText();
	    	   System.out.println("username is :"+username);
	    	
	    	   if(username.equals(""))
	    	   {
	    		  System.out.println("StepFail : Username not available");
	    	   }
	    	   else
	    	   {
	    		  System.out.println("StepPass : Username is available");
	    	   }
	    	}
	    	else
	    	{
	    		
					try {
						username=hp.getTxtLoggedInUser().getText();//driver.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).getText();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						username="";
						e.printStackTrace();
					}
					   System.out.println("username is :" +username);
					
					   if(username.equals(null)||username.equals(""))
					   {
						  System.out.println("StepPass : Username not available as user is to login with invalid credential");
					   }
					   else
					   {
						  System.out.println("Stepfail : Username is available");
					   }
				
	    	}
	    	
	       
	    }

	    @And("^Close Application$")
	    public void close_application() throws Throwable
	    {
	        //throw new PendingException();
	    	driver.quit();
	    }
	
}
