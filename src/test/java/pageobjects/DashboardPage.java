package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage{
	private WebDriver driver;	
	By logoutlink =By.xpath("//*[@id=\"header1\"]/div/table/tbody/tr[1]/td/a[4]/span");
	By loginText =By.xpath("//*[@id=\"form:j_idt110\"]/legend");
	
public DashboardPage(WebDriver driver1) {
	driver = driver1;
}

public boolean verifylogin(String expectedMessage) throws Exception{
	System.out.println("Inside verify login method");	
	String actualmessage = driver.findElement(loginText).getText();
	Boolean b = actualmessage.equalsIgnoreCase(expectedMessage);
	System.out.println("Actual message is is "+ actualmessage);
	System.out.println("Flag is "+ b);
	return b;
}

public void signout() throws Exception{
	driver.findElement(logoutlink).click();
}
}