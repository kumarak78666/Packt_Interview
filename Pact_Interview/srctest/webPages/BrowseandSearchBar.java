package webPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowseandSearchBar {
		 WebDriver driver;
         WebDriverWait wait;

 	 By browselink = By.xpath("(//a[contains(text(),'Browse Library')])[1]");
 	 By clearfilter = By.xpath("//button[contains(text(),'Reset All')]");
 	 By filterdate = By.xpath("//div[@class='value' and text()='2021']");
 	 By sarchbar = By.xpath("//form//input[@placeholder='Search titles …']");


		
		 	
		 	public BrowseandSearchBar(WebDriver driver) {
		           this.driver = driver;
		 	}
		 	public void browseandSearchBar() throws InterruptedException {
	    		verifybrowseandSearchBar(driver);
	    	}
		    public void verifybrowseandSearchBar(WebDriver driver) throws InterruptedException {
		    	// Click on 'Browse' in the top navigation
		        WebElement browseLink = driver.findElement(browselink);
		        browseLink.click();
		        Thread.sleep(3000);		   
		        
		        // Click to clear any filters that are already set
		        WebElement clearFiltersButton = driver.findElement(clearfilter);
		        clearFiltersButton.click();
		        Thread.sleep(3000);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0,500)", "");
		        
		        //click on publication date
		        WebElement publicationdatefield = driver.findElement(By.xpath("//div//div[contains(text(),'Published Year')]"));
		        publicationdatefield.click();
		        Thread.sleep(3000);
		        
		        // Click to set the 2021 filter for publication date
		        WebElement filter2021 = driver.findElement(filterdate);
		        filter2021.click();
		        Thread.sleep(3000);
		        // Typing words into the search bar and checking texts
		        String[] searchWords = {"Python", "Paint", "Secure", "Tableau"};
		        
		        for (String word : searchWords) {
		            WebElement searchInput = driver.findElement(sarchbar);
		            searchInput.clear();
		            searchInput.sendKeys(word);
		            Thread.sleep(2000);
		            searchInput.submit(); 
		            
		            wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.className("products-wrapper"))));
		            // Checking if all titles found include the search text
		            List<WebElement> bookTitles = driver.findElements(By.className("product-card"));
		            boolean allTitlesContainWord = true;
		            
		            for (WebElement title : bookTitles) {
		                if (!title.getText().contains(word)) {
		                    allTitlesContainWord = false;
		                    break;
		                }
		            }
		            
		            if (allTitlesContainWord) {
		                System.out.println("All titles contain the word: " + word);
		            } else {
		                System.out.println("Not all titles contain the word: " + word);
		            }
		        }
		    	
		    	
		    	
		    	
		    }
}
