package dataProviders;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import com.gargoylesoftware.htmlunit.javascript.host.file.File;
 
public class DataProviderTest {
	
	@Test
	public void ExcellData() throws IOException {
		
		String excellPath="/Users/simonapitam/Documents/POI/StudentDetails (1).xlsx";
		FileInputStream file=new FileInputStream(excellPath);
		HSSFWorkbook woorkbook=new HSSFWorkbook (file);
		HSSFSheet sheet=woorkbook.getSheet("UserCredentials");
		
		//Row Count
		int rowNum=sheet.getLastRowNum()+1;
		//Column Count
		int columNum=sheet.getRow(0).getLastCellNum();
		
	
		//String Variable
		String [][] data=new String [rowNum][columNum];
		for (int i=0; i<=rowNum;i++) {
			
			HSSFRow row=sheet.getRow(i);
			
		for (int j=0;j<=columNum;j++) {
			
			HSSFCell cell=row.getCell((short) j);
			String value=cell.toString();
			data[i][j]=value;
			System.out.println("The value is"+ value);
			
		}
	
			
		}
		
	WebDriver workbook;
	((WebDriver) woorkbook).close();

	
		
	}
}