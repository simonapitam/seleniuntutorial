package diffBrowsers;

import static org.testng.Assert.assertEquals;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class CreateUserwithparams{
	
    String driverPath = "/Users/simonapitam/Documents/firefoxdriver/geckodriver";
    public WebDriver driver ; 
     
  @BeforeTest
  public void launchBrowser() {
      
	  System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();

      driver.manage().window().fullscreen();
    
      
  
  }
  //Launch to registration amazon.com
  
  @Test (priority=1,description="Registration Page Verification")
  public void AsertNavHard() {
	  
	  driver.navigate().to("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fcard%3Fie%3DUTF8%26ref_%3Dcust_rec_intestitial_signin");
	     String  currentUrl=driver.getTitle();
		 String expectedURL="Amazon Sign In";

		 Assert.assertEquals(currentUrl, expectedURL);
		 System.out.println("Test is Passed ........");
	  
	  
  }

  //Go to the CreateClient
  @Test (priority=2, description="Create New Client Verification")
  public void GotoREgistration() {
	 driver.findElement(By.id("createAccountSubmit")).click();
	 String actualTitle=driver.getTitle();
	 String expTitle="Amazon Registration";
	 Assert.assertEquals(actualTitle, expTitle);
	 
  }
//Go to the CreateClient
	@Parameters({ "custusername", "custemail" ,"custpassword","custpasswordverify"})
  @Test (priority=3, description="Client Registartion")
  public void ClientReg(String custusername,String custemail,String custpassword,String custpasswordverify) {
	  
	 driver.findElement(By.id("ap_customer_name")).sendKeys(custusername);
	 driver.findElement(By.id("ap_email")).sendKeys(custemail);
	 driver.findElement(By.id("ap_password")).sendKeys(custpassword);
	 driver.findElement(By.id("ap_password_check")).sendKeys(custpasswordverify);
	 driver.findElement(By.id("continue")).click();
	 String actualTitle=driver.getTitle();
	 String expTitle="Your Amazon.com";
	 Assert.assertEquals(actualTitle, expTitle);
	
  }
/*
 
@AfterTest
public void QuitBroser() {
	driver.close();
	
}
*/
}
