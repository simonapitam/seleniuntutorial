package diffBrowsers;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.*;

public class ParamsExample {
	public class TestNgParameterExample {
		
@Parameters(value="exampleDesc")
	
@Test
	
public void t1(String desc) {
	
		        System.out.println("t1: " + desc);
	
		    }
		
 @Parameters("exampleDesc")
	
@Test
		
public void t2(String desc) {
		
		        System.out.println("t2: " + desc);
		
		    }
		
		}

}