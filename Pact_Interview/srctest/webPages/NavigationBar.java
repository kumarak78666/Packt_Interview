package webPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar {
	 WebDriver driver;
	 By topnavibar = By.cssSelector("nav#packt-navbar");
	
	 	
	 	public NavigationBar(WebDriver driver) {
	           this.driver = driver;
	 	}
	 	public void navigationBar() {
    		verifynavigationBar(driver);
    	}
	    public void verifynavigationBar(WebDriver driver) {

	    	List<WebElement> navigationElements = driver.findElements(topnavibar);

	    	for (WebElement option : navigationElements) {	        	
	            System.out.println(option);
	            option.click();
	            String actual=option.getText();
	            System.out.println(actual);	           
	     
	        
	        }
	    	
      
	    
	   }}
		
