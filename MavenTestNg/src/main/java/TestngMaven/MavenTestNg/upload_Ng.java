package TestngMaven.MavenTestNg;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class upload_Ng {
		WebDriver driver;
	
@BeforeTest//it will excuted before the testcase

			//setup browser
			public void Setup() throws InterruptedException {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				
				driver = new ChromeDriver(options);
				ChromeDriver driver = new ChromeDriver(options);
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
				driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
}	
		@Test()
		public void login() throws InterruptedException {
				
				//lunch URL and login careio portal
				driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		
				driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
				driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
				Thread.sleep(1000);
				driver.findElement(By.id("next")).click();
				Thread.sleep(3000);
				
				//click on org dropdown
				driver.findElement(By.id("orgDropdown")).click();
				driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
				Thread.sleep(1000);
			}
			
			@Test(priority = 1)
			public void verifyPageTitle() throws InterruptedException {
				String title = driver.getTitle();
			    System.out.println("the page title is:" +title);
			  org.testng.Assert.assertEquals(title,"#Imaging Studies" );
			  Thread.sleep(10000);
			}
			
			@Test(priority = 2)
			public void uploadbuttonclick()throws InterruptedException{
				//click on upload button
				WebElement button=driver.findElement(By.id("UploadDoc"));
				button.click();
				Thread.sleep(1000);
			}
			@Test(priority = 3)
			public void choosefile() throws InterruptedException {
				
				//click on choose file
				driver.findElement(By.id("browse")).click();
				Thread.sleep(2000);
			}
			
				@AfterClass//it will used for close browser
				public void CloseBrowser() {
					System.out.println("Close Browser");
					driver.quit();
				}
}			


