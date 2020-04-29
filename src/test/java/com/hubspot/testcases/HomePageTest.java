package com.hubspot.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.TestBase;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage =loginPage.navigateHomePage();
		}
	
	@Test
	public void verifyLogolTest() {
		Assert.assertTrue(homePage.verifyHomepageLogo());
		
	}
	
	@Test
	public void verifyEmailTest() {
		
		String email = homePage.verifyEmail();
		Assert.assertEquals(email, prop.getProperty("username"));
	}
	
	@Test
	public void verifySignOutTest() throws InterruptedException{
		
		String title =homePage.verifySignout();
		Assert.assertEquals(title, prop.getProperty("url"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
