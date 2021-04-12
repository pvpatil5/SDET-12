package com.vtiger.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{


	/**
	 * Maximize the browser window
	 */
	public void maximizewindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}

	/**
	 * Wait until Page is loaded
	 */
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstants.implicitwaittime, TimeUnit.SECONDS);
	}
	/**
	 * Wait until Given element is clickable
	 * @param element
	 */
	public void elementisclickable(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, IConstants.explicitwaittime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Select elemet from dd by visible text
	 * @param element
	 * @param visibletext
	 */

	public void selectbyvisisbletextdd(WebElement element,String visibletext)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	/**
	 * Select elemet from dd by index 
	 * @param element
	 * @param index
	 */
	public void selectbyindexdd(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * Select elemet from dd by value
	 * @param element
	 * @param value
	 */

	public void selectbyvaluedd(WebElement element,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * Refresh the given page
	 */
	public void refresh(WebDriver driver) 
	{
		driver.navigate().refresh();
	}
	/**
	 * Switch frame by index
	 * @param index
	 */
	public void switchframebyindex(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}

	public void switchbyelement(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchframebynameorid(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	public void movetoelement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	public void draganddrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}

}
