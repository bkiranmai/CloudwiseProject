package gluecode;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import utilities.DepartmentsUtility;

public class StepDefDuplicateNames 
{
  public Shared sh;
	
	//Create constructor and pass Shared class object as argument.
    public StepDefDuplicateNames(Shared sh)//This object will be supplied by pico container
	{
		this.sh = sh;
	}
    
    @Then("Click on each department and get the list of all users and count should be equal to {string}")
    public void method1(String value) throws Exception 
    {
    	 int allUsers = Integer.parseInt(value);//Convert string value to int
         //Declare empty array
		 List<String> allNames =new ArrayList<String>();
		 int countofAllusers=0;
		 sh.du = new DepartmentsUtility(); //Create object to utility class
		 int dptCount = sh.du.departmentsCount(sh.driver); //Get the count of departments
		 for(int i=1; i<=dptCount; i++)
		   {
			  sh.du.gotoUsersPage(sh.driver, i, sh.a); //Navigate to users page
			  List<WebElement> l = sh.du.getAllUsers(sh.driver); //Get list of users in a page
			  int count = l.size(); //Get the count of users in a page
			  countofAllusers = count + countofAllusers;
			  System.out.println("Count of users in "+i+" departmant is "+l.size());
			  for(WebElement e:l)
			  {
				 String temp = e.getText();
				 allNames.add(temp);
	           }
			  sh.driver.navigate().back();
		   }
		  sh.s.log("Total no. of users in all departments are "+countofAllusers);
		  sh.s.log("All user names in all departments  "+allNames);
		  //Assertion
		  if(allUsers==countofAllusers)
		  {
			  sh.s.log("Test Passed, Count of  all users are "+countofAllusers);
		  }
		  else
		  {
			  sh.s.log("Test Failed, Expected users are  "+allUsers+"but actual users are "+countofAllusers);
		  }
	}
    @Then("Display all the duplicate names in the list")
    public void method2() throws Exception 
    {    //Create two Empty lists
		 List<String> uniqueNames = new ArrayList<String>();
		 List<String> duplicateNames =new ArrayList<String>();
		 int dptCount = sh.du.departmentsCount(sh.driver); //Get the count of departments
		 for(int i=1; i<=dptCount; i++)
		   {
			  sh.du.gotoUsersPage(sh.driver, i, sh.a); //Navigate to users page
			  List<WebElement> l = sh.du.getAllUsers(sh.driver); //Get list of users in a page
			  for(WebElement e:l)
			  {
				 String temp = e.getText();
				  int flag=0;
				    for(String name:uniqueNames)
				      {
					    if(name.equalsIgnoreCase(temp))
					      {
					    	duplicateNames.add(temp);
						    flag=1;
						    break;
					      } 
				      }
				        if(flag==0)
				        {
				        	uniqueNames.add(temp);
				        }
			  }
			  //Back to previous page
			  sh.driver.navigate().back();
	   }
		  System.out.println("Duplicate names "+duplicateNames);
		  System.out.println(" ");
		  System.out.println("Unique names "+uniqueNames);
    }
    
}
