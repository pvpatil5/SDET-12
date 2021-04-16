package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	WebDriver driver;
	public CreateOrgPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnametxtfld;
	
	@FindBy(id="phone")
	private WebElement phonenotxtfld;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industrydd ;
	
	@FindBy(xpath="//select[@name='rating']")
	private WebElement ratingdd ;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement acctypedd;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;

	public WebElement getOrgnametxtfld() {
		return orgnametxtfld;
	}

	public WebElement getIndustrydd() {
		return industrydd;
	}

	public WebElement getRatingdd() {
		return ratingdd;
	}

	public WebElement getAcctypedd() {
		return acctypedd;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getphonenotxtfld() {
		return phonenotxtfld;
	}
	
	
}
