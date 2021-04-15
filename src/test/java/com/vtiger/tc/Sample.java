package com.vtiger.tc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;

public class Sample {

	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void exception1() throws Throwable {
		int randomnumber=	jv.createRandomNumber();

		//Read data from property file
		String UN=fu.readDatafrompropfile(IConstants.propfilepath, "username");
		String PWD=fu.readDatafrompropfile(IConstants.propfilepath, "password");
		String URL=fu.readDatafrompropfile(IConstants.propfilepath, "url");

		WebDriver driver = new ChromeDriver();
		wdu.maximizewindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);

		WebElement un=driver.findElement(By.xpath("//input[@name='user_name']"));
		driver.navigate().refresh();
		un.sendKeys("admin");
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

	}
}
