package stepDefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.QAClickLandingPage;
import objectRepository.QAClickLoginPage;
//import pacematic.QAClickAppTests.QAClickLoginDDTTest;
import resources.Base;

public class QAClickStepDefinition extends Base
{
    public static Logger log=LogManager.getLogger(QAClickStepDefinition.class.getName());
	
	public WebDriver driver;
	QAClickLandingPage QAlap;
	QAClickLoginPage QAlop;
	Properties prop;
	String username;
	String password;
	
	 @Given("^Launch QA Click application$")
	    public void launch_qa_click_application() throws Throwable 
	    {
		    driver=initializeDriver();
			
			driver.get(getURLQAClick());
		
			
			QAlap=new QAClickLandingPage(driver);
			QAlop=new QAClickLoginPage(driver);
			
			boolean isOnLanding=QAlap.getHeadingfeaturedCourses().isDisplayed();
			Assert.assertTrue(isOnLanding, "StepFail: Not onlanding page");
			log.info("StepPass: Currently on landing page");
	       
	    }
	 
	  @And("^Click on Login to land on sign in page$")
	    public void click_on_login_to_land_on_sign_in_page() throws Throwable 
	    {
	    	
		  if(QAlap.getBtnNoThanks()!=null)
			{
				log.info("StepPass: pop os present");
				QAlap.getBtnNoThanks().click();
			}
			else
			{
				log.warn("No thanks popup not visible");
			}
			
			QAlap.getBtnLogin().click();
			boolean isOnLogin = QAlop.getHeadingLogin().isDisplayed();
			Assert.assertTrue(isOnLogin,"StepFail: Not on Login");
			log.info("Currently on login page");
	        
	    }


	    @When("^User tries to login with invalid username as (.+) and password as (.+)$")
	    public void user_tries_to_login_with_invalid_username_as_and_password_as(String username, String password) throws Throwable
	    {
	    	QAlop.getTxtUserEmail().sendKeys(username);
			QAlop.getTxtUserPassword().sendKeys(password);
			QAlop.getBtnLogin().click();
	        
	    }
	   

	    @Then("^login is unsuccessful$")
	    public void login_is_unsuccessful() throws Throwable
	    {
	    	
	    	boolean isOnLogin=QAlop.getHeadingLogin().isDisplayed();
			Assert.assertTrue(isOnLogin, "StepFail: login succesful with invalid credential");
			log.info("Steppass: Logi unsuccesful using invalid credential");
	        
	    }

	  
	    @And("^Close browser$")
	    public void close_browser() throws Throwable
	    {
	    	
	    	driver.quit();
	       
	    }

}
