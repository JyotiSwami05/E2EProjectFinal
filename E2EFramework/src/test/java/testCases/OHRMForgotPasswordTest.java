package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objectRepository.OrangeHRMLoginPage;
import objectRepository.OrangeHRMResetPasswordPage;
import resources.Base;

public class OHRMForgotPasswordTest extends Base
{
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMResetPasswordPage rp;
	
	@BeforeClass
	public void launchOrangeHRM() throws IOException {
		driver = initializeDriver();
		driver.get(getURLOrangeHRM());
		
		
		
		lp = new OrangeHRMLoginPage(driver);
		rp = new OrangeHRMResetPasswordPage(driver);
	}
	
	@Test
	public void ResetPasswordTest() throws InterruptedException, IOException {
		
		
				boolean isOnLogin = lp.getTxtLoginHeading().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFailed: OrangeHRM failed to launch |");
		System.out.println("StepPass: OrangeHRM launched successfully");
		
		lp.getTxtBoxUsername().sendKeys(getUsername());
		lp.getTxtBoxPassword().sendKeys("admin321");
		lp.getBtnLogin().click();
		
		boolean isErrorDisplayed = lp.getMsgInvalidCred().isDisplayed();
		Assert.assertTrue(isErrorDisplayed,"StepFailed: Error message not displayed |");
		System.out.println("StepPass: Error message displayed successfully on login with invalid credentials");
		
		lp.getLnkForgotPassword().click();
		
		boolean isOnResetPassPage = rp.getTxtResetPasswordHeading().isDisplayed();
	
		Assert.assertTrue(isOnResetPassPage,"StepFail: Not on reset password page |");
		System.out.println("StepPass: Currently on reset password page");
		rp.getTxtBoxUsername().sendKeys(getUsername());
		rp.getBtnResetPassword().click();
		boolean isSuccessDisplayed = rp.getTxtSuccessHeading().isDisplayed();
		Assert.assertTrue(isSuccessDisplayed,"StepFail: Reset request failed to send |");
		System.out.println("StepPass: Reset request sent successfully");
	}
	
	@AfterClass
	public void closeOrangeHRM() throws IOException {
		driver.quit();
	}

}
