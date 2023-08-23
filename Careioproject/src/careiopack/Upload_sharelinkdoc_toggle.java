package careiopack;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Upload_sharelinkdoc_toggle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("disable-infobars");
		//this will we used for customizing the Chromedriver session 
		options.addArguments("--remote-allow-origins=*");
		
		//Create an object of chromedriver
		ChromeDriver driver1 = new ChromeDriver(options);
		
		// Delay for specified amount of time to load page. 
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
	
		// Maximize browser window. 	
		driver1.manage().window().maximize();
		
		driver1.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		//Launch the chromedriver and URL
		driver1.get("https://webapp-inbox-eastus2-dev.azurewebsites.net/uploadlink/bGlua0lkPWE2YTc0ODNmLTVkZjEtNGJmZS1hNWJlLTkwZDIzYTI5OGIwZSZvcmdJZD1kZDAyY2VhNS0wZWUwLTRiZmEtODA0OC1jM2RjNTI4ZGU3NWY=");
		Thread.sleep(3000);
		
		driver1.findElement(By.id("password")).sendKeys("23");

		Thread.sleep(1000);
		driver1.findElement(By.id("uploadBtn")).click();
		Thread.sleep(3000);
		
		//driver1.findElement(By.cssSelector("body > div.container-fluid.bodycontent > main > div.row > div.col-md-8 > div:nth-child(1) > div > div > span")).click();
		//Thread.sleep(3000);
		
		//WebElement checkbox = driver1.findElement(By.cssSelector("#uploadTypeToggle"));
		//checkbox.click();
		//Thread.sleep(3000);
	

		//Click on first(Studies) Radio button element
		
		WebElement RadioButton1 = driver1.findElement(By.cssSelector("body > div.container-fluid.bodycontent > main > div.row > div.col-md-8 > div:nth-child(1) > div > div > label.option.option-2"));
		RadioButton1.click();
		Thread.sleep(1000);
		
		//RadioButton1.isEnabled();
		//RadioButton1.isDisplayed();
		//RadioButton1.isSelected();
		
		Thread.sleep(1000);
		
	//Click on Second(Documents)radio button
		
		WebElement Radiobutton2 = driver1.findElement(By.cssSelector("body > div.container-fluid.bodycontent > main > div.row > div.col-md-8 > div:nth-child(1) > div > div > label.option.option-1.ml-0 > div"));
		Radiobutton2.click();
		Thread.sleep(1000);
		//Radiobutton2.isDisplayed();
		//Radiobutton2.isEnabled();
		//Radiobutton2.isDisplayed();
		//Radiobutton2.isSelected();
		
		//Browse folder
		driver1.findElement(By.id("browse")).click();
		// creating object of Robot class
					Robot rb = new Robot();
			 
			    // copying File path to Clipboard
				//select studyfolder to upload
			    StringSelection str = new StringSelection("D:\\Toggle_share\\");
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
			    Thread.sleep(2000);
			 
			    //click on upload button
			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);
			    Thread.sleep(2000);

			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);
			    Thread.sleep(2000);
			    
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
			    driver1.findElement(By.xpath("//span[@class='uploadTypeButton']")).click();
			    Thread.sleep(1000);
			
			    //Click on edit button(edit fistname and lastname)
			    driver1.findElement(By.xpath("//i[@class=\"edit-appt-icn\"]")).click();
			    Thread.sleep(1000);
			    
			    driver1.findElement(By.id("FirstName")).sendKeys("Henry");
			    Thread.sleep(1000);
			    driver1.findElement(By.id("LastName")).sendKeys("jack");
			    Thread.sleep(1000);
			    
			    
			    //click on clear fields button
			    driver1.findElement(By.id("ClearFields")).click();
			    Thread.sleep(1000);
			    
			    
	
	
	
	}

	
	}
	
	

	


/* #Check the status of toggle button whether its enabled or disabled.
${BG}   Get WebElement     xpath=(//span[@class="slider round"])[3]
${bg color}    Call Method    ${BG}    value_of_css_property    background-color
Run Keyword If    '${bg color}' == 'rgba(204, 204, 204, 1)'
...   Click Element     xpath=(//span[@class="slider round"])[3]
...   ELSE
...   Click Element    xpath=//*[@id="app"]/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[2]/a

*/