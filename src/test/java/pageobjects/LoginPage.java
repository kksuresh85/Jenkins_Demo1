package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
	private WebDriver driver;

By userid =By.id("userName");
By password =By.id("password");
By submit = By.xpath("//*[@id=\"j_idt38_content\"]/form/table/tbody/tr/td[1]/table/tbody/tr[6]/td/input");

public LoginPage(WebDriver driver2){
	driver = driver2;
}

public DashboardPage Signin(String uname, String pword) throws Exception {
	driver.findElement(userid).sendKeys(uname);
	driver.findElement(password).sendKeys(pword);
	driver.findElement(submit).click();
	DashboardPage d1 = new DashboardPage(driver);
	new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(d1.logoutlink));
	return d1;
	
}

}
