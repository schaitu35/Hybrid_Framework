package com.hubspot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.TestBase;

public class ContactsPage extends TestBase{
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='uiButton private-button private-button--primary private-button--default add-obj private-button--non-link']")
	WebElement createCont;		
	
	@FindBy(css="#UIFormControl-55")
	WebElement createContMenu;
	
	@FindBy(css="#UIFormControl-41")
	WebElement email;	
	
	@FindBy(css="#UIFormControl-43")
	WebElement firstname;	
	
	@FindBy(css="#UIFormControl-47")
	WebElement lastname;	
	
	@FindBy(css="#UIFormControl-55")
	WebElement jobTitle;	
	

	
	
	
	
	
	public boolean verifyContactBtn() {
		createCont.click();
		return createContMenu.isDisplayed();
	}

}
