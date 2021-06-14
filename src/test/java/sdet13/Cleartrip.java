package sdet13;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Cleartrip {

	public static void main(String[] args) throws InterruptedException {

		Date dateobj= new Date();
		System.out.println(dateobj.toString());

		String currentsysdate= dateobj.toString();
		//Tue Apr 27 17:08:24 IST 2021
		//0		1		2		3			4	   5

		String[] arr = currentsysdate.split(" ");

		String day =arr[0];
		String month=arr[1];
		String date=arr[2];
		String year= arr[5];

		System.out.println(day+" "+month+" "+date+" "+year);

		String currentdate=day+" "+month+" "+date+" "+year;


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flights/?gclid=CjwKCAjw7J6EBhBDEiwA5UUM2pC6HYgsh5lEVv4iTI8gClObnsgdXIbpewRTzK8c7P4vUh6Oq9VSTRoCe6IQAvD_BwE&cmp=SEM|D|DF|G|Brand|B_M_Makemytrip_Search_Exact|Brand_MMT_Exact|ETA|262047047474&s_kwcid=AL!1631!3!262047047474!e!!g!!mmt&ef_id=CjwKCAjw7J6EBhBDEiwA5UUM2pC6HYgsh5lEVv4iTI8gClObnsgdXIbpewRTzK8c7P4vUh6Oq9VSTRoCe6IQAvD_BwE:G:s");

		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();

		//				driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("HYD");
		//				driver.findElement(By.xpath("//div[contains(text(),'HYD')]")).click();
		//				Thread.sleep(2000);
		//				driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("PNQ");
		//				driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		//				
		//				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		//				Thread.sleep(1000);
		//				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		//				
		//				
		//				driver.findElement(By.xpath("//div[@aria-label='Tue Jul 27 2021']")).click();
		//div[@class='DayPicker-Day DayPicker-Day--today']

		//div[@aria-label='Tue Apr 27 2021']

		//driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();

		int count = 0;
		while(count<11)
		{
		
			try 
			{
				driver.findElement(By.xpath("//div[@aria-label='Tue Jul 27 2021']")).click();
				break;
			}
			
			catch(Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				count++;
			}
			
		}




	}
}

