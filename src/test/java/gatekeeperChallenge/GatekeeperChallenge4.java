package gatekeeperChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GatekeeperChallenge4 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and close the site
		WebDriverManager.chromiumdriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gatekeeper.codeshake.dev/test");
		Thread.sleep(5000);
		driver.switchTo().frame("iframe");
		Thread.sleep(5000);
		String actual=driver.findElement(By.xpath(
				"(//p[@class='font_8']/span[@class='color_11'])[2]")).getText();
		System.out.println("Text is: "+actual);
		String[] expected=
			{"Gayrettepe","Vefabey","Sokak","No:16","D:11","Istanbul","Turkey","34349"};
		for(String word:expected)
		{
			if(!actual.toLowerCase().contains(word.toLowerCase()))
			{
				System.out.println(word+" is missing");
			}
		}
		//close site
		driver.close();
	}

}
