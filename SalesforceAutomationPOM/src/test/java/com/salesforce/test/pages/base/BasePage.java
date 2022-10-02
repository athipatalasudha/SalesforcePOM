package com.salesforce.test.pages.base;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.salesforce.test.basetest.BaseTest1;
import com.salesforce.test.utility.CommonUtilities;
import com.salesforce.test.utility.GenerateReports;

public class BasePage {
	
	protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 protected static GenerateReports report;
	
	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		report=GenerateReports.getInstance();
	}
	public static String getPageTitle() {
		return driver.getTitle();
	}

public static void clearElement(WebElement element,String objname )
{
	if(element.isDisplayed())
	{
		element.clear();
		System.out.println("pass : "+objname+" element is cleared ");
	
	}
	else
		System.out.println("faile : "+objname+" element is not displayed ");
}

public static void waitUntilVisible(WebElement element, String objName) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public static void sendKeys(WebDriver driver1, WebElement element, Duration timeout, String value,String objname)
{
	new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
	System.out.println("text entered in : "+objname+" field ");
}
public static void enterText(WebElement element, String text, String objname)
{
	if(element.isDisplayed())
	{
		clearElement(element,objname);
		element.sendKeys(text);
		System.out.println("text entered in : "+objname+" field ");
	}
	else
		System.out.println("faile : "+objname+" element is not displayed ");
}
public static void clickOn(WebDriver driver1, WebElement element, Duration timeout,String objname)
{
	new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	System.out.println("\n Click successfully performed on :"+objname);
}
public static void clickElement(WebElement element,String objname)
{
	if((element.isDisplayed()|| element.isSelected()))
	{
		element.click();
		System.out.println("pass : "+objname+" clicked ");
	}
	else
		System.out.println("failed : "+objname+" element is not displayed or already selected ");
}
public static void isSelected(WebElement element,String objname)
{
	if(element.isSelected())
	{
		System.out.println("\n Element already selected");
		
	}
	else
	{
		element.click();
		System.out.println("pass : "+objname+" selected ");
	}
	
}
public static boolean WaitCheck(WebDriver drv, WebElement element, String str)
{
	WebDriverWait wait=new WebDriverWait(drv, Duration.ofSeconds(50));
	wait.until(ExpectedConditions.visibilityOf(element));
	System.out.println("\n Wait check for "+str);
	return element.isDisplayed();
	
}
public static void handlePopup()
{
	try
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tryLexDialog\"]")));
		//clicking on the close
		driver.findElement(By.xpath("//*[@id=\"tryLexDialogX\"]")).click();
		System.out.println("\n Popup closed ");
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("\n No popup present");
	}
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
}
public static By xpath(String xpath)
{
	return By.xpath(xpath);
}
public static By css(String css)
{
	return By.cssSelector(css);
}
public static WebElement findElement(String text,String type)
{
	WebElement element=null;
	switch(type)
	{
	case "xpath" : element =driver.findElement(By.xpath(text));
					break;
	case "css" : element=driver.findElement(By.cssSelector(text));
					break;
	}
	return element;
}
public static void moveToElement(WebElement element, String objectName) {
	waitUntilVisible(element, objectName);
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	System.out.println("moved to " + objectName);

}
public static String readText(WebElement element, String objectName) {
	waitUntilVisible(element, objectName);
	String text = element.getText();
	return text;
}


public static void waitUntilAlertIsPresent() {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.alertIsPresent());
}

public static void waitUntilElementToBeClickable(By locator, String objName) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(locator));
}

public static Alert switchToAlert() {
	// TODO Auto-generated method stub
	waitUntilAlertIsPresent();
	return driver.switchTo().alert();
}

public static void AcceptAlert(Alert alert) {

	System.out.println("Alert accepted");
	alert.accept();

}

public static String getAlertText(Alert alert) {

	return alert.getText();

}

public static void dismisAlert() {
	waitUntilAlertIsPresent();
	Alert alert = switchToAlert();
	alert.dismiss();
	System.out.println("Alert dismissed");

}
public static void switchToWindowOpned(String mainWindowHandle) {
	Set<String> allWindowHandles = driver.getWindowHandles();
	for (String handle : allWindowHandles) {
		if (!mainWindowHandle.equalsIgnoreCase(handle))
			driver.switchTo().window(handle);
	}
	System.out.println("switched to new window");
}
public static WebElement selectFromList(List<WebElement> list,String text) {
	WebElement country=null;
	for (WebElement i : list) {
		if (i.getText().equalsIgnoreCase(text)) {
			System.out.println("selected=" +i.getText());
			country=i;
			break;
		}
		
	}
	return country;
	
}

}
