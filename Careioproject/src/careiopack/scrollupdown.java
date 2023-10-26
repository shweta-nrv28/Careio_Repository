package careiopack;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;

import javax.swing.AbstractAction;
import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class scrollupdown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://app.care.io/ImagingStudy");

		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 2000).perform();

		Thread.sleep(3000);
		actions.scrollByAmount(0, 3000).perform();

		Thread.sleep(3000);

		actions.scrollByAmount(0, -2000).perform();

		// JavascriptExecutor js =(JavascriptExecutor)driver;
		// WebElement
		// m=driver.findElement(By.linkText("dI%2FNTsJAFEbf5euSYobBUrwJC35K6OKKlAnREBbEjthiW2ynUAv1xVz4SL6CMaw9q7M85%2Bfr%2Bygv6zOes%2BSQFZHRKtvrFHSGuQpagT%2Bhz2C1k0Oey%2FmyPbs7ecMrg4EVKJKWCsYkhRWoCR0fT173EPdvJ%2B%2FxQzi7D5QIR4orrhclK7%2Fk%2BHXFMbtcey7XfOT6yWHlVbw8VayKihfDgeUvVyQt35tTz3F6rrUYT6kPG%2Fk23em%2FuCRKQYCNZFuBMJ2iaWxkeajz0YdvdFKA1mdERicgSCG7bdFpd1zVkSQFSXkjnb4QQrSEICHQbGzkUQjCf6OwUeyjwzgrUwMSNl6iN6NzEExeajSbXwAAAP%2F%2F"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", m);
		// Thread.sleep(3000);

		// System.out.println("failed");

		// js.executeScript("window.scroll(2000,0)","");
		// js.executeScript("scroll(0.-700)","");
		// js.executeScript("scroll(0,document.body.scrollheight)");

		// scroll to at the end of the element

		// WebElement
		// nextpag=driver.findElement(By.cssSelector("//*[@id="nextRecords"]"));
		// Thread.sleep(3000);
		// js.executeScript("argument[0].scrollIntoview(true);",nextpag);

	}

}
