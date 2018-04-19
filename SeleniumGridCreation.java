package SeleniumGrid;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import java.net.MalformedURLException;
import java.net.URL;
 
import org.testng.asserts.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGridCreation {
	
	static WebDriver driver;
	static String nodeUrl;
	@BeforeTest
	 public void setup() throws MalformedURLException {
	 nodeUrl = "http://192.168.0.11:5555/wd/hub";
	 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	 capabilities.setBrowserName("chrome");
	 capabilities.setPlatform(Platform.MAC);

	 driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
	 }
	 
	
		 @Test
		 public void simpleTest() {
		 driver.get("https://www.edureka.co/");
		 Assert.assertEquals("Instructor Led Online Courses with 24x7 On-Demand Support | Edureka", driver.getTitle());
		 }
  
@AfterTest
public void afterTest() {
driver.quit();
}

}
