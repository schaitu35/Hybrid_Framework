package com.hubspot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.TestBase;

public class signUpPage extends TestBase{

	public signUpPage() {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//input[@id='uid-firstName-6']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='uid-lastName-7']")
	WebElement lastname;  
	
	@FindBy(xpath="//input[@id='uid-email-9']")
	WebElement email;        
		
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
		
	@FindBy(xpath="//a[contains(text(),'HubSpot Customer Terms of Service.')]")
	WebElement termsOfService;
	
	
	public Terms_of_Service verifyTermsofService() {
		termsOfService.click();
		return new Terms_of_Service();
	}


	

}
