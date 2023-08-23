package TestngMaven.MavenTestNg;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.target.model.SessionID;
import org.openqa.selenium.remote.http.Message;
import org.testng.annotations.BeforeTest;

public class forgot2FA {

		private static final String Flags = null;
		WebDriver driver;
		
		@BeforeTest()
		void login() throws Exception{
			
		System.setProperty("webdriver.chrome.driver","webdriver.chrome.driver\",\"C:\\Users\\ShwetaGadhave\\OneDrive - Care IO, Inc\\Sweta\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://webapp-careio-useast2-dev.azurewebsites.net");
		driver.findElement(By.xpath("//*[@id='forgotPassword']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sgadhave@care.io");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"emailVerificationControl_but_send_code\"]")).click();
		Thread.sleep(10000);
		}
		
		@Test(priority=1)
	public String OutlookMailReader(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP) {
				
			//mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP),
			//emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
			            String hostName = "";//change it according to your mail

			            String username = "****@***.com";//username 

			            String password = "*******";

			            int messageCount;

			            int unreadMsgCount;

			            String emailSubject;

			            Message emailMessage;

			            String searchText=null ;

			            Properties sysProps = System.getProperties();

			            sysProps.setProperty("mail.store.protocol", "imaps");

			            try {

			                Session session = Session.getInstance(sysProps, null);

			                Store store = session.getStore();

			                store.connect(hostName, username, password);

			                Folder emailBox = store.getFolder(mailFolderName);

			                emailBox.open(Folder.READ_WRITE);

			                messageCount = emailBox.getMessageCount();

			                System.out.println("Total Message Count: " + messageCount);

			                unreadMsgCount = emailBox.getNewMessageCount();

			                System.out.println("Unread Emails count:" + unreadMsgCount);

			                for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)

			                {

			                    emailMessage = emailBox.getMessage(i);

			                    emailSubject = emailMessage.getSubject();

			                    if(emailSubject.contains(emailSubjectContent))

			                    {

			                        System.out.println("OTP mail found");

			                        String line;

			                        StringBuffer buffer = new StringBuffer();

			                        BufferedReader reader = new BufferedReader(new InputStreamReader(((Object) emailMessage).getInputStream()));

			                        while ((line = reader.readLine()) != null) {

			                            buffer.append(line);

			                        }

			                        String messageContent=emailContent;

			                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));

			                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);

			                        System.out.println("Text found : "+ searchText);

			                        emailMessage.setFlag(Flags.Flag.SEEN, true);

			                        break;

			                    }

			                    emailMessage.setFlag(Flags.Flag.SEEN, true);

			                }

			                emailBox.close(true);

			                store.close();


			            } catch (Exception mex) {

			                mex.printStackTrace();

			                System.out.println("OTP Not found ");

			            }

			            return searchText;

			        }
		
		
		
		
	}
	


