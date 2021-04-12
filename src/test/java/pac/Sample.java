package pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sample {
	public void login(WebDriver driver) 
	{
		WebElement un =driver.findElement(By.xpath("//input[@name='user_name']"));
		un.sendKeys("admin");
		WebElement pwd =driver.findElement(By.xpath("//input[@name='user_password']"));
		pwd.sendKeys("12345");
	}
}
