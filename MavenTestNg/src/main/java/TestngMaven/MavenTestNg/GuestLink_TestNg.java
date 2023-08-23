package TestngMaven.MavenTestNg;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GuestLink_TestNg {
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
			//login careio portal
				driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
				driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
				driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
				driver.findElement(By.id("next")).click();
				Thread.sleep(1000);
			
				// select organization dropdown
				driver.findElement(By.id("orgDropdown")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
				Thread.sleep(1000);
	
		}
		@Test(priority = 1)
	public void click_sharedropdown() throws InterruptedException {
			// Click on share dropdown
			driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[2]/td[6]/section/div[5]")).click();
			Thread.sleep(1000);
			// Click on guest link
			driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[2]/td[6]/section/div[5]/ul/li/a")).click();
			Thread.sleep(1000);
		}
			
		@Test(priority =2)
		 public void Genrate_Guestlink() throws InterruptedException {
		 //
		 driver.findElement(By.id("EmailGuestLink")).sendKeys("jm2555113@gmail.com");
		Thread.sleep(1000);
		// enter password

		driver.findElement(By.id("Password")).sendKeys("123");
		Thread.sleep(1000);
		// Max. Uses

		driver.findElement(By.id("MaxUses")).sendKeys("10");
		Thread.sleep(1000);	
			
			// select Expires dropdown

			WebElement expire = driver.findElement(By.id("Expires"));
			Thread.sleep(1000);
			
			
			// select class object creation

				Select dropdown = new Select(expire);

				// dropdown.selectByValue("0");//Never
				// dropdown.selectByValue("60");//1 Hour
				// dropdown.selectByValue("720");//12 Hour
				// dropdown.selectByValue("1440");//1 Day
				// dropdown.selectByValue("4320");//3 Days
				// dropdown.selectByValue("10080");//1 Week
				// dropdown.selectByValue("40320");//4 Weeks
				dropdown.selectByValue("129600");// 90 Days
		
		
				// Enter Max. PW Attempts
				driver.findElement(By.id("MaxPWAttempts")).sendKeys("5");
				Thread.sleep(1000);

				// enter email.message
				driver.findElement(By.id("EmailMessage")).sendKeys("Welcome to the care io guest link");
				Thread.sleep(1000);

				// Click on Create button
				driver.findElement(By.cssSelector("#GuestLinkBtn")).click();
				Thread.sleep(1000);
		
				// print the guestlinksummary
				WebElement ele = driver.findElement(By.className("guestlinkSummary"));
				System.out.println(ele.getText());
				ele.click();
				Thread.sleep(1000);
		}
		
		
		
				// WebElement ele2 =
				// driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/textarea"));
				// System.out.println(ele2.getText());
				// ele2.click();
				// Thread.sleep(1000);
@Test()
public void Copy_link() throws InterruptedException {
				// Copy the guestlink
				Actions ac = new Actions(driver);

				WebElement copy = driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/a[1]"));
				ac.moveToElement(copy).perform();

				Thread.sleep(1000);
				
}
@Test()
public void Delete_link() throws InterruptedException {
				// Click on Delete link option
				driver.findElement(By.xpath("//*[@id=\"GuestLink\"]/div/div/div[2]/div/div/div/div/div/a[2]/i")).click();
				Thread.sleep(2000);
	
				// Handle delete popup
				Alert alert = driver.switchTo().alert();
				String alertmessage = driver.switchTo().alert().getText();
				alert.accept();
				Thread.sleep(1000);
}

@Test()
public void Guest_link_creation() throws InterruptedException {
				// click on password as DOB checkbox
				//WebElement input = driver.findElement(By.name("PasswordisDOB"));
				// boolean b=input.isSelected();
				// if(!b)
				// {
				//input.click();
				// }
				System.out.println(driver.findElement(By.name("PasswordisDOB")).isSelected());
				//Thread.sleep(4000);

				// Click on Create button
				driver.findElement(By.cssSelector("#GuestLinkBtn")).click();
				Thread.sleep(1000);

				WebElement ele2 = driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/textarea"));
				Thread.sleep(1000);
				System.out.println(ele2.getText());
				Thread.sleep(1000);
				ele2.click();
				Thread.sleep(1000);

				// close window
				driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[1]/button/span")).click();
				Thread.sleep(1000);
				
}
		
		}

		
