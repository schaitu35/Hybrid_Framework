package com.hubspot.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.TestBase;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage = new ContactsPage();

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		homePage =loginPage.navigateHomePage();
		contactsPage = homePage.navigateContactsPage();

	}

	@Test
	public void verifyContactTest() {
		boolean flag = contactsPage.verifyContactBtn();
		Assert.assertTrue(flag);
	
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
