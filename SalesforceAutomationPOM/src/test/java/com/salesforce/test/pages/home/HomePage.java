package com.salesforce.test.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.test.pages.base.BasePage;

public class HomePage extends BasePage{

	@FindBy(id="userNavLabel")public WebElement usermenu;
	@FindBy(linkText = "Logout")public WebElement logout;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getTitle()
	{
		String str=driver.getTitle();
		return str;
	}
	
	public void logout()
	{
		waitUntilVisible(usermenu,"User Menu");
		clickElement(usermenu, "User Menu");
		clickElement(logout, "Logout Link");
	}
}
