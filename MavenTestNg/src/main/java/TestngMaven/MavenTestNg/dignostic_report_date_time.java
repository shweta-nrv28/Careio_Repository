package TestngMaven.MavenTestNg;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class dignostic_report_date_time {
	WebDriver driver;
	@Test(priority=1)
	public void setproperty() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");

		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		Thread.sleep(1000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);
		
		//click on org dropdown
		//driver.findElement(By.id("orgDropdown")).click();
		//driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[1]")).click();
		//Thread.sleep(1000);
	
	}
	
	@Test(priority=2)
	public void abc()throws InterruptedException {
		
		//click on org dropdown
				driver.findElement(By.id("orgDropdown")).click();
				driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
				Thread.sleep(1000);
				
				//
				String beforexpath ="//*[@id=\"StudyList\"]/tbody/tr[";
				String afterXpath ="]/td[5]";
			
			for(int i=1; i<=10; i++)
			
			{
				String actualxpath = beforexpath+i+afterXpath;
				WebElement element=driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
			Thread.sleep(1000);
			}
				

	
	}
	
		
	}
	 

