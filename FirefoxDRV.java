package diffBrowsers;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class FirefoxDRV {
	
    String driverPath = "/Users/simonapitam/Documents/firefoxdriver/geckodriver";
    public WebDriver driver ; 
     
  @BeforeMethod
  public void launchBrowser() {
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();

      driver.manage().window().fullscreen();
    
      
  
  }
  @Test (priority=0)
  public void ChromeNavigate() {
	  
	  driver.navigate().to("https://www.amazon.com");
	  
	  
  }
  @AfterMethod
  public void assertNavigate() {
	
	  String  currentUrl=driver.getCurrentUrl();
	System.out.println(currentUrl);
	 String expectedURL="https://www.amazon.com/";

Assert.assertEquals(currentUrl, expectedURL);
System.out.println("After MEthod");
  }
@AfterTest
public void QuitBroser() {
	driver.close();
	
}
}
