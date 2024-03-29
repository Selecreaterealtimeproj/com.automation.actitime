package com.acti.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.acti.driver.DriverManager;
import com.acti.pages.EnterTimePage;
import com.acti.pages.Loginpage;
import com.acti.pages.TaskListPage;
import com.acti.utils.ExcelLib;
import com.acti.utils.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest extends DriverManager{
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected ExtentTest logger;
	Loginpage lp;
	EnterTimePage etp;
	TaskListPage tlp;
	
	@BeforeSuite
	public void setUpReport()
	{
	 
		 extent = new ExtentHtmlReporter("./reports/actitimeindex.html");
		 report  = new ExtentReports();
		report.attachReporter(extent);
	}
	@BeforeMethod
	public void pretest()
	{
		initApplication();
		lp = new Loginpage();
		etp = new EnterTimePage();
		tlp = new TaskListPage();
		


	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreen(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} 
		report.flush();
		//quitBrowser();

	}
	@DataProvider(name="actidata")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./src/test/resources/testdata/actidata.xlsx");
		int rows = excel.getRowCount(0);

		Object[][] data = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			data[i][0]=excel.getCellData(0, i, 0);
			data[i][1]=excel.getCellData(0, i, 1);
		}

	    return data;
	

}
}
