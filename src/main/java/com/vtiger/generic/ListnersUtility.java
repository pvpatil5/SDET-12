package com.vtiger.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListnersUtility extends Base implements ITestListener {

	WebDriverUtility wdu = new WebDriverUtility();
	public ExtentTest test;  // to create the entries in test cases and create logs eg. TC is pass or fail or skip	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		ExtentReportrceation.testlog.log(Status.PASS, result.getName()+" is Pass");
	}

	public void onTestFailure(ITestResult result) {
		
		ExtentReportrceation.testlog.log(Status.FAIL, result.getName()+" is Fail");
		ExtentReportrceation.testlog.log(Status.FAIL, "TC failed" + result.getThrowable());
		try {
			Base.getscreenshot(result.getName());
			ExtentReportrceation.testlog.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, "TC SKIP" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentReportrceation.report(context);
		ExtentReportrceation.testlog.log(Status.INFO, context.getName()+"suite is started");	
	}

	public void onFinish(ITestContext context) {
		ExtentReportrceation.testlog.log(Status.INFO, context.getName()+" Suite is Completed");
		ExtentReportrceation.report.flush();
	}

}
