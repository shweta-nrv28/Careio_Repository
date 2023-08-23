package TestngMaven.MavenTestNg;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class update_browser_parellel {

WebDriver driver;
	
@Parameters("BrowserName")	
@Test

	public void setup(String browserName) throws Exception {
		System.out.println("Browser name is :  +chrome +firefox +Edge");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
			driver.get("chrome://settings/help");
			Thread.sleep(20000);
		}
		else if(browserName.equalsIgnoreCase("msedge")) {
			
			System.setProperty("webdriver.msedge.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
			EdgeOptions Options = new EdgeOptions();
			Options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(Options);
			//Options.addArguments("--start-maximized");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
			
			driver.get("edge://settings/help");
			Thread.sleep(20000);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Careioproject\\drivers\\gecko\\geckodriver.exe");			
				FirefoxOptions Options = new FirefoxOptions();
				Options.addArguments("--remote-allow-origins=*");
				driver = new FirefoxDriver();
				FirefoxOptions options = new FirefoxOptions();
				driver = new FirefoxDriver(options);
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
			
				driver.get("about:preferences");
				
				Actions actions = new Actions(driver);
				actions.scrollByAmount(0, 1000).perform();
				Thread.sleep(20000);
				actions.scrollByAmount(0, -1000).perform();
				

				driver.findElement(By.cssSelector("#checkForUpdatesButton3")).click();
				Thread.sleep(20000);
				driver.findElement(By.cssSelector("#noUpdatesFound > label:nth-child(1)")).getText();
				Thread.sleep(20000);
			}
		
		}
	
		@AfterTest
		public void teardown() {
			//driver.close();
			System.out.println("Browser updated successfully");
}

}