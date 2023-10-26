package careiopack;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GuestLink{

	WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * public void OpenBrowser(String Browser) {
		 * if(Browser.equalsIgnoreCase("firefox browser")) {
		 * System.out.println("....firefox Browser....Testing is started..."); File
		 * file=new File("C:\\CareIO data\\Selenium\\Drivers\\geckodriver.exe");
		 * System.setProperty("webdriver.gecko.driver",file.getAbsolutePath());
		 * FirefoxDriver driver = new FirefoxDriver();
		 * System.out.println("Mozila firefox browser is open");
		 * 
		 * } if(Browser.equalsIgnoreCase("chrome Browser")) {
		 * System.out.println("....chrome Browser....Testing is started..."); File
		 * file1=new File("C:\\CareIO data\\Selenium\\Drivers\\chromedriver.exe");
		 * System.setProperty("webdriver.gecko.driver",file1.getAbsolutePath());
		 * driver=new ChromeDriver();
		 * System.out.println("Mozila firefox browser is open"); }
		 * if(Browser.equalsIgnoreCase("edge Browser")) {
		 * System.out.println("....Edge Browser....Testing is started..."); File
		 * file2=new File("C:\\CareIO data\\Selenium\\Drivers\\msedgedriver.exe");
		 * System.setProperty("webdriver.gecko.driver",file2.getAbsolutePath());
		 * driver=new EdgeDriver(); System.out.println("Edge browser is open");
		 * 
		 * } driver.manage().window().maximize(); System.out.println(Browser+
		 * "Browser is maximized");
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
		 */
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\git\\repository3\\Careioproject\\drivers\\chrome\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");

		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(10000);

		driver.findElement(By.id("orgDropdown")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[7]")).click();
		Thread.sleep(100);

		// Share Guest link

		// Click on share dropdown

		driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[1]/td[6]/section/div[5]/a/div/span")).click();
		Thread.sleep(20000);
		// Click on guest link

		driver.findElement(By.xpath("/html/body/div[1]/main/div[5]/table/tbody/tr[1]/td[6]/section/div[5]/ul/li[1]/a")).click();

		Thread.sleep(20000);
		// Enter email

		driver.findElement(By.id("EmailGuestLink")).sendKeys("jm2555113@gmail.com");
		Thread.sleep(20000);
		// enter password

		driver.findElement(By.id("Password")).sendKeys("123");
		Thread.sleep(20000);
		// Max. Uses

		driver.findElement(By.id("MaxUses")).sendKeys("10");
		Thread.sleep(20000);

		// select Expires dropdown

		WebElement expire = driver.findElement(By.id("Expires"));
		Thread.sleep(20000);

		// select class object creation

		Select dropdown = new Select(expire);

		// dropdown.selectByValue("0");//Never
		// dropdown.selectByValue("60");//1 Hour
		// dropdown.selectByValue("720");//12 Hour
		// dropdown.selectByValue("1440");//1 Day
		// dropdown.selectByValue("4320");//3 Days
		// dropdown.selectByValue("10080");//1 Week
		// dropdown.selectByValue("40320");//4 Weeks
		dropdown.selectByValue("129600");// 90 Days

		// Enter Max. PW Attempts
		driver.findElement(By.id("MaxPWAttempts")).sendKeys("5");
		Thread.sleep(1000);

		// enter email.message
		driver.findElement(By.id("EmailMessage")).sendKeys("Welcome to the care io guest link");
		Thread.sleep(1000);

		// Click on Create button
		driver.findElement(By.cssSelector("#GuestLinkBtn")).click();
		Thread.sleep(1000);

		// print the guestlinksummary
		WebElement ele = driver.findElement(By.className("guestlinkSummary"));
		System.out.println(ele.getText());
		ele.click();
		Thread.sleep(1000);

		// WebElement ele2 =
		// driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/textarea"));
		// System.out.println(ele2.getText());
		// ele2.click();
		// Thread.sleep(1000);

		// Copy the link
		Actions ac = new Actions(driver);

		WebElement copy = driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/a[1]"));

		ac.moveToElement(copy).perform();

		Thread.sleep(1000);

		// Click on Delete link option
		driver.findElement(By.cssSelector(".deleteLink")).click();
		Thread.sleep(1000);

		// Handle delete popup
		Alert alert = driver.switchTo().alert();
		String alertmessage = driver.switchTo().alert().getText();
		alert.accept();
		Thread.sleep(1000);

		// click on password as DOB checkbox
		WebElement input = driver.findElement(By.name("PasswordisDOB"));
		// boolean b=input.isSelected();
		// if(!b)
		// {
		input.click();
		// }
		System.out.println(driver.findElement(By.name("PasswordisDOB")).isSelected());
		Thread.sleep(1000);

		// Click on Create button
		driver.findElement(By.cssSelector("#GuestLinkBtn")).click();
		Thread.sleep(1000);

		WebElement ele2 = driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[2]/div/div/div/div/div/textarea"));
		Thread.sleep(1000);
		System.out.println(ele2.getText());
		Thread.sleep(1000);
		ele2.click();
		Thread.sleep(1000);

		// close window
		driver.findElement(By.xpath("/html/body/div[1]/main/div[8]/div/div/div[1]/button/span")).click();
		Thread.sleep(1000);

	}

}