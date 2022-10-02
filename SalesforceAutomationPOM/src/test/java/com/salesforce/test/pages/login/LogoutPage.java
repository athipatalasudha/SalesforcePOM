package com.salesforce.test.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.test.pages.base.BasePage;

public class LogoutPage extends BasePage{

	@FindBy(id="username")public WebElement usrname;
	@FindBy(name="pw")public WebElement password;
	@FindBy(xpath="//input[@id='Login']")public WebElement loginbttn;
	@FindBy(name="rememberUn")public WebElement rememberme;
	@FindBy(linkText="Forgot Your Password?")public WebElement forgot;
	
	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}

	public boolean isUsernameDisplayed()
	{
		String str=usrname.getText();
		System.out.println("The username field has "+str);
		return true;
	}
}
