package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllCloudwisersPage
{
	    //Locators of element as properties in page class
		@FindBy(xpath="(//a[text()='Allow all cookies'])[1]")
		public WebElement cookie;
		
		//Constructor method
		public AllCloudwisersPage(RemoteWebDriver driver)
		{
		  PageFactory.initElements(driver, this);
		}
		
		//Operations and observation methods
		public void closeCookie()
		{
			cookie.click();
		}
}
