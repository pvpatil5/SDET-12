package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage
{
	WebDriver driver;
	public OrgPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgbtn;

	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchbox;

	public WebElement getSearchbox() {
		return searchbox;
	}

	@FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")
	private WebElement selectorgtypedd;

	public WebElement getSelectorgtypedd() {
		return selectorgtypedd;
	}
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitbtn;

	public WebElement getSubmitbtn() {
		return submitbtn;
	}


}
