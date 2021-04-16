package com.vtiger.tc;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.Base;
import com.vtiger.objectrepo.ContactPage;
import com.vtiger.objectrepo.CreateContactPage;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
public class Create_Contact extends Base {

	@Test
	public void craetecontact() {

		HomePage hp = new HomePage(driver);
		hp.getContactlnk();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		wdu.selectdropdown(ccp.getSelectinitial(), "Mr.");
		
		ccp.getfirstnametxtfld().sendKeys("XYZ");
		ccp.getLastnametxtfld().sendKeys("ABC");
		ccp.getsavebtn().click();

	}

}
