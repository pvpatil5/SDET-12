package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverUtility;

public class HomePage 
{
	WebDriver driver;
	public 	WebDriverUtility wdu = new WebDriverUtility();

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
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void logout() {
		wdu.movetoelement(driver, adminstrationImg);
		signOutLnk.click();
	}


}
