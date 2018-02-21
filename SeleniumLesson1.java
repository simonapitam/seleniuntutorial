/**

 * 
 */
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.*;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.Select;

/**
 * @author simonapitam
 *
 */
public class SeleniumLesson1 {

	/**
	 * @param args
	 */
static WebDriver driver;
//Create a scrool through JavaScript
JavaScriptExecutor jse;

	
	public static void main(String[] args) {
		
		SeleniumLesson1 myobj=new SeleniumLesson1();
		myobj.InvokeBrowser();
		//obj.InvokeBFirefoxBrowser();
		myobj.SearchIphone();
		myobj.closeBrowser ();
	}
	
	
public static void InvokeBrowser() {
	
	try {
		
		System.setProperty("webdriver.chrome.driver", "/Users/simonapitam/Documents/Simona/SeleniumTutorial/chromedriver");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();	
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Open Http Web Page
		//driver.get("http://www.amazon.com");
		driver.manage().window().fullscreen();
		driver.navigate().to("http://www.ebay.com");
		Thread.sleep(5000);

	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static void InvokeFirefoxBrowser() {
	
	try {
		System.setProperty("webdriver.gecko.driver","/Users/simonapitam/Documents/firefoxdriver/geckodriver");
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
 
		driver.get("http://www.ebay.com");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
  
}

public static  void  SearchIphone() {
	//Find Element
		 try {
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 driver.findElement(By.id("gh-ac")).sendKeys("Iphone 7");
			Thread.sleep(3000);
			 driver.findElement(By.id("gh-btn")).click();
			 driver.findElement(By.className("lvtitle")).click();
			 Select drpColor=new Select(driver.findElement(By.id("msku-sel-1")));
			 drpColor.selectByVisibleText("Gold");
			 Select drpCapacity=new Select(driver.findElement(By.name("Storage Capacity")));
			 drpCapacity.selectByVisibleText("128GB");
			driver.findElement(By.id("isCartBtn_btn")).click();
			driver.findElement(By.id("SAVE_FOR_LATER_876227474")).click();
			driver.findElement(By.id("userid")).sendKeys("simonapitam@gmail.com");;
			driver.findElement(By.id("pass")).sendKeys("uravappa21");
			driver.findElement(By.id("sgnBt")).click();
			driver.findElement(By.partialLinkText("Start shopping and search for great deals")).click();
		
 		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	public void closeBrowser () {
		
		driver.close();
		
	}
	
}

