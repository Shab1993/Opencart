package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pageObjects.HomePage;
import pageObjects.Login_Page;
import pageObjects.My_Account;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email,String pwd, String exp)
	
	{
		logger.info(" Starting TC_003_LoginDDT ");
		
		try {
	
	

		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		
		HomePage h=new HomePage(driver);
		
		h.ClickMyAccount();
		logger.info("Clicked on My Account ");
		h.ClickLogint();
		logger.info("Clicked on Login ");

		
		Login_Page lp=new Login_Page(driver);
		lp.username(email);
		logger.info("set user name");
		
		lp.password(pwd);
		logger.info("set password name");
		lp.submit();
		logger.info("submitted");
		
		boolean pl=lp.getConfirm();
		
		//if(exp.equals("Valid"))
		if(exp.equals("valid"))
		{
			
			if(pl==true)
			{
				logger.info("Login Success ");
				My_Account myacc=new My_Account(driver);
				
				
				myacc.clickLogout();
				
				Assert.assertTrue(true);

			}
			
			else{
				logger.error("Login Failed ");
				
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equals("invalid"))
		
		{
			if(pl==true)
				
			{
           My_Account myacc=new My_Account(driver);
				
				myacc.clickLogout();
				
				Assert.assertTrue(false);
				
			}
			
		}
		else
		{
			logger.error("Login Failed ");
			Assert.assertTrue(true);

		}
		
		}
		
		catch (Exception e)
		
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDDT ");
	}
  
	
	
	/*@DataProvider(name="LoginData")
public String[][] getData() throws IOException{
	
	    
	String path=".\\testData\\Opencart_LoginData.xlsx";
	
	XLUtility xlutil= new XLUtility(path);
	
	                    int totalrows= xlutil.getRowCount("Sheet1");
	                    int totalcols =xlutil.getCellCount("Sheet1", 1);
	    
	         String logindata[][]=new String[totalrows][totalcols];
	         
	         for(int i=1;i<=totalrows;i++)
	         {
	            	 
	             for(int j=0;j<totalcols;j++)
	             {
	            	
	            	logindata[i-1][j]= xlutil.getCellData("Sheet1", i, j);
	            	 
	             }
	          }
	        	 
	         return logindata;
	    }*/
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;
				
	}
	         
	
	
	
	
	
	
}