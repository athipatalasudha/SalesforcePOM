package com.salesforce.test.tests;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforce.test.utility.GenerateReports;

public class testReportsDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String GENERATE_REPORT_PATH="/SalesforceAutomationFramework/extentReports/extentreports.html";
		var gr = GenerateReports.getInstance();
		gr.startExtentReport();
		//ExtentReports extent = new ExtentReports();
		gr.startSingleTestReport("Venky");
		try {
			gr.logTestPassed("Venky rocks");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gr.endReport();
		System.out.println("\n Demo");
	}

}
