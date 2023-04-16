package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.acti.driver.DriverManager;
import com.acti.pages.Loginpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverManager{
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected ExtentTest logger;
	Loginpage lp;
	
	@BeforeSuite
	public void setUpReport()
	{
		 extent = new ExtentHtmlReporter("./reports/actiindex.html");
		 report  = new ExtentReports();
		report.attachReporter(extent);
	}
	@BeforeMethod
	public void pretest()
	{
		initApplication();
		lp = new Loginpage();


	}
	@AfterMethod
	public void tearDown()
	{
		report.flush();
		quitBrowser();

	}
	

}
