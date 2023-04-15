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
		//DriverManager DM = new DriverManager();
		String expectedtitle = lp.getTitle();
		//Assert.assertEquals(actual,excepted);
		System.out.println(expectedtitle);
		
	}
	//********************************************************Test Image Logo Displayed
	@Test(priority = 2)
	public void T2_ActiLogoDisplayed()
	{
		boolean flag = lp.actImgdis();
		System.out.println("The image is displayed  " + flag);
		Assert.assertTrue(flag);
	}
	//*********************************************************Test Link Displayed
	@Test(priority = 3)
	public void T3_testActiLinkDisplayes()
	{
		boolean flag = lp.actlinkdis();
		System.out.println("The test link is displayed  " + flag);
		Assert.assertTrue(flag);
	}
	//*******************************************************Test Login Function
	@Test(priority = 4,enabled = false)
	public void T4_testLoginFunction()
	{
		lp.enterUsername("admin");
		lp.enterpass("manager");
		lp.clickLogin();
		EnterTimePage ep = new EnterTimePage();
		String user = ep.getUserLoggedIn();
		System.out.println("The Loggined User is " + user);
		Assert.assertTrue(user.contains("John"));
		ep.clickLogout();
 		
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
