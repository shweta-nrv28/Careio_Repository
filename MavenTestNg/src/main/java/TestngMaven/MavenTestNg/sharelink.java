package TestngMaven.MavenTestNg;

import java.security.PublicKey;
import java.time.Duration;

import javax.swing.Popup;

import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sharelink {
	WebDriver driver;
	
@BeforeTest
//setup the browser_properties
	public void Setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
	}
//login careio portal page
	@Test(priority = 1)
		public void login_Careio_portal() throws InterruptedException {
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(100);
		
		// select organization dropdown
				driver.findElement(By.id("orgDropdown")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
				Thread.sleep(1000);
	}
//click on administration and sharetab	
@Test(priority = 2)
	public void click_sharelink() throws InterruptedException {
		// click on administration tab
				driver.findElement(By.xpath("//*[@class='nav-item patientAdministration']")).click();
				Thread.sleep(1000);

				// click on sharetab
				driver.findElement(By.id("ShareTab")).click();
				Thread.sleep(1000);
	}
//Generate the sharelink/upload link
@Test(priority = 3)
	 public void Generateguestlink() throws InterruptedException {
		// enter guestfirstname
				driver.findElement(By.name("GuestFirstName")).sendKeys("john");
				Thread.sleep(1000);

				// enter Guestlastname
				driver.findElement(By.id("GuestLastName")).sendKeys("martin");
				Thread.sleep(2000);

				// enter guestphonenumber
				driver.findElement(By.id("GuestPhoneNumber")).sendKeys("88298345678");
				Thread.sleep(1000);

				// enter email
				driver.findElement(By.id("EmailGuestLinkUpload")).sendKeys("jm2555113@gmail.com");
				Thread.sleep(1000);

				// enter password
				driver.findElement(By.id("PasswordUpload")).sendKeys("jm@20");
				Thread.sleep(1000);

				// click on create button
				driver.findElement(By.id("UploadLinkBtn")).click();
				Thread.sleep(1000);
		}
//copy & Delete the generated sharelink/uploadlink
	@Test(priority = 4)
		 
			public void Copy_Link()throws InterruptedException {
			//copy created link
			driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div/div[1]/a[1]")).click();
			Thread.sleep(20000);

			// Click Delete Button
			driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div[2]/div/div/div[1]/a[2]/i")).click();
			Thread.sleep(1000);
		}	
//Handle Delete popup	
	@Test(priority = 5)
			public void handle_Popup()throws InterruptedException {
	
			// Handle delete popup
			Alert alert = driver.switchTo().alert();
			String alertmessage = driver.switchTo().alert().getText();
			alert.accept();
			Thread.sleep(3000);

			}

		
				
}		
				





