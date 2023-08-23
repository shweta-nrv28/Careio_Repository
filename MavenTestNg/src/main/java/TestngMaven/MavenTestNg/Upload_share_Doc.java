package TestngMaven.MavenTestNg;

import java.io.Closeable;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Upload_share_Doc {
	WebDriver driver;
	

	@BeforeMethod//it will excuted before every testcase.
	public void Setup()throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver1 = new ChromeDriver(options);

		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver1.manage().window().maximize();
		
		driver1.manage().deleteAllCookies();
		
		driver1.get("https://webapp-inbox-eastus2-dev.azurewebsites.net/uploadlink/bGlua0lkPWE2YTc0ODNmLTVkZjEtNGJmZS1hNWJlLTkwZDIzYTI5OGIwZSZvcmdJZD1kZDAyY2VhNS0wZWUwLTRiZmEtODA0OC1jM2RjNTI4ZGU3NWY=");
	}
		@Test(priority=0)
		public void Enter_password() throws Exception {
			
			System.out.println("driver="+driver);
			driver.findElement(By.id("password")).sendKeys("23");
			Thread.sleep(1000);
			driver.findElement(By.id("uploadBtn")).click();
			Thread.sleep(3000);
		}
		
@AfterClass
	
		public void quit()
	    {
	        driver.manage().deleteAllCookies();
	        driver.quit();
	    }

	    
	    }

		
			
	