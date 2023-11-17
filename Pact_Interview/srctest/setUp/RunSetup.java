package setUp;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import webPages.BrowseandSearchBar;
import webPages.CarouselmatchwithMainTitle;
import webPages.ElementsInHomePage;
import webPages.Login;
import webPages.NavigationBar;

public class RunSetup {
	WebDriver driver;

	ElementsInHomePage elementinhomepage;
	Login login;
	NavigationBar navbar;
	CarouselmatchwithMainTitle carousel;
	BrowseandSearchBar browseandsearch;
	@BeforeTest
	public void setup() {
	//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\maven automation programs\\Pact_Interview\\src\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://subscription.packtpub.com/");
		driver.manage().window().maximize();
		
		}
	@Test(priority = 1,enabled=true)
	public void loginIntoApplication() {
		login = new Login(driver);
		login.signInlink();	
		login.enterUsername("akshaykumars628191@gmail.com");	
		login.enterPassword("paPA123$");		
		login.clickLogin();
	}
	
	@Test(priority = 2,enabled=true)
	public void verifyElementsInPage() {
		elementinhomepage = new ElementsInHomePage(driver);
		elementinhomepage.verifyElement();				
	}
	
	@Test(priority = 3,enabled=true)
	public void topNavigationBarandClickOnIt() {
		navbar = new NavigationBar(driver);
		navbar.navigationBar();				
	}
	
	@Test(priority = 4,enabled=true)
	public void matchCarouselwithMainTitle() throws InterruptedException, AWTException {
		carousel = new CarouselmatchwithMainTitle(driver);
		Thread.sleep(3000);		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,4000)", "");
		carousel.matchCarouselwithMainTitle();				
	}
	
	@Test(priority = 5,enabled=true)
	public void searchBar() throws InterruptedException {
		browseandsearch = new BrowseandSearchBar(driver);
		Thread.sleep(3000);		
		browseandsearch.browseandSearchBar();				
	}
	
	@AfterTest
	public void close() {
	//	driver.quit();
		
		}
	
	public void scrolldown(int from, int to) {
		try{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy('"+from+"','"+to+"')", "");
		}catch(Exception e){
			e.printStackTrace();
		}

		
	}
	
	
}
