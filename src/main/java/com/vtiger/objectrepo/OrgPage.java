package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage
{

	public OrgPage(WebDriver driver) {
		PageFactory.initElements(driver, OrgPage.class);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgbtn;
	
	public WebElement getCreateorgbtn() {
		return createorgbtn;
	}


}
