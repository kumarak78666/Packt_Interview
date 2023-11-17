package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
 WebDriver driver;
By SignIn = By.xpath("//a[contains(text(),'Sign In')]");
By EmailId = By.xpath("//input[@id='inline-form-input-username']");
By Password = By.xpath("//input[@id='inline-form-input-password']");
By SignINbutton = By.xpath("(//*[@id='loginPage']//button)[3]");
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public Login(WebDriver driver) {
          this.driver = driver;
	}
	public void signInlink() {
		driver.findElement(SignIn).click();
		scrolldown(0,1000);
	}
	
	public void enterUsername(String user) {
		driver.findElement(EmailId).sendKeys(user);
	}

	//Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(Password).sendKeys(pass);
	}
	
	//Method to click on Login button
	public void clickLogin(){
	//	Thread.sleep(3000);
		driver.findElement(SignINbutton).click();
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
