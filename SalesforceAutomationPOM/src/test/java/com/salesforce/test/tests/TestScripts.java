package com.salesforce.test.tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver.Options;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.salesforce.test.basetest.BaseTest1;
import com.salesforce.test.utility.CommonUtilities;
import com.salesforce.test.pages.forgotpassword.ForgotPassword;
import com.salesforce.test.pages.home.HomePage;
import com.salesforce.test.pages.login.LoginPage;
import com.salesforce.test.pages.login.LogoutPage;

@Listeners(com.salesforce.test.pages.base.ListenersTest.class)
public class TestScripts extends BaseTest1
{
	@Test
	public void LoginErrorMsg_TC01() throws IOException
	{
		CommonUtilities CU = new CommonUtilities();
		var applicationPropertiesFile = CU.loadFile("data");
		String usrname = CU.getApplicationProperty("myusername", applicationPropertiesFile);
		LoginPage lp=new LoginPage(driver);
		lp.enterUserName(usrname);
		lp.clickLoginButton();
		String act="Please enter your password.";
		String exp=lp.getErrorMsg();
		Assert.assertEquals(exp, act);
		report.logTestinfo("Login Error Msg executes");
		//report.logTestPassed("TestCase 01 PASSED");
		
	}
	@Test
	public void LoginToSalesforce_TC02()
	{
		CommonUtilities CU = new CommonUtilities();
		var applicationPropertiesFile = CU.loadFile("data");
		String usrname = CU.getApplicationProperty("myusername", applicationPropertiesFile);
		String pwd=CU.getApplicationProperty("mypswd", applicationPropertiesFile);
		LoginPage lp=new LoginPage(driver);
		lp.login(usrname, pwd);
		String exp="Home Page ~ Salesforce - Developer Edition";
		HomePage hp=new HomePage(driver);
		String act=hp.getTitle();
		Assert.assertEquals(exp, act);
		report.logTestinfo("Home Page loaded successfully");
		//report.logTestPassed("TestCase 02 PASSED");
	}
	@Test
	public void RememberMe_TC03()
	{
		CommonUtilities CU = new CommonUtilities();
		var applicationPropertiesFile = CU.loadFile("data");
		String usrname = CU.getApplicationProperty("myusername", applicationPropertiesFile);
		String pwd=CU.getApplicationProperty("mypswd", applicationPropertiesFile);
		LoginPage lp=new LoginPage(driver);
		lp.checkRememberMe();
		lp.login(usrname, pwd);
		waitUntilPageLoads();
		String exp="Home Page ~ Salesforce - Developer Edition";
		HomePage hp=new HomePage(driver);
		String act=hp.getTitle();
		Assert.assertEquals(exp, act);
		report.logTestinfo("Home Page loaded successfully");
		hp.logout();
		waitUntilPageLoads();
		LogoutPage lgp=new LogoutPage(driver);
		boolean res=lgp.isUsernameDisplayed();
		Assert.assertTrue(res);		
	}
	@Test
	public void ForgotPassword_4A()
	{
		CommonUtilities CU = new CommonUtilities();
		var applicationPropertiesFile = CU.loadFile("data");
		String usrname = CU.getApplicationProperty("myusername", applicationPropertiesFile);
		LoginPage lp=new LoginPage(driver);
		lp.forgotPassword();
		waitUntilPageLoads();
		ForgotPassword fp=new ForgotPassword(driver);
		fp.enterUserName(usrname);
		fp.clickContinue();
		waitUntilPageLoads();
		boolean res=fp.verifyText();
		Assert.assertTrue(res);
		
	}
	@Test
	public void ForgotPassword_4B()
	{
		CommonUtilities CU = new CommonUtilities();
		var applicationPropertiesFile = CU.loadFile("data");
		String usrname = CU.getApplicationProperty("invalidusername", applicationPropertiesFile);
		String pwd=CU.getApplicationProperty("invalidpswd", applicationPropertiesFile);
		LoginPage lp=new LoginPage(driver);
		lp.login(usrname, pwd);
		waitUntilPageLoads();
		boolean res=lp.checkErrorMsgforInvalidInput();
		Assert.assertTrue(res);
	}
}
