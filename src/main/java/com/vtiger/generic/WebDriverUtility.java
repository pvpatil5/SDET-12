package com.vtiger.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	public void selectdropdown(WebElement element,String visibletext)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	/**
	 * Select elemet from dd by index 
	 * @param element
	 * @param index
	 */
	public void selectdropdown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * @author AMAR-G
	 * Select elemet from dd by value
	 * @param element
	 * @param value
	 */

	public void selectdropdownbyvalue(WebElement element,String value)
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
	public void switchframe(WebDriver driver,int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * switch frame bywebelement
	 * @param driver
	 * @param frameElement
	 */
	public void switchframe(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * Switch frame by name or id
	 * @param driver
	 * @param nameorId
	 */
	public void switchframe(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}

	/**
	 * Move to expected element
	 * @param driver
	 * @param element
	 */
	public void movetoelement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * Drag and Drop
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void draganddrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}

	/**
	 * Switch tom desired windows
	 * @param driver
	 * @param windowtitleexp
	 */
	public void switchtochildwindow(WebDriver driver, String windowtitleexp) 
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while(it.hasNext()) 
		{
			String winid = it.next();
			driver.switchTo().window(winid);
			String acttitle = driver.getTitle();
			if(acttitle.contains(windowtitleexp)) 
			{
				break;
			}
		}
	}
	/**
	 * Wait for elemet until it is displayed
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitforElement(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{

				element.isDisplayed();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}
	/**
	 * Wait for element and once availabel click on it.
	 * @param driver
	 * @param xpath
	 * @throws InterruptedException
	 */
	public void waitandclick(WebDriver driver,String xpath) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{
				driver.findElement(By.xpath(xpath)).click();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}


}
