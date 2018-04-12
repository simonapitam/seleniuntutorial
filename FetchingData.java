package dataProviders;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;
 
public class FetchingData {
	WebDriver driver;
	String chromepath="/Users/simonapitam/Documents/chromedriver 2";
	
	@Test
	public void LogintoAmazon(String username,String password) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",chromepath);
		driver=new ChromeDriver();
		
	driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fcard%3Fie%3DUTF8%26ref_%3Dcust_rec_intestitial_signin");
	driver.findElement(By.id("ap_customer_name")).sendKeys("test");
	 driver.findElement(By.id("ap_email")).sendKeys("testselenium@gmail.com");
	 driver.findElement(By.id("ap_password")).sendKeys("test2111");
	 driver.findElement(By.id("ap_password_check")).sendKeys("test2111");
	 driver.findElement(By.id("continue")).click();
	 String actualTitle=driver.getTitle();
	 String expTitle="Amazon Sign In";
	 Assert.assertEquals(actualTitle, expTitle);
	 
	 Thread.sleep(5000);
	 System.out.println("Login Successfully Done");
	}
@AfterTest	
void QuitBrowser() {
	 driver.close();
	}


@DataProvider (name="testdata")
public Object [][]testDatFeed(){
	
	DataProviderTest config=new DataProviderTest ("/Users/simonapitam/Documents/POI/UserCredentials.xls");
		int rows=config.getRowCount();
		Object [][] credentials=new Object [rows][2];
		for (int i=0;i<rows;i++) {
			
			credentials [i][0]=config.getData(0,i,0);
			credentials [i][1]=config.getData(0,i,0);
			
			
		}
	return credentials;
}
	
}