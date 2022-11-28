package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLoginPage {
	
WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Log In')]")
	private WebElement headingLogin;
	
	@FindBy(id="user_email")
	private WebElement txtUserEmail;
	
	@FindBy(id="user_password")
	private WebElement txtUserPassword;
	
	@FindBy(name="commit")
	private WebElement btnLogin;
	
	public QAClickLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeadingLogin() {
		return headingLogin;
	}

	public WebElement getTxtUserEmail() {
		return txtUserEmail;
	}

	public WebElement getTxtUserPassword() {
		return txtUserPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

}
