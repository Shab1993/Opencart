package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	

 	WebDriver driver;
 	
 	public HomePage(WebDriver driver) 
 	{
 		
 		this.driver=driver;
 		
       PageFactory.initElements(driver, this);
 	}
	
 	@FindBy(xpath="//span[text()='My Account']")
 			
 	WebElement linkMyAccount;
 	
 	@FindBy(linkText="Register")
 	WebElement lnkRegister;
 	 
 	@FindBy(linkText="Login")
 	WebElement lnkLogin;
 	
 	//Action Methos for above elements
 	
 	public void ClickMyAccount()
 	{
 		
 		linkMyAccount.click();
 		
 	}
 	public void ClickRegister()
 	{
 		
 		lnkRegister.click();
 		
 	}
 	 
 	public void ClickLogint()
 	{
 		
 		lnkLogin.click();
 				
 	}
 	 
 	 
 	
 	
       
}
