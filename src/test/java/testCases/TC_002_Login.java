package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Login_Page;
import testBase.BaseClass;


public class TC_002_Login extends BaseClass{
	
		
	@Test(groups= {"master","sanity","regression"})
	public void HomePage1() {
		
		logger.info("starting TC_002_Login");
		
		try {
		
		driver.get(rb.getString("appURL"));
		
		driver.manage().window().maximize();
		
		HomePage h=new HomePage(driver);
		
		h.ClickMyAccount();
		h.ClickLogint();
		
		Login_Page lp=new Login_Page(driver);
		lp.username(rb.getString("email"));
		logger.info("enter user name");
		
		lp.password(rb.getString("password"));
		logger.info("enter password name");
		lp.submit();
		logger.info("submitted");
		
		      boolean pl=lp.getConfirm();
		      
		      if(pl)
		
		      {
		    	  
		    	  Assert.assertTrue(true);
		    	  logger.info("Test passed");
		      }
		      else {
		    	  
		    	  logger.error("Test Failed");
		    	  captureScreen(driver, "TC_002_Login"); //capture screenshorts and placed to repors folder
		    	  
		    	  Assert.assertTrue(false);
		    	
		      }
		}
catch(Exception e) {
	
	logger.fatal("Account registration failed");
	Assert.fail();
}
		logger.info(" completed TC_002_Login");
	}	

}
