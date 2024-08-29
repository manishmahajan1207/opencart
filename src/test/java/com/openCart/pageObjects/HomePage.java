package com.openCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	

	public HomePage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement registerButton;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	public void myAccountClick() {
		
		myAccount.click();
	}
	
	public void registerUser() {
		
		registerButton.click();
	}
	
	public void  userLogin() {
		
		lnkLogin.click();
	}
	
	
	
    
	

}
