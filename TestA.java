package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.*;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Timeouts;

import java.util.concurrent.*;
import org.openqa.selenium.support.ui.Select;

class TestA {
	@Test //annotation
public void doLogin() {
	System.out.println("Do Login Test");
	
}
	WebDriver  driver; 	
	@Test //Open Chrome Browser 
	
	
	public void OpenBrowser() {

		
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

	@Test(dependsOnMethods = {"OpenBrowser"} ) 
	public void SearchElement() {
	//Find Element
	try {
		 Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.id("gh-ac")).sendKeys("Iphone 6");
		 Select drpOption=new Select(driver.findElement(By.id("gh-cat")));
		 drpOption.selectByVisibleText("Cell Phones & Accessories");
		//Thread.sleep(3000);
		driver.findElement(By.id("gh-btn")).click();
		driver.findElement(By.className("vip")).click();
		
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test(dependsOnMethods = {"SearchElement"} ) 
	public void AddTocard() {
		
		Select drpColor=new Select(driver.findElement(By.id("msku-sel-1")));
		 drpColor.selectByVisibleText("Gold");
		 //Select drpCapacity=new Select(driver.findElement(By.name("Storage Capacity")));
		 //drpCapacity.selectByVisibleText("128GB");
		driver.findElement(By.id("isCartBtn_btn")).click();
		driver.findElement(By.id("SAVE_FOR_LATER_174872203")).click();
		driver.findElement(By.id("userid")).sendKeys("simonapitam@gmail.com");;
		driver.findElement(By.id("pass")).sendKeys("uravappa21");
		driver.findElement(By.id("sgnBt")).click();
		driver.findElement(By.partialLinkText("Start shopping and search for great deals")).click();
		
		
	}	
		
	
@Test(dependsOnMethods = {"AddTocard"} ) 	
public void closeBrowser() {
	
	driver.close();
	
	
	
}
}
