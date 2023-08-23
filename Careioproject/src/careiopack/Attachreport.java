package careiopack;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Attachreport {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// launch the Chrome browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");

	
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

		// select organization dropdown
		driver.findElement(By.id("orgDropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div/a[2]")).click();
		Thread.sleep(3000);

		// click on report dropdown
		driver.findElement(By.xpath("//tbody/tr[3]/td[6]/section[1]/div[3]/a[1]/i[1]/span[1]")).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.scrollByAmount(0, 2000).perform();

		Thread.sleep(3000);
		actions.scrollByAmount(0, 3000).perform();

		Thread.sleep(3000);

		//actions.scrollByAmount(0, -2000).perform();

		// click on report button
		driver.findElement(By.xpath("//a[@class='btn btn-primary ml-2 mb-1 add-reports']")).click();
		Thread.sleep(2000);
		
		actions.scrollByAmount(0, 3000).perform();
		driver.findElement(By.id("reportsTemplates")).click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	    
		Thread.sleep(1000);
		actions.scrollByAmount(0, -2000).perform();
		//identify input text and input text inside it
		WebElement p = driver.findElement(By.cssSelector("#ViewReportModal > div > div > div.modal-body.p-2.pt-0 > div.col-12.ViewreportsModal > div.row > div:nth-child(1) > div.row.multipleCompoentOtion > div:nth-child(1) > div > div.Editor-editor"));
		p.sendKeys("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
		Thread.sleep(1000);
		
		WebElement c = driver.findElement(By.cssSelector("#ViewReportModal > div > div > div.modal-body.p-2.pt-0 > div.col-12.ViewreportsModal > div.row > div:nth-child(1) > div.row.multipleCompoentOtion > div:nth-child(2) > div > div.Editor-editor"));
		c.sendKeys("\"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.");
		Thread.sleep(1000);
	
		WebElement t = driver.findElement(By.cssSelector("#ViewReportModal > div > div > div.modal-body.p-2.pt-0 > div.col-12.ViewreportsModal > div.row > div:nth-child(1) > div.row.multipleCompoentOtion > div:nth-child(3) > div > div.Editor-editor"));
		t.sendKeys("\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?");
		Thread.sleep(1000);
		driver.findElement(By.id("submitReport")).click();
		Thread.sleep(1000);
	}
}