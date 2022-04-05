package gatekeeperChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GatekeeperChallenge3 
{
	public static void main(String[] args) throws Exception
	{ 
		//Open browser and launch the site
		WebDriverManager.chromiumdriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gatekeeper.codeshake.dev/test");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//span[contains(text(),'battle begin')]/parent::button")).click();
		Thread.sleep(5000);
		//Click on the orange colored arrow
		driver.findElement(By.xpath(
				"//div[@class='arena']//i[contains(@style,'orange')]")).click();
		//close site
		driver.close();
	}

}
