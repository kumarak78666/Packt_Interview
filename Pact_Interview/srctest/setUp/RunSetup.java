package setUp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import webPages.BrowseandSearchBar;
import webPages.ElementsInHomePage;
import webPages.Login;
import webPages.NavigationBar;
import webPages.TitleOfCarousel;

public class RunSetup {
	WebDriver driver;

	ElementsInHomePage elementinhomepage;
	Login login;
	NavigationBar navbar;
	TitleOfCarousel titc;
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
	@Test(priority = 1)
	public void loginIntoApplication() {
		login = new Login(driver);
		login.signInlink();	
		login.enterUsername("akshaykumars628191@gmail.com");	
		login.enterPassword("paPA123$");		
		login.clickLogin();
	}
	
	@Test(priority = 2,enabled=false)
	public void verifyElementsInPage() {
		elementinhomepage = new ElementsInHomePage(driver);
		elementinhomepage.verifyElement();				
	}
	
	@Test(priority = 3,enabled=false)
	public void topNavigationBarandClickOnIt() {
		navbar = new NavigationBar(driver);
		navbar.navigationBar();				
	}
	
	@Test(priority = 4,enabled=false)
	public void matchCarouselwithMainTitle() throws InterruptedException {
		titc = new TitleOfCarousel(driver);
		Thread.sleep(3000);		
		scrolldown(0,9000);
		titc.carouselTitleAsMainTitle();				
	}
	
	@Test(priority = 5)
	public void searchBar() throws InterruptedException {
		browseandsearch = new BrowseandSearchBar(driver);
		Thread.sleep(3000);		
		browseandsearch.browseandSearchBar();				
	}
	
	@AfterTest
	public void close() {
		driver.quit();
		
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
