package com.hubspot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hubspot.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="account-menu")
	WebElement profileMenu;
	
	@FindBy(id="navSearch-input")
	WebElement search;
	
	@FindBy(id="navSearch-input")
	WebElement Menu;
		
	@FindBy(xpath="//div[@class='user-info-email']")
	WebElement profileMail;
	
	@FindBy(xpath="//div[@class='user-info-name']")
	WebElement profileName;
	
	@FindBy(id="signout")
	WebElement signOutBtn;
	
	@FindBy(xpath="//div[@class='isc-help-widget__layout-container']")
	WebElement chatBot;
		
	@FindBy(xpath="//div[@class='nav-left']//a[@id='nav-primary-contacts-branch']")
	WebElement contacts;
	
	@FindBy(xpath="//a[starts-with(@href,'https')]")
	WebElement links;
	
	@FindBy(css="#nav-secondary-contacts")
	WebElement SubContacts;
	
	@FindBy(css="#nav-secondary-companies")
	WebElement SubCompanies;
	
	
	@FindBy(xpath="//a[@id='nav-primary-home']")
	WebElement homPageLogo;
	
	
	
	public String verifyEmail()  {
		profileMenu.click();
		String mail = profileMail.getText();
		//profileMenu.click();
		return mail;
	}
	
	public String verifySignout() throws InterruptedException {
		profileMenu.click();
		signOutBtn.click();
		String loginpage =driver.getCurrentUrl();
		return loginpage;
		
	}
	
	public ContactsPage navigateContactsPage() {
		//Menu.click();
		contacts.click();
		SubContacts.click();
		return new ContactsPage();
		
	}
	
	public CompaniesPage navigateCompaniesPage() {
		
		contacts.click();
		SubCompanies.click();
		return new CompaniesPage();
		
	}
	
	public boolean verifyHomepageLogo()  {
		boolean b =homPageLogo.isDisplayed();
		return b;
	}
	

}
