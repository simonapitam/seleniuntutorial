package diffBrowsers;

import static org.testng.Assert.assertEquals;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class ChromeLaunching {
	
	public static String chromedrivepath="/Users/simonapitam/Documents/chromedriver 2";
    public WebDriver driver ; 
   
  
   public static Logger Mylogger = LogManager.getLogger("DebugLogger");

  @BeforeTest
  public void launchBrowser() {
      
	  System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.chrome.driver", chromedrivepath);
      driver = new ChromeDriver();

      driver.manage().window().fullscreen();
      Mylogger.info("Browser is Launched");
  
  }
  //Launch to amazon.com
  @Test (priority=1)
  public void ChromeNavigate() {
	  
	  driver.navigate().to("https://www.amazon.com");
	  String  currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		 String expectedURL="https://www.amazon.com/";

		 Assert.assertEquals(currentUrl, expectedURL);
		 System.out.println("Test is Passed ........");
		 Mylogger.info("We are Lunched to amazon.com");
	  
  }
  
  
 
@AfterTest
public void QuitBroser() {
	driver.close();
	 Mylogger.info("The Browser is Closed");
	
}
}
