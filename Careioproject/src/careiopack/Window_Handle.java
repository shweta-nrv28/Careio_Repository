package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Window_Handle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(20000);

		// tab navigation
		String oldTab = driver.getWindowHandle();
		driver.findElement(By.linkText("Dropbox")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Imaging Studies")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Orders")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Patients")).click();
		Thread.sleep(10000);
		driver.findElement(By.linkText("Administration")).click();
		Thread.sleep(10000);

	}

}
