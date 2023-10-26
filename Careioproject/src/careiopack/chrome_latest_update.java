package careiopack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome_latest_update {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");

		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("edge://settings/help");
		
		

		
		

	}

}
