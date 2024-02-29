package testcases;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonPwd 
{
public static boolean uid = false;
public static boolean login = false;
	@Given("uid is valid")
	public void uid_is_valid() 
	{
	    if(AmazonUid.flag == true)
	    {
	    	uid = true;
	    }
	    else
	    {
	    	uid = false;
	    }
	}
	@When("i enter correct password {string}")
	public void i_enter_correct_password(String pass) 
	{
	   if(uid == true)
	   {
		   Hook.pwd.sendKeys(pass);
		   Hook.submit.click();
	   }
	}
	@Then("i should login")
	public void i_should_login() throws Exception 
	{
		  try {
	    Hook.err2.getText();
		  }
		  catch(Exception e)
		  {
			  Hook.test.log(LogStatus.PASS, "Logged in");
			  utility.ScreenShot.takeScreenShot("AmazonLogin");
			  login = true;
		  }
		  
		//  Hook.closeBrowser();
	}
}
