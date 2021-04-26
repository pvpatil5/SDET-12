package com.vtiger.tc;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.Base;
import com.vtiger.generic.ListnersUtility;
import com.vtiger.objectrepo.ContactPage;
import com.vtiger.objectrepo.CreateContactPage;
import com.vtiger.objectrepo.HomePage;

public class Create_Contact extends Base {

	
	@Test
	public void craetecontact() {
		//test = report.createTest("craetecontact");
		
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		wdu.selectdropdown(ccp.getSelectinitial(), "Mr.");
		
		ccp.getfirstnametxtfld().sendKeys("XYZ");
		ccp.getLastnametxtfld().sendKeys("ABC");
		ccp.getsavebtn().click();
		Assert.assertTrue(true);

	}
	

	@Test(enabled=false)
	public void craetecontact1() {

		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		wdu.selectdropdown(ccp.getSelectinitial(), "Mr.");
		
		ccp.getfirstnametxtfld().sendKeys("XYZ");
		ccp.getLastnametxtfld().sendKeys("ABC");
		ccp.getsavebtn().click();

	}


}
