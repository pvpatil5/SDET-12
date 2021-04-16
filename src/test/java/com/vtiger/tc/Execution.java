package com.vtiger.tc;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Execution {



	@Test
	public void c() {
		System.out.println("==test c==");
	}

	@Test
	public void a() {
		System.out.println("==test a==");	
	}

	@Test
	public void b() {
		System.out.println("==test b==");

	}


	@AfterMethod
	public void aftermethod() 
	{
		System.out.println("==Logout==");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("==Closing the Broswer===");
	}
	//
	//	@AfterTest
	//	public void afterTest() {
	//		System.out.println("==Cross Browser Execution===");
	//
	//	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("==Close DB connection==");
		System.out.println("==Close Extent report==");
	}
	@BeforeClass
	public void beforeclass() 
	{
		System.out.println("==Launching Browser===");
	}

	//	@BeforeTest
	//	public void beforetest() 
	//	{
	//		System.out.println("==Cross Browser Execution===");
	//
	//	}
	@BeforeSuite
	public void beforesuite() 
	{
		System.out.println("==DB connection==");
		System.out.println("==Extent report==");
	}
	@BeforeMethod 
	public void beforemethod() 
	{
		System.out.println("==Login Action in App==");
	}



}
