package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
	WebDriver driver;
	//define page object/elements as private
	
	//old way in page object model
	//private By txtLoginHeading = By.xpath("//h5[text()='Login']");
	//private By txtBoxUsername = By.name("username");
	//private By txtBoxPassword = By.name("password");
	//private By btnLogin = By.xpath("//button[text()=' Login ']");
	//private By txtLoginError = By.xpath("//p[text()='Invalid credentials']");
	//private By lnkForgotPassword = By.xpath("//p[text()='Forgot your password? ']");
	
	@FindBy(xpath="//h5[text()='Login']")
	private WebElement txtLoginHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(name="password")
	private WebElement txtBoxPassword;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement lnkForgotPassword;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement msgInvalidCred;
	
	public OrangeHRMLoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTxtLoginHeading() {
		return txtLoginHeading;
	}
	public WebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}
	public WebElement getTxtBoxPassword() {
		return txtBoxPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public WebElement getLnkForgotPassword() {
		return lnkForgotPassword;
	}
	public WebElement getMsgInvalidCred() {
		return msgInvalidCred;
	}
	

}
