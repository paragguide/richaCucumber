package testcases;

import java.util.Iterator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSearch //extends Hook
{
	  /*
	@Given("I browse to {string} and open url {string} generate report {string}")
	public void i_browse_to_and_open_url_generate_report(String browser, String url, String reportname) throws Exception 
	{
	    openBrowser(browser,url,reportname);
	}
	*/
	   public boolean x = false;
	@Given("user is logged in")
	public void user_is_logged_in()
	{
		if(AmazonPwd.login == true)
		{
			x = true;
		}
	}
	
	@When("^i search for product (.*) with price (.*)")
	public void i_search_for_product_with_price(String prod,int price) throws Exception 
	{
		  if(x == true)
		  {
	   Hook.searchbox.clear();
	   Hook.searchbox.sendKeys(prod+" in range "+price);
	   
	   Hook.test.log(LogStatus.INFO, prod+" in range "+price);
	   
	   Actions a = new Actions(Hook.driver);
	   a.sendKeys(Keys.ENTER).perform();
	   
	   utility.ScreenShot.takeScreenShot(prod);
	   
		  }
	   
	}
	@Then("result should come")
	public void result_should_come() 
	{
		Iterator <WebElement> it =   Hook.searchresult.iterator();
		  while(it.hasNext())
		  {
			  WebElement e = it.next();
			  String prodlink = e.getText();
			  System.out.println(prodlink);
		  }
		  
		  
	}

}
