package diffBrowsers;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class ChromeFirefox {
	WebDriver driver;
	public static String drivepath="/Users/simonapitam/Documents/chromedriver 2";
  @BeforeMethod
  public void Chromedrv() {
	  System.setProperty("webdriver.chrome.driver",drivepath);
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();

		
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		System.out.println("Before Method");
	  
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
