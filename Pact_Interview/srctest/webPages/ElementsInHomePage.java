package webPages;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class ElementsInHomePage {
	WebDriver driver;
	
	
	By ElementId = By.xpath("//button[contains(text(),'Advanced Search')]");	   	    	
	    	    	
	    	public ElementsInHomePage(WebDriver driver) {
	    		this.driver=driver;
			}
			public void verifyElement() throws InterruptedException {
	    		verifyElements(driver);
	    	}
			
    		    public void verifyElements(WebDriver driver) throws InterruptedException {
	    		    		    		    	
	    		        Thread.sleep(3000);
	    		        // Verify element positions 
	    		        WebElement element = driver.findElement(ElementId);
	    		        System.out.println(element);
	    		        Point elementPosition = element.getLocation();

	    		        // Retrieve x and y coordinates
	    		        int xCoordinate = elementPosition.getX();
	    		        int yCoordinate = elementPosition.getY();

	    		        // Print the coordinates
	    		        System.out.println("X Coordinate: " + xCoordinate);
	    		        System.out.println("Y Coordinate: " + yCoordinate);
	    		        Thread.sleep(3000);
	    		        // Verify element text
	    		        String Actualtext = "Advanced Search";
	    		        String elementText = element.getText();
	    		        System.out.println(elementText);
	    		        Assert.assertEquals(Actualtext, elementText, "Element text is incorrect");
	    		        
	    		       
	    		        Thread.sleep(3000);
	    		        // Verify element color
	    		        String actualcolor = "rgba(236, 102, 17, 1)";
	    		        String elementColor = element.getCssValue("color");
	    		        System.out.println(elementColor);
	    		        Assert.assertEquals(actualcolor, elementColor, "Element color is incorrect");

	    		       
	    		        Thread.sleep(3000);
	    		        //checking multiple elements
	    		        List<WebElement> elements = driver.findElements(By.tagName("a"));
	    		        for (WebElement el : elements) {
	    		        	System.out.println(el.getText());
	    		        
	    		        }

	    		    }}
