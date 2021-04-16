package com.vtiger.tc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.generic.Base;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
import com.vtiger.objectrepo.CreateOrgPage;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
import com.vtiger.objectrepo.OrgPage;

public class CreateOrg extends Base
{
	@Test
	public void createOrg() throws IOException, InterruptedException 
	{

		int randomnumber=	jv.createRandomNumber();
		
		//Read Test Script Data from Excel
		String name=eu.readDatafromExcel("Sheet1", 0, 0);
		String orgname=name+randomnumber;
		String phonenumber=eu.readDatafromExcel("Sheet1", 1, 0);
		String indDD=eu.readDatafromExcel("Sheet1", 2, 0);
		String ratingDD=eu.readDatafromExcel("Sheet1", 3, 0);
		String typeDD=eu.readDatafromExcel("Sheet1", 4, 0);

		//Name of org
		System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrgPage op= new OrgPage(driver);
		op.getCreateorgbtn().click();

		CreateOrgPage cop = new CreateOrgPage(driver);
		cop.getOrgnametxtfld().sendKeys(orgname);
		cop.getphonenotxtfld().sendKeys(phonenumber);


		wdu.selectdropdown(cop.getIndustrydd(), indDD);
		wdu.selectdropdown(cop.getAcctypedd(), typeDD);
		wdu.selectdropdown(cop.getRatingdd(), ratingDD);

		cop.getSavebtn().click();
		wdu.refresh(driver);

		hp.getHomepagelnk().click();
		hp.getOrglink().click();

		op.getSearchbox().sendKeys(orgname);
		wdu.selectdropdown(op.getSelectorgtypedd(),"Organization Name" );
		op.getSubmitbtn().click();

		WebElement actualorgname=driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::table[@class='lvt small']"));

		wdu.waitforElement(actualorgname);

		System.out.println(actualorgname.getText());

		boolean result=actualorgname.getText().contains(orgname);

		Assert.assertEquals(true, result);

	}

}
