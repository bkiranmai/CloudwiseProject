package gatekeeperChallenge;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GatekeeperChallenge1 {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		int i1=sc.nextInt();
		System.out.println("Enter input2");
		int i2=sc.nextInt();
		sc.close();
		//Open browser and launch the site
		WebDriverManager.chromiumdriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gatekeeper.codeshake.dev/test");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//mat-form-field)[1]/div//input")).clear();
		driver.findElement(By.xpath("(//mat-form-field)[1]/div//input")).sendKeys(""+i1);
		driver.findElement(By.xpath("(//mat-form-field)[2]/div//input")).clear();
		driver.findElement(By.xpath("(//mat-form-field)[2]/div//input")).sendKeys(""+i2);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("(//mat-form-field)[3]/div//input"));
		String z=(String) e.getAttribute("value"); //To get the value of disabled element10 
		if(Integer.parseInt(z)==i1+i2)
		{
			System.out.println("Math scenario passed");
		}
		else
		{
			System.out.println("Math scenario failed");
		}
		//close site
		driver.close();
	}

	}


