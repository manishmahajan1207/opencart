package com.openCart.testCases;

import org.testng.annotations.Test;

import com.openCart.pageObjects.HomePage;
import com.openCart.pageObjects.LoginPage;
import com.openCart.pageObjects.MyAccountPage;
import com.openCart.testBase.BaseClass;
import com.openCart.utilities.DataProviders;

import junit.framework.Assert;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = ("LoginData"), dataProviderClass = DataProviders.class,groups = "DataDriven")
	public void loginDDT(String email, String pwd, String exp) {
		
		logger.info("******* Data driven TC is Starting ******");
	
	try
		{
		
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.userLogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUsername(email);
		logger.info("username is entered.....");
		lp.setPassword(pwd);
		logger.info("password is entered.....");
		lp.clickLogin();
		logger.info("Login button is clicked......");
		
		//option 2 validation
		
		logger.info("***Validation Started.....");
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean actualResult = mp.isMyAccountPageExists();
		
		//valid data scenarios
		if(exp.equalsIgnoreCase("valid")) {
			if(actualResult==true) {
				mp.clickLogout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}else {
			if(actualResult==true) {
				mp.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
		}
		
		
		//option 2 validation
		/*MyAccountPage mp = new MyAccountPage(driver);
		String headingMsg = mp.getHeadingMsg();
		
		//Valid Data Scenarios
		if(exp.equalsIgnoreCase("valid")) {
			
			if(headingMsg.equals("My Account")) {
			mp.clickLogout();
			Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		else {   //invalid Scenarios
			
				if(headingMsg.equals("My Account")) {
					mp.clickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
					
			}
			*/
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	logger.info("******* Data driven TC is Finished ******");
			
			
		}
	

}
