package gluecode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pages.AllCloudwisersPage;
import pages.Homepage;
import utilities.DepartmentsUtility;

public class StepDefVerifyTitle 
{
	public Shared sh;
	
	//Create constructor and pass Shared class object as argument.
    public StepDefVerifyTitle(Shared sh)//This object will be supplied by pico container
	{
		this.sh = sh;
	}
	
	@Given("Open {string} browser")
	public void method1(String br) 
	{
	   if(br.equalsIgnoreCase("edge"))	
	   {
	      WebDriverManager.edgedriver().setup();
	      sh.driver = new EdgeDriver();
	   }
	   else
	   {
		   WebDriverManager.chromedriver().setup();
		   sh.driver = new ChromeDriver();
	   }
	}

	@When("Launch the site {string}")
	public void method2(String url) throws Exception {
	    sh.driver.get(url);
	    sh.driver.manage().window().maximize();
	    Thread.sleep(4000);
	    sh.hp = new Homepage(sh.driver);
	    sh.cp = new AllCloudwisersPage(sh.driver);
	    sh.a = new Actions(sh.driver);
	}

	@When("Click on the English flag icon")
	public void method3() throws Exception 
	{
	    sh.hp.clickEngFlag();
	    Thread.sleep(4000);
	}

	@When("Mousehover on {string} button and select {string}")
	public void method4(String text1, String text2 ) throws Exception
	{
		WebElement m1 = sh.driver.findElement(By.xpath("(//a[@class='sf-with-ul'][text()='"+text1+"'])"));
		WebElement m2 = sh.driver.findElement(By.xpath("(//a[text()='"+text2+"'])[1]"));
		sh.a.moveToElement(m1).moveToElement(m2).click().build().perform();
		sh.cp.closeCookie();
		Thread.sleep(4000);
		sh.driver.executeScript("scroll(0,800)");
	}
    
	@Then("{string} page should be displayed")
	public void method5(String expected) 
	{
		if(sh.hp.verifyTitle(sh.driver, expected))
		{
			sh.s.log("Test passed");
		}
		else
		{
			sh.s.log("Test failed");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("Count of all departments should be equal to {string}")
	public void method6(String count)
	{
		int expdeptCount = Integer.parseInt(count);
	    sh.du = new DepartmentsUtility();
	    int actualdeptCount = sh.du.departmentsCount(sh.driver);
	    Assert.assertEquals(expdeptCount, actualdeptCount);
	    sh.s.log("Total number of departments in the page is "+actualdeptCount);
	}

	@Then("Close the site")
	public void method8() 
	{
	   sh.driver.close();
	}

}
