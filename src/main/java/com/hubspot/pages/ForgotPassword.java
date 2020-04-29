package com.hubspot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.TestBase;

public class ForgotPassword extends TestBase {

	public ForgotPassword() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'hubspot.com/login')]") WebElement goBackLink;                                      
	
	@FindBy(id="email") WebElement textBox;
	
	@FindBy(xpath="//i18n-string[contains(text(),'Privacy Policy')]")  WebElement privacyPolicy;
	
	@FindBy(id="reset-button")    WebElement resetBtn;
	
	@FindBy(id="//i18n-string[contains(text(),'Help is on the way')]")  WebElement text;
	
	
	public LoginPage verifyGoBackLink() {
		goBackLink.click();
		return new LoginPage();
	}
	
	public PrivacyPage verifyprivacy() {
		privacyPolicy.click();
		return new PrivacyPage();
	}
	
	public boolean verifyResetBtn() {
		resetBtn.click();
		boolean txt = text.isDisplayed();
		return txt;
	}
	
	

}
