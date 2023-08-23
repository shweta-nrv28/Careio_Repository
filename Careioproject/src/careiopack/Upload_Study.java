package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;


public class Upload_Study {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Set chrome driver path
		System.setProperty("webdriver.edge.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\edgedriver_win64\\edgedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//login the application
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);

		//click on org dropdown
		driver.findElement(By.id("orgDropdown")).click();
		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
		Thread.sleep(1000);
	
		//click on upload doc button
		driver.findElement(By.id("UploadDoc")).click();
		Thread.sleep(1000);
	
		//click on browse button	
		driver.findElement(By.id("browse")).click();
		Thread.sleep(1000);
		
		
		// creating object of Robot class
			Robot rb = new Robot();
	 
	    // copying File path to Clipboard
		//select studyfolder to upload
	    StringSelection str = new StringSelection("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Desktop\\selenium_study\\CR-4-Patient Judi00");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    
	    Thread.sleep(1000);
	     //paste the folder path. 
	    // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	     Thread.sleep(1000);
	    
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(1000);
	 
	    //click on upload button
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);

	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	    
	    //after getting popup press keyboard left arrow.
	    rb.keyPress(KeyEvent.VK_ALT);
	    rb.keyPress(KeyEvent.VK_LEFT);
	    rb.keyRelease(KeyEvent.VK_LEFT); 
	    rb.keyRelease(KeyEvent.VK_ALT);
	    Thread.sleep(1000);
	
	    
	    //Click on upload button
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	
	    //click on upload studies button
	    driver.findElement(By.xpath("//span[@class='uploadTypeButton']")).click();
	    Thread.sleep(1000);
	
	
	}
	

}