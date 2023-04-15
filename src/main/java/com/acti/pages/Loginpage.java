package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverManager;

public class Loginpage  extends DriverManager{
	
	@FindBy(id = "username") WebElement usernametxt;
	@FindBy(name = "pwd") WebElement passtxt;
	
	@FindBy(xpath = "//div[text()='Login ']") WebElement loginbut;
	
	@FindBy(xpath = "//div[@class='atLogoImg']") WebElement actimg;
	@FindBy(xpath = "//a[contains(text(),'actiTIME Inc')]") WebElement actlink;
	
	//*******************Page Initialization**************************
	
	public 	Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	//*******************Page Actions*******************************
	public void enterUsername(String username)
	{
		usernametxt.clear();
		usernametxt.sendKeys(username);
		
	}
	public void enterpass(String password)
	{
		passtxt.clear();
		passtxt.sendKeys(password);
	}

	public void clickLogin()
	{
		loginbut.click();
	}
	public boolean actImgdis()
	{
		return actimg.isDisplayed();
	}
	public boolean actlinkdis()
	{
		return actlink.isDisplayed();
	}
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	
	
	

}
