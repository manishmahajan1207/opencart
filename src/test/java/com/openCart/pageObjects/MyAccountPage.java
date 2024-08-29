package com.openCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement headingMsg;
	
	@FindBy(xpath = "//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]")
	WebElement btnLogout;
	
	
	//option 1
	public String getHeadingMsg() {
		
		try {
			return headingMsg.getText();
		}catch(Exception e){
			return (e.getMessage());
		}
			
	}
	
	//option 2
	public boolean isMyAccountPageExists() {
		try {
			return (headingMsg.isDisplayed());
		}catch(Exception e){
			return false;
		}
		
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
