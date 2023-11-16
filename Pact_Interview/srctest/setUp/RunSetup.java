package setUp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import webPages.ElementsInHomePage;
import webPages.Login;

public class RunSetup {
	WebDriver driver;
	ElementsInHomePage elementinhomepage;
	Login login;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
	//	System.setProperty("webdriver.chrome.driver", "D:\\maven automation programs\\Pact_Interview\\src\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://subscription.packtpub.com/");
		driver.manage().window().maximize();
		
		}
	@Test(priority = 1)
	public void loginIntoApplication() {
		login = new Login(driver);
		login.signInlink();	
		login.enterUsername("akshaykumars628191@gmail.com");	
		login.enterPassword("paPA123$");		
		login.clickLogin();
	}
	
	@Test(priority = 2)
	public void verifyElementsInPage() {
		elementinhomepage = new ElementsInHomePage(driver);
		elementinhomepage.verifyElement();				
	}
	@AfterTest
	public void close() {
		driver.quit();
		
		}
	
	
}
