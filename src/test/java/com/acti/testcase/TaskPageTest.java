package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TaskPageTest extends BaseTest {
		
		
		@Test(priority = 1, dataProvider = "actidata")
		public void addNewCustomer(String username,String password)
		{
			logger = report.createTest("Test create new Username");
			
			lp.enterUsername(username);
			logger.pass("entered username ");
			
			lp.enterpass(password);
			logger.pass("enter password");
			lp.clickLogin();
			logger.pass(" Login in clicked");
			logger.pass("Successful login");
			
			etp.clickTask();
			logger.pass("task clicked");
			
			tlp.clickAddNew();
			logger.pass("Add new cusotmer button clicked");
			
			tlp.clickNewcust();
			
			tlp.enterNewCustomer("Nalini1");
			logger.pass("entered Name");
			tlp.enterNewcustdescrpt("Udhay is PR");
			logger.pass("entered customer description");
			tlp.selCustCombo();
			logger.pass("combo box selected");

			tlp.clickcust();
			logger.pass("New customer created");
			//String actual = tlp.gettostmessage();
			//System.out.println(actual);
			//Assert.assertTrue(actual.contains("has been created"));
			quitBrowser();
			logger.pass("browser exit new customer created");

			
		}
		@Test(priority = 2, dataProvider = "actidata")
		public void deletecustomer(String username,String password) throws InterruptedException
		
		{
			logger = report.createTest("Test Deleted Username");
			
			lp.enterUsername(username);
			logger.pass("entered username ");
			
			lp.enterpass(password);
			logger.pass("enter password");
			lp.clickLogin();
			logger.pass(" Login in clicked");
			logger.pass("Successful login");
			
			etp.clickTask();
			logger.pass("task clicked");
			tlp.custNameTextbox("Nalini1");
			logger.pass("customer name is selected");
			tlp.selCustName();
			logger.pass("customer name is typed");
			tlp.custNameClick();
			logger.pass("customer name is clicked" );
			Thread.sleep(1000);
			tlp.actionBut();
			logger.pass("action button is clicked");
			tlp.delBut();
			logger.pass("delete button is clicked");
			tlp.delPer_But();
			logger.pass("deleted permanamtly");
			//String actual = tlp.gettostmessage();
			//System.out.println(actual);
			//Assert.assertTrue(actual.contains("has been created"));

			quitBrowser();
			logger.pass("browser exit  customer deleted");

			
		}
		
			

	
}
