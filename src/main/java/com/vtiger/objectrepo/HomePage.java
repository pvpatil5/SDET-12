package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlnk;
	
	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	

}
