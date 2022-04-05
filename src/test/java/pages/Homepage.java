package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{
	//Locators of element as properties in page class
	@FindBy(xpath="(//a[@hreflang='en-US'])[1]")
	public WebElement enlang;
	@FindBy(xpath="(//a[@class='sf-with-ul'][text()='Dit is Cloudwise'])|(//a[@class='sf-with-ul'][text()='This is Cloudwise'])")
	public WebElement cloudwiseBtn1;
	@FindBy(xpath="(//a[text()='All Cloudwisers'])[1]")
	public WebElement cloudwiseBtn2;
	
	//Constructor method
	public Homepage(RemoteWebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}
	
	//Operations and observation methods
	public void clickEngFlag() 
	{
		enlang.click();
    }
	
	public boolean verifyTitle(RemoteWebDriver driver, String expected) 
	{
		if(driver.getTitle().contains(expected))
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
}