package gluecode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class StepDefBrokenLinks 
{
   public Shared sh;
	
	//Create constructor and pass Shared class object as argument.
    public StepDefBrokenLinks(Shared sh) //This object will be supplied by pico container
	{
		this.sh = sh;
	}
    
    @Then("Identify and display the broken links for all departments")
    public void method()
    {
    	//To find the broken links in a page, first get all elements into a list
		 List<WebElement> allLinks = sh.driver.findElements(By.xpath("//div[@class='flip-box-back']//a"));
		 System.out.println("Total number of links are "+allLinks.size());
		 //Create one empty list
		 List<String> links = new ArrayList<String>();
		 for(WebElement element:allLinks)
		 {
		  if(element.getAttribute("href")!=null)
		  {
		    String address = element.getAttribute("href");
		    try 
		     {
			   if(address.startsWith("http://")||address.startsWith("https://"))
			     {
			       URL u = new URL(address);
				   HttpURLConnection con = (HttpURLConnection) u.openConnection();
				   con.connect();
				   int sc = con.getResponseCode();
				   String resmsg = con.getResponseMessage();
				    if(sc!=200)
				      {
				        links.add(address+ "  is broken due to "+sc+" and "+resmsg);
				      }
			      }
		      }
			  catch(Exception ex)
			  {
				 links.add(address+ " is not working due to "+ex.getMessage());
			  }
		   }
		}
		  System.out.println("Count of broken links are "+links.size());
		  for(String r:links)
		  {
			  System.out.println(r);
		  }

	}

  }

