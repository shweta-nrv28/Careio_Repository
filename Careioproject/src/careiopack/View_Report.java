package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class View_Report {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// driver.manage().window().maximize();
		driver.manage().window().fullscreen();

		driver.get("https://app.care.io");

		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(20000);

		// click on report tab
		driver.findElement(By.linkText("Reports")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("AddReport")).click();
		Thread.sleep(20000);

		// click on close option
		driver.findElement(By.xpath("//*[@id =\"AddReportModal\"]/div/div/div[1]/div[1]/button/span")).click();
		Thread.sleep(2000);

		// click on view report option
		driver.findElement(By.xpath("//*[@id=\"ReportList\"]/tbody/tr[1]/td[9]/section/div[3]/i")).click();

		Thread.sleep(2000);

		// click on view PDF option
		driver.findElement(By.xpath("//*[@id=\"ViewReportModal\"]/div/div/div[1]/a/i")).click();
		Thread.sleep(2000);

		// download the PDF
		driver.findElement(By.className("toolbarButton download hiddenMediumView")).click();
		Thread.sleep(2000);

		driver.findElement(
				By.cssSelector("#ViewReportModal > div > div > div.modal-header.border-bottom-0.pb-0 > button > span"))
				.click();
		Thread.sleep(2000);

	}

}