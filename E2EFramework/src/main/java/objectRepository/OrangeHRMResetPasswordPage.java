package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMResetPasswordPage {
	
	WebDriver driver;
	//locator objects
	
	//old way
	
	//private By txtResetPassword = By.xpath("//h6[text()='Reset Password']");
	//private By txtBoxUsername = By.name("username");
	//private By btnResetPassword = By.xpath("//button[normalize-space()='Reset Password']");
	//private By txtLinkSentMessage = By.xpath("//h6[normalize-space()='Reset Password link sent successfully']");
	
	//new way
	//@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	//private WebElement txtResetPasswordHeading;
	
    //@FindBy(xpath="//h6[text()='Dashboard']")
    //private WebElement txtResetPasswordHeading;
    
    @FindBy(xpath="//h6[normalize-space()='Dashboard']")
	private WebElement txtResetPasswordHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(xpath="//button[text()=' Reset Password ']")
	private WebElement btnResetPassword;
	
	@FindBy(xpath="//h6[contains(normalize-space(),'successfully')]")
	private WebElement txtSuccessHeading;
	
	public OrangeHRMResetPasswordPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getTxtResetPasswordHeading() {
		return txtResetPasswordHeading;
	}
	public WebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}
	public WebElement getBtnResetPassword() {
		return btnResetPassword;
	}
	public WebElement getTxtSuccessHeading() {
		return txtSuccessHeading;
	}
	


}
