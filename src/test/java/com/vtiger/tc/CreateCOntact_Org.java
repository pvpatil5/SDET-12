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

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
import com.vtiger.objectrepo.ContactPage;
import com.vtiger.objectrepo.CreateContactPage;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
public class CreateCOntact_Org {
	//WebDriver driver ;
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void createcontact() throws IOException, InterruptedException 
	{

		String UN=fu.readDatafrompropfile(IConstants.propfilepath, "username");
		String PWD=fu.readDatafrompropfile(IConstants.propfilepath, "password");
		String URL=fu.readDatafrompropfile(IConstants.propfilepath, "url");

		WebDriver	driver= new ChromeDriver();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(UN, PWD);

		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnametxtfld().sendKeys("pavan1");

		wdu.waitandclick(driver, "//input[@name='account_name']//following-sibling::img");
		
		wdu.switchtowindow(driver, "childwindtit");

		ccp.selectorg("TCS");
		wdu.waitandclick(driver, "//a[@id='1']");
		//ccp.searchsuggestion().click();
		wdu.switchtowindow(driver, "Contacts");
		ccp.savebtn().click();



	}


}


