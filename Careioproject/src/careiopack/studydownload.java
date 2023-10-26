package careiopack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.asynchttpclient.netty.ws.NettyWebSocket;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class studydownload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// get the URL
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		Thread.sleep(1000);
		// Sign page
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		Thread.sleep(1000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(3000);

		// click on org dropdown
		driver.findElement(By.id("orgDropdown")).click();
		Thread.sleep(1000);

		WebElement abc = driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]"));
		abc.click();
		Thread.sleep(1000);

		// click on upload button
		WebElement button = driver.findElement(By.id("UploadDoc"));
		button.click();
		Thread.sleep(1000);

		// click on choose file
		driver.findElement(By.id("browse")).click();
		Thread.sleep(2000);

		// This method will set any parameter string to the system's clipboard.

		// StringSelection str = new StringSelection("C:\\Users\\ShwetaGadhave\\OneDrive
		// - Care IO, Inc\\Desktop\\selenium upload files\\CR-4-Patient Judi00\\66445122
		// XR Cerv Spine CompObliq FlexExt 4 plus views\\CR CSPINE AP");
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		// WebElement fileInput = driver.findElement(By.name("uploadfile"));
		// fileInput.sendKeys("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO,
		// Inc\\Desktop\\selenium upload files\\CR-4-Patient Judi00\\66445122 XR Cerv
		// Spine CompObliq FlexExt 4 plus views\\CR CSPINE AP");
		// Thread.sleep(1000);

		// Store the path of the file to be uploaded using stringSelection class object
		StringSelection filepath = new StringSelection("C:\\DR-2-PATIENT CRAWLEY\\DR-2-PATIENT CRAWLEY");

		// copy path to the clipboard
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(filepath, null);
		Thread.sleep(1000);

		// releasing enter
		Robot robot = new Robot();

		// pressing ctrl+v
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// releasing ctrl+v
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(3000);

		// pressing enter
		robot.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(3000);

		// robot.keyPress(KeyEvent.VK_LEFT);
		// robot.keyRelease(KeyEvent.VK_KP_LEFT);
		// robot.setAutoDelay(1000);

		// pressing enter
		// robot.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		// robot.keyRelease(KeyEvent.VK_ENTER);

		// pressing enter
		// robot.keyPress(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);
		// releasing enter
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// Thread.sleep(1000);

	}

}