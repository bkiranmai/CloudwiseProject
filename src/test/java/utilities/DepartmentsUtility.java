package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DepartmentsUtility 
{
  //List of all departments
  public int departmentsCount(RemoteWebDriver driver)
  {
	 int deptSize =  driver.findElements(By.xpath("//div[@class='flip-box-front']")).size();
	 return deptSize;
  }
  
  //Navigate to users page
  public void gotoUsersPage(RemoteWebDriver driver, int index, Actions a) throws Exception
  {
	  WebElement dept = driver.findElement(By.xpath("(//div[@class='flip-box-front']//h3)["+index+"]"));
	  a.moveToElement(dept).build().perform();
	  Thread.sleep(4000);
	  WebElement button = driver.findElement(By.xpath("(//div[@class='flip-box-back'])["+index+"]/descendant::span"));
	  button.click();
	  Thread.sleep(4000);
  }
  
  //Get the list of all users in a page
  public List<WebElement> getAllUsers(RemoteWebDriver driver)
  {
	  List<WebElement> l = driver.findElements(By.xpath("//div[contains(@id,'fws')]//h3"));
	  return l;
  }
}
