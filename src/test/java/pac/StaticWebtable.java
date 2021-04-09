package pac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebtable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		List<WebElement> l1 = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr[*]/td[1]"));
		
		for (int i = 0; i < l1.size(); i++) 
		{
			System.out.println(l1.get(i).getText());
			if(l1.get(i).getText().equalsIgnoreCase("Ruby")) 
			{
				String version=driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td[2]")).getText();
				
				System.out.println(version);
			}
			
		}
		
		
		
		
	}

}
