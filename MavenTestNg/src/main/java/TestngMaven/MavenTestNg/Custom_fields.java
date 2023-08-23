package TestngMaven.MavenTestNg;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Custom_fields {

	WebDriver driver;
	
	@BeforeTest

	public void setproperty() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		//login careio portal
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		Thread.sleep(1000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);
		
		// select organization dropdown
		driver.findElement(By.id("orgDropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 1)
	public void Edit_Click()throws InterruptedException
	{
		//click on edit dropdown
		driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[1]/td[6]/section/div[2]")).click();
		//click on open in pop up option
		//driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[1]/td[6]/section/div[2]/i")).click();
	}
	@Test(priority = 2)
	public void Insert_Custom_Fields() throws InterruptedException 
	{
		//insert Institution Name
		driver.findElement(By.xpath("//input[@placeholder=\"Institution Name\"]")).sendKeys("XYZ");
		Thread.sleep(1000);
		//insert Claim number
		driver.findElement(By.xpath("//input[@placeholder=\"Claim\"]")).sendKeys("600");
		Thread.sleep(1000);
		
		
		//choose dropdown facility name
		Select se =new Select(driver.findElement(By.id("CustomFields2")));
		 se.selectByValue("Tech Health");
		 Thread.sleep(1000);
		 //choose request type
		 Select se1=new Select(driver.findElement(By.id("CustomFields3")));
		 se1.selectByValue("NAVIGERE - Quality Review");
		 Thread.sleep(1000);
		 //choose State of Jurisdiction
		 Select se2=new Select(driver.findElement(By.id("CustomFields4")));
		 se2.selectByValue("AK");
		 Thread.sleep(1000);
		 
		 
		 String month="May 2023";
		 String day="10";
		 
		 //choose Date of Injury (Test to select a desired date in the datepicker for departure)
		 driver.findElement(By.xpath("//input[@placeholder='Date of Injury']")).click();
		 Thread.sleep(1000);	
		 
		 
		 while(true)
		 {
			 String text =driver.findElement(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > thead > tr:nth-child(2) > th.datepicker-switch")).getText();//cssselector of May 2023
			 if(text.equals(month))
			 {
				 break;
			 }
			 
			 else {
				
				 driver.findElement(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > thead > tr:nth-child(2) > th.prev")).click();//cssselector of back arrow
	
			 }
		 }
		 driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr[2]/td[contains(text(),"+day+")]")).click();
		 
		
		 //insert special instruction
		 driver.findElement(By.xpath("//input[@placeholder='Special Instructions']")).sendKeys("None");
		 
		 Thread.sleep(1000);
	}
	
	@Test(priority = 3)
		 public void Attach_dignostic_Report() throws InterruptedException{
		
		driver.findElement(By.xpath("//a[@id='nav-diagnosticreportdocument-tab']")).click();//switch to dignostics report tab
	
		//click on title dropdown
		driver.findElement(By.xpath("//*[@id=\"nav-diagnosticreportdocument\"]/div/div[2]/div[1]/span/span[1]/span")).click();
		Thread.sleep(3000);
		//select one element of the list of item
		driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[4]/div/span")).click();
		Thread.sleep(3000);
		
		
		//select type dropdown
		driver.findElement(By.xpath("//*[@id=\"nav-diagnosticreportdocument\"]/div/div[2]/div[3]/span/span[1]/span/span[2]")).click();
		Thread.sleep(3000);
		//select one element of the list of item
		driver.findElement(By.xpath("//*[@data-val='34744-3']")).click();
		
		//Select category dropdown
		driver.findElement(By.xpath("//*[@id=\"nav-diagnosticreportdocument\"]/div/div[2]/div[4]/div/button/span")).click();
		Thread.sleep(3000);
		//select one element of the list of item
		WebElement elementToClick =driver.findElement(By.xpath(("//*[@id=\"nav-diagnosticreportdocument\"]/div/div[2]/div[4]/div/ul/li[7]/a/label/input")));
				elementToClick.click();
				
			driver.findElement(By.xpath("//*[@id=\"CreateImagingStudyModal\"]/div/div/div/div[1]")).click();
			Thread.sleep(3000);
				
		//insert conclusion
				driver.findElement(By.xpath("//input[@placeholder='Conclusion']")).sendKeys("Normal reports");
				Thread.sleep(3000);
		}
	
//Select Dignostics report
	@Test(priority = 4)		
	public void Browse_Report()  throws InterruptedException, AWTException
		{
			driver.findElement(By.xpath("//*[@id=\"nav-diagnosticreportdocument\"]/div/div[2]/div[8]/div")).click();
			Thread.sleep(1000);
		
		// copying File path to Clipboard
		//choose report 
		StringSelection str = new StringSelection("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Desktop\\Testings files\\PDF\\Testing Document 4");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		Thread.sleep(2000);
				    
				 // creating object of Robot class
					Robot rb = new Robot();
				    
				  //paste the folder path. 
				    // press Contol+V for pasting
				     rb.keyPress(KeyEvent.VK_CONTROL);
				     rb.keyPress(KeyEvent.VK_V);
				     Thread.sleep(2000);
				    
				    // release Contol+V for pasting
				    rb.keyRelease(KeyEvent.VK_CONTROL);
				    rb.keyRelease(KeyEvent.VK_V);
				    Thread.sleep(2000);
				 
				  //click on open button
				    // for pressing and releasing Enter
				    rb.keyPress(KeyEvent.VK_ENTER);
				    rb.keyRelease(KeyEvent.VK_ENTER);
				    Thread.sleep(1000);
		
				  //click circle +button
				    driver.findElement(By.xpath("//button[@class='uploadDocument']")).click();
				    Thread.sleep(1000);	    
		}   
//Insertion of all Document fields	    
	@Test(priority = 5)		
		public void Insert_Document_fields() throws InterruptedException {
			
		//Click on document Tab
				    driver.findElement(By.xpath("//*[@id=\"nav-documentref-tab\"]")).click();
				    Thread.sleep(1000);
		//insert attach document title
				    driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[2]/input")).sendKeys("First Document");
				    Thread.sleep(1000);
			
	 //select Type dropdown
			driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[3]/span/span[1]/span/span[2]/b")).click();
			Thread.sleep(1000);
	//select one element of the list of item
			driver.findElement(By.xpath("//*[@data-val=\"68471-2\"]")).click();
	
	//Select category dropdown
			driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[5]/div/button/span")).click();
			Thread.sleep(2000);
			
			//select one element of the list of item
			WebElement elementToClick =driver.findElement(By.xpath(("//*[@id=\"nav-documentref\"]/div/div[2]/div[5]/div/ul/li[10]/a/label/input")));
					elementToClick.click();
					
				driver.findElement(By.xpath("//*[@id=\"CreateImagingStudyModal\"]/div/div/div/div[1]")).click();
				Thread.sleep(2000);		    

	//insert Description
				driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[7]/input")).sendKeys("None");
				Thread.sleep(2000);	
				
		//	
				driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[8]/div")).click();
				Thread.sleep(1000);
				}
	
	//Select Document
	@Test(priority = 6)	
	public void Choose_Document() throws InterruptedException, Exception {
		
			driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/div[8]/div")).click();
			Thread.sleep(1000);
	
			// copying documents File path to Clipboard
			//choose report 
			StringSelection str = new StringSelection("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Desktop\\Testings files\\PDF\\business-444");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			Thread.sleep(2000);
					    
					 // creating object of Robot class
						Robot rb = new Robot();
					    
					  //paste the folder path. 
					    // press Contol+V for pasting
					     rb.keyPress(KeyEvent.VK_CONTROL);
					     rb.keyPress(KeyEvent.VK_V);
					     Thread.sleep(2000);
					    
					    // release Contol+V for pasting
					    rb.keyRelease(KeyEvent.VK_CONTROL);
					    rb.keyRelease(KeyEvent.VK_V);
					    Thread.sleep(2000);
					 
					  //click on open button
					    // for pressing and releasing Enter
					    rb.keyPress(KeyEvent.VK_ENTER);
					    rb.keyRelease(KeyEvent.VK_ENTER);
					    Thread.sleep(1000);
			
					  //click circle +button
					    driver.findElement(By.xpath("//*[@id=\"nav-documentref\"]/div/div[2]/button")).click();
					    Thread.sleep(1000);	    			
	}
//Submit Dignostic reports and document
	@Test(priority = 7)		
	public void Submit_Reports()  throws InterruptedException, AWTException
					    {
					    	driver.findElement(By.xpath("//button[@id=\"CreateStudyBtn\"]")).click();
					    }
				
	
	}

	


	



