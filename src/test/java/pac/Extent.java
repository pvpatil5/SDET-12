package pac;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class Extent {
	
		WebDriver driver;
		ExtentHtmlReporter reporter; // look and feel of report
		ExtentReports report; // attach the reporter and provide some info about Test Env.
		ExtentTest test;  // to create the entries in test cases and create logs eg. TC is pass or fail or skip

		@BeforeSuite 
		public void setup() 
		{
			reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/report1.html");// imp
			reporter.config().setDocumentTitle("Selenium Report");
			reporter.config().setReportName("Get Title");
			reporter.config().setTheme(Theme.STANDARD);

			report=new ExtentReports(); // imp
			report.attachReporter(reporter); //imp
			
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Browser", "Chrome");
			report.setSystemInfo("TESTER", "PAVAN");
		}

		@AfterSuite
		public void flush() 
		{
			report.flush();
		}

		@BeforeMethod
		public void launch() 
		{
			
			driver= new ChromeDriver();
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
		}

		@AfterMethod
		public void endReport(ITestResult result) throws IOException 
		{
			if(result.getStatus()==ITestResult.FAILURE) 
			{
				test.log(Status.FAIL, "TC failed" + result.getName()); // Name of the method
				test.log(Status.FAIL, "TC failed" + result.getThrowable()); // Error

				String imagepath=	Extent.getscreenshot(driver, result.getName());

				test.addScreenCaptureFromPath(imagepath);
			}

			else if(result.getStatus()==ITestResult.SUCCESS) 
			{
				test.log(Status.PASS, "TC Pass" + result.getName());
			}
			else if(result.getStatus()==ITestResult.SKIP) 
			{
				test.log(Status.SKIP, "TC SKIP" + result.getName());
			}
		}

		private static String getscreenshot(WebDriver driver, String name) throws IOException 
		{
			File srcfile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
			File finaldest = new File(destfile) ;
			FileUtils.copyFile(srcfile,finaldest);

			return destfile;
		}

		@Test
		public void getTitle() //passing
		{
			test = report.createTest("getTitle"); // Imp
			
			
			String title =	driver.getTitle();
			System.out.println(title);
			String exp ="Facebook – log in or sign up";

			Assert.assertEquals(title, exp);

		}

		@Test(enabled=false)
		public void getTitle1() //fail
		{
			test = report.createTest("getTitle1");
			
			
			String title =	driver.getTitle();
			System.out.println(title);
			String exp ="Facebook – log in or sign";
			Assert.assertEquals(title, exp);
		}



	}


