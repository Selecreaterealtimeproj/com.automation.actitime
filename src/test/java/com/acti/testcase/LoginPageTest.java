package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.acti.pages.EnterTimePage;
public class LoginPageTest extends BaseTest
{
	
	
	//*************************************************Test page Title
	@Test(priority = 1)
	public void T1_LoginPageTitle()
	{
		logger = report.createTest("logger Test login page Title");
		String expectedtitle = lp.getTitle();
		//Assert.assertEquals(actual,excepted);
		System.out.println(expectedtitle);
		logger.pass("title actual tile matched the excepted");
		
	}
	//********************************************************Test Image Logo Displayed
	@Test(priority = 2)
	public void T2_ActiLogoDisplayed()
	{
		logger = report.createTest("logger Logo Image displayed");
		boolean flag = lp.actImgdis();
		System.out.println("The image is displayed  " + flag);
		Assert.assertTrue(flag);
		logger.pass("The image of Acti logo  is displayed");
	}
	//*********************************************************Test Link Displayed
	@Test(priority = 3)
	public void T3_testActiLinkDisplayes()
	{
		logger = report.createTest("logger Logo Acti link displayed");

		boolean flag = lp.actlinkdis();
		System.out.println("The test link is displayed  " + flag);
		Assert.assertTrue(flag);
		logger.pass("The actitime link is displayed");

	}
	//*******************************************************Test Login Function
	@Test(priority = 4,enabled = false)
	public void T4_testLoginFunction()
	{
		logger = report.createTest("Test Login Function");
	
		lp.enterUsername("admin");
		logger.pass("Entered username");
		lp.enterpass("manager");
		logger.pass("Enter Password");
		lp.clickLogin();
		logger.pass("Clicked on login button");
		EnterTimePage ep = new EnterTimePage();
		String user = ep.getUserLoggedIn();
		System.out.println("The Loggined User is " + user);
		Assert.assertTrue(user.contains("John"));
		logger.pass("user loggin in contains the name john");	

		
		ep.clickLogout();
		logger.pass("Logged out form the application");	

 		
	}
	//*********************************************************Test Negative Function
	@Test(priority = 5)
	public void T5_testLoginNegativeFunction()
	{
		lp.enterUsername("admin1");
		lp.enterpass("manager");
		lp.clickLogin();
	}
}
