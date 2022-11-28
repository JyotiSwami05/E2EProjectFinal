package pacematic.QAClickAppTests;


//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;


//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepository.QAClickLandingPage;
import objectRepository.QAClickLoginPage;
import resources.Base;
import resources.Excelhandler;

public class QAClickLoginDDTTest extends Base
{
   
	public static Logger log=LogManager.getLogger( QAClickLoginDDTTest.class.getName());
	
	public WebDriver driver;
	QAClickLandingPage QAlap;
	QAClickLoginPage QAlop;
	Properties prop;
	String username;
	String password;
	
	 ArrayList<String> usernames = new ArrayList<>();
	 ArrayList<String> passwords = new ArrayList<>();
	//Initializing the driver by calling initializeDriver of Base class
	@BeforeMethod
	public void launchQAClickApp() throws IOException
	
	{
		driver=initializeDriver();
		//driver.get("http://www.qaclickacademy.com/");
		//driver.get(prop.getProperty("url1"));
		driver.get(getURLQAClick());
	
		
		QAlap=new QAClickLandingPage(driver);
		QAlop=new QAClickLoginPage(driver);
		
		boolean isOnLanding=QAlap.getHeadingfeaturedCourses().isDisplayed();
		Assert.assertTrue(isOnLanding, "StepFail: Not onlanding page");
		log.info("StepPass: Currently on landing page");
	
	}
	
	@Test(dataProvider="dataMethod")
	public void DDTLoginTest(String username, String password)
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
		
		QAlop.getTxtUserEmail().sendKeys(username);
		QAlop.getTxtUserPassword().sendKeys(password);
		QAlop.getBtnLogin().click();
		
		isOnLogin=QAlop.getHeadingLogin().isDisplayed();
		Assert.assertTrue(isOnLogin, "StepFail: login succesful with invalid credential");
		log.info("Steppass: Logi unsuccesful using invalid credential");
		
	}
	
	@AfterMethod
	public void closeOrangeHRM()
	{
		driver.quit();
	}
	
	@DataProvider
	public String[][] dataMethod() throws EncryptedDocumentException, IOException{
		Excelhandler handler = new Excelhandler();
		handler.handleExcel();
		int rows = handler.getUsernames().size();
		int columns = 2;
		String[][] data = new String[rows][columns];
		for(int i=0;i<=rows-1;i++) {
			data[i][0] = handler.getUsernames().get(i);
			data[i][1]= handler.getPasswords().get(i);
		}
		return data;
	}
	
	
}
