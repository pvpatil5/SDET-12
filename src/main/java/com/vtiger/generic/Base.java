package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;

public class Base
{
	public WebDriver driver;
	public	JavaUtility jv = new JavaUtility();
	public FileUtility fu=  new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	public WebDriverUtility wdu= new WebDriverUtility();


/**
 * Create DB Connection
 * And  Extent Report
 */
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("==DB connection==");
		System.out.println("==Extent report==");
	}

	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("==Close DB connection==");
		System.out.println("== Close Extent report==");
	}

	/**
	 * Launch Browser and get the URL
	 * @throws IOException
	 */
	@BeforeClass
	public void launchBrowser() throws IOException {

		String BROWSER=fu.readDatafrompropfile(IConstants.propfilepath, "browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			driver= new InternetExplorerDriver();
		}
		wdu.maximizewindow(driver);
		wdu.implicitwait(driver);
		driver.get(fu.readDatafrompropfile(IConstants.propfilepath, "url"));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void logintoapp() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(fu.readDatafrompropfile(IConstants.propfilepath, "username"), fu.readDatafrompropfile(IConstants.propfilepath, "password"));

	}
	
	@AfterMethod
	public void logoutfromApp() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
}
