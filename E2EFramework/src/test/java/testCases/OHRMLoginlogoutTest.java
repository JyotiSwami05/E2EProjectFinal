package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import objectRepository.OrangeHRMHomePage;
import objectRepository.OrangeHRMLoginPage;

public class OHRMLoginlogoutTest {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\MyFiles\\Chromedriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//File screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotfile, new File(".//screenshot/screen3.png"));
		
		
		boolean result=true;
		
		//passed driver as an argument in OrangeHRMLoginPage constructor
		OrangeHRMLoginPage lp =new OrangeHRMLoginPage(driver);
		//passed driver as an argument in OrangeHRMHomePage constructor
		OrangeHRMHomePage hp = new OrangeHRMHomePage(driver);
		
		
		Thread.sleep(3000);
		
		
		boolean isOnLoginPage = lp.getTxtLoginHeading().isDisplayed();
		//Assert.assertTrue(isOnLoginPage);
		if(isOnLoginPage==true)
		{
		System.out.println("StepPass: Currently on login page");
		}
		else
		{
		System.out.println("StepFail: Not on Login page");
		result=false;
		}
		
		if(result==true) 
		{
		//2.Enter username
			
		lp.getTxtBoxUsername().sendKeys("admin");
		//3.Enter password
		
		lp.getTxtBoxPassword().sendKeys("admin123");
		//4.Click on Login
		
		lp.getBtnLogin().click();
		
		//5.verify whether login is successful
		boolean isOnHomePage = hp.getTxtPIMHeader().isDisplayed();
		
		if(isOnHomePage==true) 
		{
		System.out.println("StepPass: Currently on home page");
		}
		else 
		{
		System.out.println("StepFail: Not on home page");
		result=false;
		}
		}
		
		if(result==true)
		{
		
			
		WebElement loggedInUserElement = hp.getTxtLoggedInUser();
		
		//6.Get name of User logged in
		
		String loggedInUser = loggedInUserElement.getText();
		System.out.println("loggedInUser: " + loggedInUser);
		
		//7.Logout and verify if it is successful
		
		loggedInUserElement.click();
		hp.getLnkLogout().click();
		
		isOnLoginPage = lp.getTxtLoginHeading().isDisplayed();
		
		if(isOnLoginPage==true)
		{
		System.out.println("StepPass: Currently on login page	after logout");
		}
		else
		{
		System.out.println("StepFail: Not on Login page after logout");
		result=false;
		}
		}
		//Close browser
		driver.quit();
	}

}
