package com.vtiger.tc;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.vtiger.generic.Base;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
import com.vtiger.objectrepo.ContactPage;
import com.vtiger.objectrepo.CreateContactPage;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
public class CreateCOntact_Org extends Base {

	@Test
	public void createcontact() throws IOException, InterruptedException 
	{
	
		//Click on contact
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		//click on create contact
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		//Conatct Name
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnametxtfld().sendKeys("pavan1");

		//Click on plus btn so that new window should open
		wdu.waitandclick(driver, "//input[@name='account_name']//following-sibling::img");

		//switch to window
		wdu.switchtowindow(driver, "childwindtit");

		//select orgname
		ccp.selectorg("TCS");
		wdu.waitandclick(driver, "//a[@id='1']");

		//switch back to Contacts window
		wdu.switchtowindow(driver, "Contacts");

		//Click on save btn
		ccp.getsavebtn().click();



	}


}


