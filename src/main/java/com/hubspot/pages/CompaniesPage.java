package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hubspot.base.TestBase;

public class CompaniesPage extends TestBase{
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i18n-string[contains(text(),'Companies')]") WebElement companiesTitle;
	
	public boolean verifyCompaniesTitie() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement companiesTitle;
		companiesTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i18n-string[contains(text(),'Companies')]")));
		boolean title = companiesTitle.isDisplayed();
		return title;
	}

}
