package setup;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasePage {
	private WebDriver driver;
public WebDriver getDriver(){
		return driver;
	}
	
public void initialize(String browser, String url) throws Exception {
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath+":"+browser);
		Logger logger = Logger.getLogger("BasePage");
		PropertyConfigurator.configure("log4j.properties");	
		switch (browser) {
		case "FF":
			System.setProperty("webdriver.gecko.driver", basePath+"\\src\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			logger.info("Opening application URL in FF");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", basePath+"\\src\\drivers\\IEDriverServer1.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			logger.info("Opening application URL in IE");
			break;
		case "Chrome":		
			System.setProperty("webdriver.chrome.driver", basePath+"\\src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			logger.info("Opening application URL in Chrome");
			break;
		default :
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			logger.info("Opening application URL in Chrome");
			break;			
		}
		driver.manage().window().maximize();
	}
	
@BeforeClass
@Parameters({"browser","url"})
public void setup(String Browser, String URL) throws Exception {
	  initialize(Browser,URL);
  }
  
@AfterClass
public void teardown(){
	  System.out.println("In Teardown method of BasePage class");
	  driver.close();
  }
}
