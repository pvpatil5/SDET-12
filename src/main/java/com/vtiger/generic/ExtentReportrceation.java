package com.vtiger.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportrceation {

	public static ExtentReports report;
	public static ExtentTest testlog;
	public static void report(ITestContext result)
	{
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yy");
		Date date=new Date();
		
		ExtentHtmlReporter htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/report"+df.format(date)+".html");
		htmlreport.config().setDocumentTitle("App report");
		htmlreport.config().setReportName(result.getName());
		htmlreport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		
		testlog=report.createTest(result.getName());
		
	}
}
