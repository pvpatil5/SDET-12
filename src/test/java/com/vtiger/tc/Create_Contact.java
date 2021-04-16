package com.vtiger.tc;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.generic.Base;
import com.vtiger.objectrepo.LoginPage;
public class Create_Contact extends Base {

	public static void main(String[] args) throws IOException {

		//Base base = new Base();
		Create_Contact cc = new  Create_Contact();
		//WebDriver driver=cc.launchandlogin();
	
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		Select title = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		title.selectByVisibleText("Ms.");

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Milana");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("C P");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
