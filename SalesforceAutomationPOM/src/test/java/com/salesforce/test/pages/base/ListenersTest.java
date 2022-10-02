package com.salesforce.test.pages.base;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.salesforce.test.utility.*;
import com.salesforce.test.basetest.*;
public class ListenersTest implements ITestListener
{
	GenerateReports report=GenerateReports.getInstance();
	@Override
	public void onTestStart(ITestResult result) {
		report.logTestinfo("Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			report.logTestPassed("Test case Passed: " + result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//report.AttachScreenShot(filePath, result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			report.logTestFailed("Test Case FAiled"+result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//report.AttachScreenShot(filePath, result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
