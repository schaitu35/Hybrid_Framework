package com.hubspot.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.TestBase;
import com.hubspot.pages.CompaniesPage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;

public class CompaniesPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CompaniesPage companiesPage;
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage =loginPage.navigateHomePage();
		companiesPage = homePage.navigateCompaniesPage();
		}
	
	@Test
	public void verifyCompaniesTitleTest() {
		boolean flag = companiesPage.verifyCompaniesTitie();
		Assert.assertTrue(flag, "Title not matches");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
