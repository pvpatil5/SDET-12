package com.vtiger.tc;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class CreateOrg {

	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void createOrg() throws IOException, InterruptedException 
	{
		
		int randomnumber=	jv.createRandomNumber();
		
		Base base = new Base();
		WebDriver driver=base.launchandlogin();

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
		
		
		

		//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		//		driver.findElement(By.id("pohne")).sendKeys(phonenumber);
		//
		//		WebElement industry=	driver.findElement(By.xpath("//select[@name='industry']"));
		//		wdu.selectdropdown(industry, indDD);
		//
		//		WebElement rating= driver.findElement(By.xpath("//select[@name='rating']"));
		//		wdu.selectdropdown(rating, ratingDD);
		//
		//
		//		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		//		wdu.selectdropdown(type, typeDD);
		//
		//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//		wdu.refresh(driver);
		//		driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		//
		//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//
		//		WebElement searchbox=driver.findElement(By.xpath("//input[@name='search_text']"));
		//
		//		wdu.elementisclickable(driver, searchbox);
		//
		//		searchbox.sendKeys(orgname);
		//
		//		WebElement orgnamedd=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']"));
		//		wdu.selectdropdown(orgnamedd, "Organization Name");
		//		driver.findElement(By.xpath("//input[@name='submit']")).click();
		//
		//		WebElement actualorgname=driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::table[@class='lvt small']"));
		//
		//		wdu.waitforElement(actualorgname);
		//
		//		System.out.println(actualorgname.getText());
		//
		//		boolean result=actualorgname.getText().contains(orgname);
		//
		//		System.out.println(result);

	}

}
