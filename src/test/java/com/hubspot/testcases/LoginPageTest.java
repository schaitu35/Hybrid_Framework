package com.hubspot.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hubspot.base.TestBase;
import com.hubspot.pages.LoginPage;
import com.hubspot.utils.xlsutils;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;

	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		}
	
	@DataProvider
	public Object[][] getLoginData() throws EncryptedDocumentException, IOException {
		Object[][] data = xlsutils.getData("login");
		return data;
	}
	
	@Test(priority=3, dataProvider = "getLoginData")
	public void verifyLoginTest(String username, String password) {
		boolean b = loginPage.verifyLogin(username, password);
		Assert.assertEquals(b, true);
		
		
	}
	
	@Test(priority=1)
	public void links() throws MalformedURLException, IOException {
		loginPage.verifyLinks();
		
	}
	
	@Test(priority=2)
	public void verifyTitleTest() throws InterruptedException {
		String title = loginPage.verifyTitle();
		Assert.assertEquals(title, "HubSpot Login");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
