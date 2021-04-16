package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement selectinitial;
	

	public WebElement getSelectinitial() {
		return selectinitial;
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstnametxtfld;
	

	public WebElement getfirstnametxtfld() {
		return firstnametxtfld;
	}

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnametxtfld;

	public WebElement getLastnametxtfld() {
		return lastnametxtfld;
	}
	@FindBy(xpath="//input[@name='account_name']//following-sibling::img")
	private WebElement selectorgbtn;
	
	public WebElement selectorgbtn() {
		return selectorgbtn;
	}

	@FindBy(id="search_txt")
	private WebElement searchboxchild;
	
	public WebElement searchboxchild() {
		return searchboxchild;
	}
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowchild;
	
	public WebElement searchnowchild() {
		return searchnowchild;
	}
	@FindBy(xpath="//a[@id='1']")
	private WebElement searchsuggestion;
	
	public WebElement searchsuggestion() {
		return searchsuggestion;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement savebtn;
	
	public WebElement getsavebtn() {
		return savebtn;
	}

	public void selectorg(String orgname) {
		searchboxchild.sendKeys(orgname);
		searchnowchild.click();
	}
	
	public void createcontact(String contactname) {
		lastnametxtfld.sendKeys(contactname);
		savebtn.click();
	}
	
}
