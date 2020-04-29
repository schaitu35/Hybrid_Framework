package com.hubspot.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.hubspot.base.TestBase;
import com.hubspot.utils.xlsutils;

public class LoginPage extends TestBase {

	@FindBy(id = "username")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "loginBtn")
	WebElement submitBtn;

	@FindBy(xpath = "//a[starts-with(@href,'https')]")
	List<WebElement> links;

	@FindBy(xpath = "//i18n-string[contains(text(),'Sign up')]")
	WebElement signUpBtn;

	@FindBy(xpath = "//i18n-string[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicy;

	@FindBy(xpath = "//i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgotPassword;
	
	
	@FindBy(xpath = "//h5[@class='private-alert__title H5-sc-1o270om-0 jaYosH Heading-sc-9dtc71-0 gEXcAV']")
	WebElement alert;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage navigateHomePage() {
		email.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		submitBtn.click();
		return new HomePage();
	
		}
	
	
	HomePage homePage = new HomePage();
	
	public boolean verifyLogin(String un, String pass) {
		email.sendKeys(un);
		password.sendKeys(pass);
		submitBtn.click();
		boolean logo = homePage.verifyHomepageLogo();
		return logo;
			
				
	}

	public String verifyTitle() throws InterruptedException {
		Thread.sleep(5000);
		String title = driver.getTitle();
		return title;

	}

	public void verifyLinks() throws MalformedURLException, IOException {

		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) {
			String link = links.get(i).getAttribute("href");
			
			HttpURLConnection httpConnect = (HttpURLConnection) new URL(link).openConnection();
			httpConnect.connect();
			if (httpConnect.getResponseCode() == 200) {
				System.out.println(link);
			}else {
				System.out.println("bad link found-->>"+link);
			}
			httpConnect.disconnect();
			
		}

	}

	public signUpPage verifySignUp() {
		signUpBtn.click();
		return new signUpPage();
	}

	public PrivacyPage verifyPrivacy() {
		privacyPolicy.click();
		return new PrivacyPage();
	}

	public ForgotPassword verifyForgot() {
		forgotPassword.click();
		return new ForgotPassword();
	}

}
