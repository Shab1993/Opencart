package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass  {

	
   @Test(groups= {"master","regression"})
   public void test_account_registration(){
	   
	   logger.info("statrted Testing");
	   
	  try {
	   driver.get("https://demo.opencart.com/");
	   
	   driver.manage().window().maximize();
	   
	   HomePage hp=new HomePage(driver);
	   
	   hp.ClickMyAccount();
	   hp.ClickRegister();
	   
	   AccountRegistration regpage=new AccountRegistration(driver);
       
       regpage.setFirstName("bhha");
	   regpage.setLastName("na5t");
	   regpage.setemail(randomestring()+"@gmail.com");
	   regpage.settelephone("12398456");
	   regpage.setPassword("shab5ha");
	   regpage.setCPassword("shab5ha");
	   regpage.clickCheckBox();
	   regpage.clickContinue();
	   
	   String confmsg=regpage.getConfirmation();
	   
	   if(confmsg.equals("Your Account Has Been Created!"))
			   
			   {
		   
		  Assert.assertTrue(true);
			   }
	   
	   else
	   {
		   
		   Assert.assertTrue(false);
	   }
   
   }
	  
	  catch(Exception e)
	  
	  {
		  logger.fatal("login failed");
		  Assert.fail();
	  }
	  
	  logger.info("Finished TC_001_Account Registration");
	  }
   
  
   
}
