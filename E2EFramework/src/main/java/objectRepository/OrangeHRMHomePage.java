package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage 
{

	WebDriver driver;
	//define page object/elements as private
	//old way in Pom
	
	//private By txtPIMHeader = By.xpath("//h6[text()='Dashboard']");
	//private By txtLoggedInUser = By.xpath("//img[@alt='profile picture']/following-sibling::p");
	//private By lnkLogout = By.linkText("Logout");
	
	//New Way using pageFactory
	
	//private By txtPIMHeader = By.xpath("//h6[text()='PIM']");
	
		@FindBy(xpath="//h6[normalize-space()='Dashboard']")
		private WebElement txtPIMHeader;
	   
	    //@FindBy(xpath="//h6[text()='Dashboard']")
	    //private WebElement txtPIMHeader;
		
		//private By txtLoggedInUser = By.xpath("//img[@alt='profile picture']/following-sibling::p");
		@FindBy(xpath="//img[@alt='profile picture']/following-sibling::p")
		private WebElement txtLoggedInUser;
		
		//private By lnkLogout = By.linkText("Logout");
		@FindBy(linkText="Logout")
		private WebElement lnkLogout;
		
		public OrangeHRMHomePage(WebDriver driver) {
			//this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public WebElement getTxtPIMHeader() {
			return txtPIMHeader;
		}
		public WebElement getTxtLoggedInUser() {
			return txtLoggedInUser;
		}
		public WebElement getLnkLogout() {
			return lnkLogout;
		}
}
