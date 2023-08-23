package careiopack;


import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.io.Reader;

import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  

import javax.swing.RowFilter;

import org.apache.batik.css.engine.value.Value;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.bytebuddy.utility.RandomString;

public class daily_dignostic_report_status {

	public static <Xls_Reader> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	//open site
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		
		
				driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
				driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
				driver.findElement(By.id("next")).click();
				Thread.sleep(1000);
		
			//Click on ABC organization
				
				driver.findElement(By.id("orgDropdown")).click();
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
				Thread.sleep(2000);
				
				//Select 100 items per page
				
				driver.findElement(By.xpath("//*[@id=\"SelectPagesCount\"]/option[6]")).click();
				
				String colBefroeXpath ="/html/body/div[1]/main/div[5]/table/thead/tr/th[";
				String colAfterXpath ="]";
				
				List<WebElement>cols=driver.findElements(By.xpath("/html/body/div[1]/main/div[5]/table/thead/tr/th"));
				System.out.println("total number of column = "+ (cols.size()-1));
				int colcount =cols.size();
				
				List<WebElement> rows =driver.findElements(By.xpath("//*[@id=\"StudyList\"]/tbody//tr"));
				System.out.println("total number of rows = "+ (rows.size()-1));
			int rowcount = rows.size();
				
				 /* Xls_Reader reader = new Xls_reader("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Careioproject\\src\\careiopack\\TestData\\datadriven.xlsx");	
				reader.addSheet("TableData");
			
			 if(!Reader.isSheetExist("TableData")) {
				reader.addsheet("TableData");
			
			
	
			}
			reader.addcolumn("TableData","patient_Name");
			reader.addColumn("TableData","study_Upload_Date");
			for(int col=0;col<cols.size();col++)
				{
				String cellValue =cols.get(col).getText();
					//System.out.println(cellValue +"\t");
				
				}	
			*/
				//driver.findElement(By.xpath("//*[@id=\"PatientName\"]")).getText();
				
				
				Thread.sleep(1000);
				String beforexpath_study_Upload_Date="//*[@id=\"StudyList\"]/tbody/tr[";
				String afterXpath_study_Upload_Date ="]/td[5]";
				
				String beforeXpath_patient_Name="//*[@id=\"StudyList\"]/tbody/tr[";
				String afterXpath_patient_Name="]/td[2]";
				
				for(int i=1; i<=10; i++) {
					
				String actualxpath_patient_Name = beforeXpath_patient_Name+i+afterXpath_patient_Name;
				String patient_Name =driver.findElement(By.xpath(actualxpath_patient_Name)).getText();
				System.out.println(patient_Name);
				Thread.sleep(1000);	
				System.out.println(patient_Name);
				//reader.setCellData("TableData",patient_Name,i, patient_Name);
			
				String actualxpath_Study_upload_date = beforexpath_study_Upload_Date+i+afterXpath_study_Upload_Date;
				String Study_upload_date = driver.findElement(By.xpath(actualxpath_Study_upload_date)).getText();
				System.out.println(Study_upload_date);
				//reader.setCellData("TableData","Study_upload_date"i,Study_upload_date);
				Thread.sleep(1000);
				
					
				}
			}	
}


			
				
			
	
	

		
	
	


	
	
	
	
		
		
		
		
		
		


