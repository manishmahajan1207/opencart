package com.openCart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.pageObjects.HomePage;
import com.openCart.pageObjects.LoginPage;
import com.openCart.pageObjects.MyAccountPage;
import com.openCart.testBase.BaseClass;



public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"}, priority = 2)
	public void loginTest() {
		try {
		logger.info("LoginTest is Started......");
		
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.userLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		logger.info("UserName is entered");
		lp.setPassword(p.getProperty("password"));
		logger.info("Password is entered");
		lp.clickLogin();
		logger.info("LoginBtn is clicked");
		
		MyAccountPage acc = new MyAccountPage(driver);
		
		
		if(acc.getHeadingMsg().equals("My Account")) {
			logger.info("LoginTest is Passed");
			Assert.assertTrue(true);
			
		}else {
			logger.info("LoginTest is Failed");
			Assert.assertTrue(false);
		}
		
		logger.info("LoginTest is Finished......");
		
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		
		}
	}

}
