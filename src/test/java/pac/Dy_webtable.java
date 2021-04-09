package pac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Dy_webtable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();


		//before sorting
		ArrayList<String> a1 = new ArrayList<String>();

		List<WebElement> li = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));

		for (int i = 1; i < li.size(); i++) 
		{
			a1.add(li.get(i).getText());
		}
		Collections.sort(a1);

		//click on org name for sorting
		driver.findElement(By.xpath("//a[text()='Organization Name']")).click();
		Thread.sleep(1000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/images/arrow_down.gif']")));
		
		//get elements after sorting from app
		ArrayList<String> a2 = new ArrayList<String>();
		List<WebElement> l1= driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));

		for (int i = 1; i < li.size(); i++) 
		{
			a2.add(l1.get(i).getText());
		}
		
		System.out.println(a1);
		
		System.out.println(a2);

		Assert.assertEquals(a1, a2);

		
		
		//		List<WebElement> li = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		//		for (int i = 0; i < li.size(); i++) 
		//		{
		//			li.get(i).click();
		//		}


	}

}
