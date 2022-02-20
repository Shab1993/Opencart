package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration {

	
	WebDriver driver;
	
	public  AccountRegistration(WebDriver driver)
	
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void setFirstName (String fname) 
	{
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName (String lname) 
	{
		txtLastName.sendKeys(lname);
		
	}
	
	public void setemail(String email) {
		
		txtEmail.sendKeys(email);
	}
	
public void settelephone(String tel) {
		
	txtTelephone.sendKeys(tel);
	}
	


public void setPassword(String password) {
	
	txtPassword.sendKeys(password);
}

public void setCPassword(String cnfpassword) {
	
	txtConfirmPassword.sendKeys(cnfpassword);
}


public void clickCheckBox() {
	
	chkdPolicy.click();
}

public void clickContinue() {
	
	btnContinue.click();
	
}

 public String getConfirmation() {
	 
	 try {
	 
	   return (msgConfirmation.getText());
	 }
	 catch(Exception e)
	 {
		 
		return (e.getMessage());
	 }
	 
 }



	
	
}
