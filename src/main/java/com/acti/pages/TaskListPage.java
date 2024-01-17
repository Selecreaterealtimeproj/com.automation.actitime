package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import com.acti.driver.DriverManager;

public class TaskListPage extends EnterTimePage{
	
	//******************************Web Element for Enter customer***************************8
	@FindBy(xpath = "//div[@class='title ellipsis']") WebElement taskaddnew;
	@FindBy(xpath = "//div[@class='item createNewCustomer']") WebElement taskNewCust;
	
	@FindBy(xpath = "//input[@class='inputFieldWithPlaceholder newNameField inputNameField']") WebElement newCust_name;
	@FindBy(xpath = "//textarea[@class='textarea' and @placeholder='Enter Customer Description']") WebElement newCust_dis;
	@FindBy(xpath = "//div[@class = 'emptySelection']") WebElement newCust_combo;
	@FindBy(xpath = "//div[@class='itemRow cpItemRow '][2]") WebElement option_combo;
	@FindBy(xpath = "//div[contains(text(),'Create Customer')]") WebElement newCust_but;
	@FindBy(xpath = "//span[@class='innerHtml")  WebElement successmsgText;
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']") WebElement addcustomercancel;
	//***********************Web Element for Delete customer********************************
	@FindBy(xpath = "(//div[@class='cellWrapper']//input)[1]" ) WebElement custname_textbox;
	@FindBy(xpath = "/html/body/div[18]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div[1]/div[3]/div[1]/span" ) WebElement selectcustname;
	@FindBy(xpath = "/html/body/div[18]/div[1]/div[1]/div[2]/div/div[3]/div/div[1]/div[2]/div/div[4]" ) WebElement selcustnameclick;

	@FindBy(xpath = "(//div[@class='cellWrapper']//input)[1]" ) WebElement custname_click;
	@FindBy(xpath = "(//div[text()='ACTIONS'])[1]") WebElement Actionbut_click;
	@FindBy(xpath = "(//div[@class='deleteButton']/div)[1]") WebElement del_but;
	@FindBy(xpath = "//span[text() ='Delete permanently']") WebElement delper_but;
	//**************************************Task Project selection******************************************************
	@FindBy(xpath = "(//td[@class= 'selection']/div)[1]") WebElement checkbox_click;
	@FindBy(xpath = "//div[@class = 'delete button']") WebElement del_click;
	

	public  TaskListPage()
	{
		PageFactory.initElements(driver, this);
	}
	//*******************************Add new customer key word ************************************
	
	public String gettostmessage()
	{
		return successmsgText.getText();
	}
	
	public void clickAddNew()
	{
			taskaddnew.click();
	}
	public void clickNewcust()
	{
			taskNewCust.click();
	}
	public void enterNewCustomer(String newcust)
	{
		newCust_name.clear();
		newCust_name.sendKeys(newcust);
	}
	public void enterNewcustdescrpt(String newdes)
	{
		newCust_dis.clear();
		newCust_dis.sendKeys(newdes);
	}
	public void clickcust()
	{
		newCust_but.click();
	}
	public void selCustCombo()
	
	{
		newCust_combo.click();
		option_combo.click();
		
	}
	//*********************************Delete customer key words***************************************
	
	public void custNameTextbox(String name)
	{
		custname_textbox.sendKeys(name);
		
	}
	public void selCustName()
	{
		selectcustname.click();
		
	}
	public void custNameClick()
	{
		selcustnameclick.click();
	}
	public void custNameClick1()
	{
		custname_click.click();
		
	}
	public void actionBut()
	{
		Actionbut_click.click();
	}
	public void delBut()
	{
		del_but.click();
	}
	public void delPer_But()
	{
		delper_but.click();
	}
	
	//*******************************************task selection**********************************************
	public void checkclick()
	
	{
		if(!checkbox_click.isSelected())
			{checkbox_click.click();}
	}
	public void del_click()
	{
		del_click.click();
		
	}
	public void taskPageAddCustomerCancel()
	{
		addcustomercancel.click();
	}
	
	

}
