package careiopack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class exportcsv {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// launch chrome browser

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\msedgedriver_win64\\EdgeDriver.exe");
		WebDriver driver = new EdgeDriver();

		// launch the Chrome browser
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Gigabyte\\Documents\\Selenium\\Drivers\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		// launch the Edge browser
		// System.setProperty("webdriver.edge.driver","C:\\Users\\Gigabyte\\Documents\\Selenium\\Drivers\\msedgedriver.exe");
		// WebDriver driver=new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(20000);

		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.id("email")).sendKeys("hgaikwad@care.io");
		driver.findElement(By.id("password")).sendKeys("CareIo&#%@2023");
		driver.findElement(By.id("next")).click();
		Thread.sleep(20000);

		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]")).click();

		/*
		 * //Click on actions dropdown
		 * driver.findElement(By.id("imagingStudyActions")).click();
		 * Thread.sleep(20000);
		 * 
		 * List<WebElement>
		 * List=driver.findElements(By.id("/html/body/div[1]/main/div[4]/div[1]/div/div"
		 * ));
		 * 
		 * System.out.println("list.size"); for(int i=0;i<List.size();i++) {
		 * System.out.println("list.get(i).getText()"); }
		 * 
		 * //Click on csv driver.findElement(By.id("ExportExcelAll")).click();
		 * Thread.sleep(20000);
		 * 
		 * //Click on Export button driver.findElement(By.id("ExportExcelBtn")).click();
		 * Thread.sleep(20000);
		 * 
		 * //Handle popup when we click on export button without selecting study
		 * 
		 * Alert alert=driver.switchTo().alert(); String alertmessage
		 * =driver.switchTo().alert().getText(); alert.accept(); Thread.sleep(3000);
		 * 
		 * driver.findElement(By.xpath("//a[@class=\"btn btn-link\"]")).click();
		 * Thread.sleep(3000);
		 */

		driver.findElement(By.xpath("//*[@id=\"orgDropdown\"]/div"));

		Thread.sleep(3000);

		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[1]/td[1]/input"));
		checkbox1.click();
		Thread.sleep(3000);

		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[2]/td[1]/input"));
		checkbox2.click();
		Thread.sleep(2000);

		WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"StudyList\"]/tbody/tr[3]/td[1]/input"));
		checkbox3.click();

		Thread.sleep(2000);

		// uncheck checkbox
		checkbox1.click();
		Thread.sleep(2000);

		checkbox2.click();
		Thread.sleep(2000);

		checkbox3.click();
		Thread.sleep(2000);

		// validation
		// isDisplayed-if the element is displayed
		// isSelected-if the element is selected
		// isEnabled-if the element is enabled

		// isDisplayed
		boolean bool1 = checkbox1.isDisplayed();
		System.out.println(bool1);
		if (bool1 == true) {
			checkbox1.click();

		}

		// isSelected
		boolean bool2 = checkbox2.isSelected();
		System.out.println(false);
		if (bool2 == false) {
			checkbox2.click();
		}

		// isEnabled
		Boolean bool3 = checkbox3.isEnabled();
		System.out.println(true);
		if (bool3 == true) {
			checkbox3.click();

		}
		// click on Action dropdown
		driver.findElement(By.id("imagingStudyActions")).click();
		Thread.sleep(20000);

		// Click on csv
		driver.findElement(By.id("ExportExcelAll")).click();
		Thread.sleep(20000);

		// Click on Export button
		driver.findElement(By.xpath("//*[@id=\"ExportExcelBtn\"]")).click();
		Thread.sleep(20000);

		String path = ("C:\\Users\\Gigabyte\\Desktop\\Excel_Report5.csv");
		String line = "";
		BufferedReader reader = null;
		// going to get entire file information and storibg them into br
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");

				// "%-15s" means that within 15 blank space, the String "s1" will be filled in
				// the left. (fill in the blanks from the left) "%03d" means that within 3 0s,
				// the integer"x" will be filled in the right.(fill in the zeros from the
				// right).

				for (String index : row) {
					System.out.printf("%-15s", index);
				}
				System.out.println();

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} finally {
			reader.close();

		}

	}
}