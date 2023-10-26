package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImagingStudy_count {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// login website
		driver.get("https://app.care.io/");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(20000);

		// select organization dropdown
		driver.findElement(By.id("orgDropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[7]")).click();
		Thread.sleep(20000);

		// search patient
		driver.findElement(By.xpath("/html/body/div[1]/main/div[4]/div[4]/div/div/div/div[1]/input")).sendKeys("JEAN");
		Thread.sleep(10000);
		driver.findElement(By.id("SearchBtn")).click();
		Thread.sleep(20000);

		// get imagecount to span class.
		driver.findElement(
		By.cssSelector("#StudyList > tbody > tr > td.row-actions.study > section > div:nth-child(2) > i")).click();
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.className("countnotemp"));
		System.out.println(ele.getText());
		ele.click();
		driver.quit();
		Thread.sleep(10000);

	}

}