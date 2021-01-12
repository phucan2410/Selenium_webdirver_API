package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Topic_06_Web_element {
  WebDriver driver;
  
	
  	@BeforeMethod
	public void beforeMethod() {
  		driver = new FirefoxDriver();
		 driver.get("https://automationfc.github.io/basic-form/index.html");
	  
}
  	@Test
  	public void TC_1() {
  	boolean emailTextboxStatus = driver.findElement(By.cssSelector("#email")).isDisplayed();
  	
  		if (emailTextboxStatus == true) {
  		driver.findElement(By.cssSelector("#email")).sendKeys("soidientan01@gmail.com");
  		System.out.println("Email textbox is displayed");
  		
  	}
  		else {
  			System.out.println("Email textbox  no displayed");
  			
  		}  	
  	}
  		@Test
  	  	public void TC_2() {
  	boolean edu = driver.findElement(By.cssSelector("#edu")).isDisplayed();
  	
  	if (edu == true) {
  		driver.findElement(By.cssSelector("#edu")).sendKeys("DHKT");
  		System.out.println("Education Have Show");
  	}
  		else {
  		System.out.println("Education no show");
  	}
  		}
  			
  			

 
  

  	@AfterMethod
  	public void afterMethod() {
  }

}
