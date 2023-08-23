package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class Search_patient {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		// TODO Auto-generated method stub
		// launch the Mozila firefox browser

		// System.setProperty("webdriver.gecko.driver","C:\\CareIO
		// data\\Selenium\\Drivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();

		// launch the Mozila Chrome browser
		// System.setProperty("webdriver.chrome.driver","C:\\CareIO
		// data\\Selenium\\Drivers\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		{
			// launch the Edge browser
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Careioproject\\drivers\\gecko\\geckodriver.exe");			
			
		    WebDriver driver1  = new FirefoxDriver();
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe");			
			FirefoxOptions Options = new FirefoxOptions();
			Options.addArguments("--remote-allow-origins=*");
			driver1 = new FirefoxDriver();
			
			driver1.get("about:preferences");
			
			//FirefoxOptions options = new FirefoxOptions();
		      //driver1 = new FirefoxDriver(options);
			
			/*System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Careioproject\\drivers\\chrome\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver1 = new ChromeDriver(options);

*/
			driver1.manage().window().maximize();

			// driver.manage().window().fullscreen();

			driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Open CareIO Portal
			//driver1.get("https://webapp-careio-useast2-dev.azurewebsites.net");
			driver1.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
			driver1.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
			driver1.findElement(By.id("next")).click();
			Thread.sleep(20000);

			// select organization dropdown
			driver1.findElement(By.id("orgDropdown")).click();
			Thread.sleep(1000);
			driver1.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
			Thread.sleep(20000);

			// Search patient by using name
			driver1.findElement(By.xpath("//*[@id=\"SearchPatient\"]")).sendKeys("SHAH");
			Thread.sleep(10000);

			driver1.findElement(By.id("SearchBtn")).click();
			Thread.sleep(10000);

			driver1.findElement(By.xpath("//*[@id=\"clearSearchBtn\"]/i")).click();
			Thread.sleep(40000);
			driver1.findElement(By.xpath("/html/body/div[1]/main/div[4]/div[4]/div/div/div/div[1]/button[1]/i "))
					.click();
			driver1.findElement(By.xpath("/html/body/div[1]/main/div[4]/div[4]/div/div/div/div[1]/input"))
					.sendKeys("DAMETRIS ");
			Thread.sleep(20000);
			driver1.findElement(By.id("SearchBtn")).click();
			Thread.sleep(20000);
			driver1.findElement(By.cssSelector(
					"#StudyList > tbody > tr:nth-child(1) > td.row-actions.study > section > div.btn-group.icn-position > i"))
					.click();
			Thread.sleep(10000);

			// click on advanced filter option
			driver1.findElement(By.xpath("/html/body/div[1]/main/div[4]/div[4]/div/div/a/span")).click();
			Thread.sleep(10000);

			// search patient by using DOB
			driver1.findElement(By.id("AdvanceSearchField3")).sendKeys("1988-06-11");
			Thread.sleep(20000);
			driver1.findElement(By.id("advancedSearchBtn")).click();
			Thread.sleep(20000);
		}

	}
}
