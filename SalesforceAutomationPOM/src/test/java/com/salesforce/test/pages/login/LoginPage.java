package com.salesforce.test.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.test.pages.base.BasePage;

public class LoginPage extends BasePage{

	@FindBy(id="username")public WebElement usrname;
	@FindBy(name="pw")public WebElement password;
	@FindBy(xpath="//input[@id='Login']")public WebElement loginbttn;
	@FindBy(name="rememberUn")public WebElement rememberme;
	@FindBy(linkText="Forgot Your Password?")public WebElement forgot;
	@FindBy(id="error")public WebElement errormsg;
	@FindBy(xpath="//*[@id=\"error\"]")public WebElement errormsg1;
	@FindBy(css="#mydomainLink")public WebElement customdomain;
	@FindBy(css="#signup_link")public WebElement notacustomer;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUserName(String username) {
		waitUntilVisible(usrname,"user name field");
		enterText(usrname, username, "username field");
	}
	public void enterPassword(String passWord) {
		waitUntilVisible(password,"password field");
		enterText(password, passWord, "password field");
		
	}
	
	public void clickLoginButton() {
		clickElement(loginbttn,"login button");
	}
	
	public void login(String usrname,String passWrd) {
		enterUserName(usrname);
		enterPassword(passWrd);
		clickLoginButton();
	}
	public void checkRememberMe()
	{
		isSelected(rememberme,"Remember Me CheckBox");
	}
	public String getErrorMsg()
	{
		String msg=readText(errormsg, "Error Msg");
		return msg;
	}
	public void forgotPassword()
	{
		clickElement(forgot, "Forgot your Password Link");
	}
	public void useCustomDomain()
	{
		
	}
	public void tryForFree()
	{
		
	}
	public boolean checkErrorMsgforInvalidInput()
	{
		String exp="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String str=errormsg1.getText();
		if(str.equals(exp))
			return true;
		else return false;
	}
}
