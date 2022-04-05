package gluecode;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.AllCloudwisersPage;
import pages.Homepage;
import utilities.DepartmentsUtility;

public class Shared 
{
 //Declare RemoteWebDriver, page class and utility class objects
  
  RemoteWebDriver driver;
  Homepage hp; 
  AllCloudwisersPage cp;
  DepartmentsUtility du;
  
  Actions a; //Declare Action class
  public Scenario s; //to customize results file
	
	@Before
	public void method(Scenario obj)
	{
	  s=obj; 
	}
}
