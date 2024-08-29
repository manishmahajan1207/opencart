package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.openCart.pageObjects.HomePage;
import com.openCart.pageObjects.RegistrationPage;
import com.openCart.testBase.BaseClass;

public class TC_RegistrationTest_001 extends BaseClass{
	
	//WebDriver driver;
	
	@Test(groups = {"Regression","Master"},priority = 1)
	public void registrationTest() {
		HomePage hp = new HomePage(driver);
		hp.myAccountClick();
		hp.registerUser();
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		logger.info("Enter new user Registration details");
		
		rp.setFirstName(randomAlphabeticString());
		rp.setLastName(randomAlphabeticString());
		rp.setEmail(randomAlphabeticString()+"@gmail.com");
		rp.setTelephone(randomNumericString());
		String alphabeticAndNumeric = randomAlphabeticAndNumeric();
		rp.setPassword(alphabeticAndNumeric);
		rp.setConfirmPassword(alphabeticAndNumeric);
		rp.btnChkdPolicy();
		rp.btnContinue();
		
		logger.info("user details submitted");
		
		String confirmationMsg = rp.getConfirmationMsg();
		
		if(confirmationMsg.equals("Your Account Has Been Created!")) {
			//System.out.println("testcase is passed");
			
			logger.info("TestCase is Passed");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("testcase is failed");
			logger.info("TestCase is failed");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
}
