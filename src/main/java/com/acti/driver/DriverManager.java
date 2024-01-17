package com.acti.driver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Script Driver manager 

public class DriverManager {
	
	public static WebDriver driver;
	Properties prop;
	
	public DriverManager()
	
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			
			prop = new Properties();
			prop.load(fis);
				
		}
		
		catch(Exception e)
		{
			System.out.println("unable to load properties" + e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	@Test
	public  void  initApplication()
	{
		String browser = prop.getProperty("browser");
		System.out.println("brower selected " + browser);
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		else
		{
			System.out.println("does not support the browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://www.google.com/");

		getAppURL();
		
	}
	//@Test
	public void getAppURL()
	{
		String url1 = prop.getProperty("url");
		driver.get(url1);
	}
	
	public void quitBrowser()
	{
		driver.close();
	}

}
