package com.salesforce.test.pages.forgotpassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.test.pages.base.BasePage;

public class ForgotPassword extends BasePage{

	@FindBy(xpath="//input[@id='un']")public WebElement username;
	@FindBy(name = "cancel")public WebElement cancelbttn;
	@FindBy(id="continue")public WebElement continuebttn;
	@FindBy(id = "video-link")public WebElement needhelp;
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/a") public WebElement returntologin;
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/div/p[1]")public WebElement text1;
	
	public ForgotPassword(WebDriver driver) {
		super(driver);
		
	}
	
	public void enterUserName(String uname) {
		waitUntilVisible(username,"user name field");
		enterText(username, uname, "username field");
	}
	public void clickCancel()
	{
		clickElement(cancelbttn, "Cancel Button");
	}
	public void clickContinue()
	{
		clickElement(continuebttn, "Continue Button");
	}
	public void returnToLogin()
	{
		clickElement(returntologin, "Return to Login");
	}
	public boolean verifyText()
	{
		String exp="We’ve sent you an email with a link to finish resetting your password.";
		String s1=text1.getText();
		if(s1.equals(exp))
			return true;
		else return false;
	}
}
