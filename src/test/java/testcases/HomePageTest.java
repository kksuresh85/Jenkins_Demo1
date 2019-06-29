package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import setup.BasePage;

public class HomePageTest extends BasePage{
	WebDriver driver;
	
@BeforeClass		
public void testSetup(){
	  driver = getDriver();
  }

@Test   
public void verifylogintest() throws Exception {
	  
	  try {
	  LoginPage login = new LoginPage(driver);
	  DashboardPage d = new DashboardPage(driver);
	  d = login.Signin("kksuresh85", "darling123");
	  Boolean status = d.verifylogin("Payment Details");
	  if (status)
	  System.out.println("Login Success!!");
	  else
	  System.out.println("Login Failure");
	  d.signout();	  
	
	  }
	  catch(Exception e) {
		  e.printStackTrace();
      }
  }

}
