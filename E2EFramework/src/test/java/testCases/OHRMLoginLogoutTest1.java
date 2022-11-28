package testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//import commonLibraries.AssertLibraries;
import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;
import resources.Base;

public class OHRMLoginLogoutTest1 extends Base
{
	
	public static Logger log = LogManager.getLogger(OHRMLoginLogoutTest1.class.getName());
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	@BeforeClass
	public void launchOrangeHRM() throws IOException
	{
		//log.debug("Initializing Driver");
		driver=initializeDriver();
		//log.debug("Driver initialization successful");
		driver.get(getURLOrangeHRM());
		//driver.get(getURLOrangeHRM());
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
	}
	
	@Test
	public void loginLogoutTest() {
		boolean isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFailed: OrangeHRM failed to launch |");
		System.out.println("StepPass: OrangeHRM launched successfully");
		log.info("StepPass: OrangeHRM launched successfully");
		lp.getTxtBoxUsername().sendKeys("admin");
		lp.getTxtBoxPassword().sendKeys("admin123");
		lp.getBtnLogin().click();
		
		boolean isOnHome = hp.getTxtPIMHeader().isDisplayed();
		Assert.assertTrue(isOnHome, "StepFail: Login unsuccessful |");
		//AssertLibraries.assertTrue(isOnHome, "StepFail: Login unsuccessful |");
		System.out.println("StepPass: Login successfull, currently on homepage");
		
		String loggedInUser = hp.getTxtLoggedInUser().getText();
		System.out.println("loggedInUser: " + loggedInUser);
		
		hp.getTxtLoggedInUser().click();
		hp.getLnkLogout().click();
		
		isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFailed: Not on login page after logout |");
		log.error("StepFailed: Not on login page after logout");
		System.out.println("StepPass: Currently on login page after logout");
	}
	
	@AfterClass
	public void closeOrangeHRM() {
		driver.quit();
	}

}
