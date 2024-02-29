package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import utility.ScreenShot;
import core.Hook;

import org.testng.annotations.DataProvider;

public class AmazonLogin extends Hook
{
	public static boolean login = false;
	
  @Test(dataProvider = "loginData")
  public void login(String uiid, String pwwd) throws Exception
  {
	  signin.click();
	  test.log(LogStatus.INFO, "testing uid "+uiid+" pwd "+pwwd);
	  
	  uid.clear();	
		uid.sendKeys(uiid);
		ctnbtn.click();
		   try {
	   
	   test.log(LogStatus.INFO, err1.getText() );
	   
	  // driver.navigate().back();
	   driver.navigate().to("https://www.amazon.in");
	ScreenShot.takeScreenShot("invaliduid");
		   }
		   catch(Exception e)
		   {
			   // uid is valid..
			   pwd.clear();
			   pwd.sendKeys(pwwd);
			   submit.click();
			      try {
		   
		    test.log(LogStatus.INFO, err2.getText() );
		    ScreenShot.takeScreenShot("invalidpwd");
		driver.navigate().to("https://www.amazon.in");
		//signin.click();
			      }
			      catch(Exception ee)
			      {
			    	  // pwd is correct
			    	 
			    	  test.log(LogStatus.PASS, "loged in sucsess");
			    	  login = true;
			    	  ScreenShot.takeScreenShot("logedinsucsess");
			      }
		   }
	
	  
  }

  @DataProvider
  public Object[][] loginData() throws Exception 
  {
    return utility.WBConnection.readWBData("AmazonLogin.xlsx", "Sheet1");
  }
}
