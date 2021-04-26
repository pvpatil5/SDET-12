package extentreport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent12 {


	static WebDriver driver;

	ExtentHtmlReporter reporter; // To apply look and feel of the report to set the path of extent report
	ExtentReports report; // Attach the path of reporter 
	ExtentTest test;// To create entries in the test cases 

	@BeforeSuite
	public void setup() 
	{
		reporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/sdet12/newreport.html");//imp
		reporter.config().setDocumentTitle("SDET12Report");
		reporter.config().setReportName("Title");
		reporter.config().setTheme(Theme.DARK);

		report= new ExtentReports();//imp
		report.attachReporter(reporter);//imp

	}


	@AfterSuite
	public void closereport() {
		report.flush();
	}


	@BeforeMethod
	public void launch() {
		driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@AfterMethod
	public void close(ITestResult result) throws IOException {

		if(result.getStatus()==ITestResult.FAILURE) 
		{
			test.log(Status.FAIL, result.getName());//name of failed method
			test.log(Status.FAIL, result.getThrowable());//Error msg

			String	path=Extent12.getscreenshot(result.getName());

			test.addScreenCaptureFromPath(path);

		}
		else if (result.getStatus()==ITestResult.SUCCESS) 
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus()==ITestResult.SKIP) 
		{
			test.log(Status.SKIP, result.getName());
		}


	}

	@Test
	public void getTitle() 
	{
		test=report.createTest("getTitle");
		Assert.assertEquals(driver.getTitle(), "vtiger CRM 5 - Commercial Open Source");
	}
	@Test
	public void login() 
	{
		test=report.createTest("login");

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
		Assert.assertTrue(true);

	}
	public static String getscreenshot( String name) throws IOException 
	{
		File srcfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest = new File(destfile) ;
		FileUtils.copyFile(srcfile,finaldest);

		return destfile;
	}

}
