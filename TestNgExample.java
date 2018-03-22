package testng;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgExample {
   
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "/Users/simonapitam/Documents/firefoxdriver/geckodriver";
    public WebDriver driver ; 
     
     @BeforeTest
      public void launchBrowser() {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.gecko.driver", driverPath);
          driver = new FirefoxDriver();
    
          driver.manage().window().fullscreen();
          driver.get(baseUrl);
          
      
      }
      @Test
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
     }
      @AfterTest
      public void terminateBrowser(){
          
    	  driver.close();
      }
}