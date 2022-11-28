package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLandingPage {
	
	WebDriver driver;
	@FindBy(xpath="//h2[text()='Featured Courses']")
	private WebElement headingfeaturedCourses;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	private WebElement btnNoThanks;
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement btnLogin;
	
	public QAClickLandingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeadingfeaturedCourses()
	{
		return headingfeaturedCourses;
	}

	public WebElement getBtnNoThanks()
	{
		WebElement element = null;
		try {
			element =  btnNoThanks;
		} catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}

	public WebElement getBtnLogin() 
	{
		return btnLogin;
	}

}
