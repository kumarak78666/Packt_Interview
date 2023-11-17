package webPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarouselmatchwithMainTitle {
		 WebDriver driver;
//I have tried with all xpaths they didn't worked finally i have taken xpath from chrome-->copy xpath
	 By maintitle = By.xpath("//*[@id='root']/div/main/section[3]/div[3]/div[1]/div[2]/ol/div[2]/div/div/div[1]/div/div[1]");
	 By carouselcontainer = By.xpath("//*[@id='root']/div/main/section[3]/div[3]/div[1]/div[2]/ol/div[2]/div/div/div[2]/div");
	 By carouselcontainerlist = By.xpath("//*[@id='root']/div/main/section[3]/div[3]/div[1]/div[2]/ol/div[2]/div/div/div[2]/div/p");


		
		 	
		 	public CarouselmatchwithMainTitle(WebDriver driver) {
		           this.driver = driver;
		 	}
		 //I tried to execute parogram of carousel but scrolldown is not working i have spent lot of hours on it but still it didn't worked	
		 	public void matchCarouselwithMainTitle() throws InterruptedException, AWTException {
		 		 JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollBy(0,4000)", "");
		 	
	    	}
		    public void verifymatchCarouselwithMainTitle(WebDriver driver){
		    	
		    	// Locate the main title element
		        WebElement mainTitle = driver.findElement(maintitle);

		        // Locate the carousel container
		        WebElement carousel = driver.findElement(carouselcontainer);

		        // Find all the titles within the carousel
		        List<WebElement> carouselTitles = carousel.findElements(carouselcontainerlist);

		        // Iterate through each title in the carousel
		        for (WebElement title : carouselTitles) {
		            // Click on the title
		            title.click();

		            // Capture the text of the clicked title
		            String clickedTitleText = title.getText();

		            // Get the text of the main title
		            String mainTitleText = mainTitle.getText();

		            // Verify if the clicked title matches the main title
		            if (clickedTitleText.equals(mainTitleText)) {
		                System.out.println("Clicked title matches the main title: " + clickedTitleText);
		            } else {
		                System.out.println("Clicked title does not match the main title");
		            }
		    	
		    	
		    }
		    }}
