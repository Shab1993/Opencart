package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;;

public class My_Account {

	
	WebDriver driver;
	
	public My_Account(WebDriver driver) {
		
		
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	
	//@FindBy(linkText="Logout")
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnklogout;
	
	public void clickLogout() {
		
		lnklogout.click();
	}
	
	
	
	
}
