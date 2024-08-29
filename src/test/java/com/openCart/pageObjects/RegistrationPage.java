package com.openCart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = ("//input[@id='input-firstname']"))
	WebElement firstName;
	
	@FindBy(xpath = ("//input[@id='input-lastname']"))
	WebElement lastName;
	
	@FindBy(xpath = ("//input[@id='input-email']"))
	WebElement txtEmail;
	
	@FindBy(xpath = ("//input[@id='input-telephone']"))
	WebElement telephoneNo;
	
	@FindBy(xpath = ("//input[@id='input-password']"))
	WebElement password;
	
	@FindBy(xpath = ("//input[@id='input-confirm']"))
	WebElement confirmPassword;
	
	@FindBy(xpath = ("//input[@name='agree']"))
	WebElement chkdPolicy;
	
	@FindBy(xpath = ("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"))
	WebElement btnContinue;
	
	@FindBy(xpath = ("//h1[contains(text(),'Your Account Has Been Created!')]"))
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	
	public void setTelephone(String number) {
		telephoneNo.sendKeys(number);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String cnfpwd) {
		confirmPassword.sendKeys(cnfpwd);
	}
	
	public void btnChkdPolicy() {
		chkdPolicy.click();
	}
	
	public void btnContinue() {
		btnContinue.click();
	}
	
	
	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		}catch(Exception e){
			return(e.getMessage());
		}
		
	}
}
