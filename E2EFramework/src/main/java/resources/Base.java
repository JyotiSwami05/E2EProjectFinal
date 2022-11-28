package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Base 
{
	public WebDriver driver;
	//public ExcelHandler excelhandler;
	private String username;
	private String password;
	private String URLOrangeHRM;
	private String URLQAClick;
	private String browser;
	//private int implicitWait;
	private String basePath = System.getProperty("user.dir");
	
	public WebDriver initializeDriver() throws IOException {
		String path = basePath+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		URLOrangeHRM=prop.getProperty("URLOrangeHRM");
		//URLOrangeHRM = prop.getProperty("URLOrangeHRM");
		URLQAClick = prop.getProperty("URLQAClick");
		browser = prop.getProperty("browser");
		//implicitWait = Integer.parseInt(prop.getProperty("timeOut"));
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", basePath +"\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", basePath + "\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", basePath + "\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			Assert.assertTrue(false,"unsupported browser, please enter chrome, firefox or edge");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	

	public String getURLOrangeHRM() {
		return URLOrangeHRM;
	}

	public String getURLQAClick() {
		return URLQAClick;
	}

	public String getBrowser() {
		return browser;
	}
	
	public String getBasePath() {
		return basePath;
	}

	public String getScreenshot(WebDriver driver, String testMethodName) throws IOException 
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = basePath+"\\screenshots\\screenshot"+testMethodName+".png";
		FileUtils.copyFile(screenshotFile, new File(path));
		return path;
	}
	

}
