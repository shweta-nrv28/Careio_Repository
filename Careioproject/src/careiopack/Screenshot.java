package careiopack;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableStringConverter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hdf.extractor.NewOleFile;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.io.Files;



public class Screenshot {

	private static final String True = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		    
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		

		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
	
		takesScreenshot("careio logo");
	
		
	}

		public static void takesScreenshot(String FileName) throws IOException {
			TakesScreenshot driver = null;
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Careioproject\\src\\careiopack" +FileName+".jpg"));
			
		
		}
		///html/body/div[1]
		//locate the element
		//driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/a/img"));
		//Thread.sleep(1000);
		
		
        //closing the webdriver
       // driver.close();

		}
	

       



