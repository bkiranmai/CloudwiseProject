package gatekeeperChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GatekeeperChallenge2 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and launch the site
		WebDriverManager.chromiumdriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gatekeeper.codeshake.dev/test");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//mat-form-field)[4]//input"))
		                                          .sendKeys("bobi",Keys.ENTER);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("//div[@class='ng-star-inserted']"));
		String z=(String) e.getText();
		z = z.toLowerCase();
		if(z.contains("bobi"))
		{
			System.out.println("Unicorn is found");
		}
		else
		{
			System.out.println("Unicorn is not found");
		}
		//close site
		driver.close();
	}

}
