package testcases;

import org.junit.Assert;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonUid extends Hook
{
  public static boolean flag = false;
  
	@Given("I open browser {string} and get url {string} generate report {string}")
	public void i_open_browser_and_get_url_generate_report(String browser, String url, String reportname) throws Exception
	{
	    openBrowser(browser,url,reportname);
	}
	@Given("click on signin")
	public void click_on_signin() 
	{
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String userid) 
	{
	    uid.sendKeys(userid);
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I validate userid")
	public void i_validate_userid() 
	{
		  try {
	  test.log(LogStatus.ERROR, err1.getText());
		  }
		  catch(Exception e)
		  {
			  test.log(LogStatus.PASS, "uid is valid");
		  }
	}
	@Then("password textbox comes")
	public void password_textbox_comes() 
	{
	    if(pwd.isDisplayed())
	    {
	    	test.log(LogStatus.PASS, "password avlb");
	    	flag = true;
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "password not displayed");
	    	Assert.fail("password not displayed");
	    }
	    
	   // closeBrowser();
	}

}
