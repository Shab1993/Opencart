package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	
WebDriver driver;
	
	public Login_Page(WebDriver driver)
	
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	WebElement enteremail;
	
	@FindBy(id="input-password")
	WebElement enterpwd;
	
	//@FindBy(xpath="//input[@value='Login']")
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement lgnstore;		
	

	
	public void username(String user) {
		
		enteremail.sendKeys(user);
	}
	
   public void password(String pwd) {
		
	enterpwd.sendKeys(pwd);
	}
   
   public void submit() {
		
	   btnlogin.click();
		}
			
			
	public boolean getConfirm() {
		
		try {
			return(lgnstore.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
		
	}
	
	
}
