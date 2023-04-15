package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverManager;

public class EnterTimePage extends DriverManager{
	
	//page Elements
	
	@FindBy(id="logoutLink") WebElement logoutLink;
	@FindBy(xpath = "//a[@class = 'userProfileLink username ']") WebElement userProfileName;
	
	@FindBy(xpath = "//div[@id='container_tasks']") WebElement tasksLink;
	
	//Page Initialization
	public EnterTimePage()
	{
		PageFactory.initElements(driver,this);
	}
	//Page Action/Functions
	
	public String getUserLoggedIn()
	{
		return userProfileName.getText();
	}
	public String getEnterPageTitle()
	{
		return driver.getTitle();
	}
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public void clickTask()
	{
		tasksLink.click();
	}
	

}
