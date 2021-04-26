package com.vtiger.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
import org.testng.ITestResult;


public class Base 
{
	public WebDriver	driver;
	public	JavaUtility jv = new JavaUtility();
	public FileUtility fu=  new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	public WebDriverUtility wdu= new WebDriverUtility();
//	public	ExtentHtmlReporter reporter; // look and feel of report
//	public ExtentReports report; // attach the reporter and provide some info about Test Env.
//	
	public static	WebDriver staticdriver;

/**
 * Create DB Connection
 * And  Extent Report
 */
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("==DB connection==");
//		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/report1.html");// imp
//		reporter.config().setDocumentTitle("Selenium Report");
//		reporter.config().setReportName("Get Title");
//		reporter.config().setTheme(Theme.STANDARD);
//
//		report=new ExtentReports(); // imp
//		report.attachReporter(reporter); //imp
//		
//		report.setSystemInfo("OS", "Windows");
//		report.setSystemInfo("Browser", "Chrome");
//		report.setSystemInfo("TESTER", "PAVAN");
	
	}

	@AfterSuite
	public void afterSuite() 
	{
		System.out.println("==Close DB connection==");
	//	report.flush();
	}

	/**
	 * Launch Browser and get the URL
	 * @throws IOException
	 */
	//@Parameters("browser")
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
		staticdriver=driver;
		wdu.maximizewindow(driver);
		wdu.implicitwait(driver);
		driver.get(fu.readDatafrompropfile(IConstants.propfilepath, "url"));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@BeforeMethod
	public void logintoapp() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(fu.readDatafrompropfile(IConstants.propfilepath, "username"), fu.readDatafrompropfile(IConstants.propfilepath, "password"));

	}
	
	@AfterMethod
	public void logoutfromApp() 
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
		
	}
	public static String getscreenshot( String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);

		return destfile;
	}
}
