package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Topic_06_Web_element {
  WebDriver driver;
  By emailTextboxStatus = By.cssSelector("#email");
  By edu = By.cssSelector("#edu");
  By Under18 = By.cssSelector("#under_18");
  By nameText = By.xpath("//h5[text()='Name: User5']");
  By slider2 = By.cssSelector("#slider-2");
  By slider1 = By.cssSelector("#slider-1");
  By java = By.cssSelector("#java");
  
  	@BeforeMethod
	public void beforeMethod() {
  		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
	  
}
  	@Test
  	public void TC_1() {
  	
  	if (isElementDisplayed(emailTextboxStatus)) {
  		sendKeyToElement(emailTextboxStatus, "Auto mation testing");
  		
  		
  	}
 
  	if (isElementDisplayed(edu)) {
  		sendKeyToElement(edu, "Auto mation testing 1");
  }
 
  	if (isElementDisplayed(Under18)) {
  		clickToElement(Under18);
  		
  	}
  	
  	Assert.assertFalse(isElementDisplayed(nameText));
 } 	
  	
  	public boolean isElementDisplayed(By by) {
  		WebElement element = driver.findElement(by);
  	if(element.isDisplayed()) {
  		System.out.println("Element is displayed");
  		return true;
  	}  	else {
  		System.out.println("Element is not displayed");
  		return false;
 }
  	}
  	
  	public void sendKeyToElement(By by, String value) {
  		WebElement element = driver.findElement(by);
  		element.clear();
  		element.sendKeys(value);
  	}
  	public void clickToElement(By by) {
  		WebElement element = driver.findElement(by);
  		element.click();
  		
  	}

  	public boolean isElementEnable(By by) {
  		WebElement element = driver.findElement(by);
  		if(element.isEnabled()) {
  			System.out.println("Element is Enabled");
  			return true;
  		} else {
  			return false;
  		}
  		
  		}
  	public boolean isElementSelected(By by) {
  		  		WebElement element = driver.findElement(by);
  		  	if(element.isSelected()) {
  		  		System.out.println("Element is Selected");
  		  		return true;
  		  	}  	else {
  		  		System.out.println("Element is not Selected");
  		  		return false;
  			
  		}
  	}
  	
  	@Test
  	public void TC_2() {
  	//Nâng cao nè
  	Assert.assertTrue(isElementEnable(emailTextboxStatus));
  	Assert.assertTrue(isElementEnable(slider1));
  	Assert.assertFalse(isElementEnable(slider2));

// Cách cơ cản
//  		boolean emailTextboxStatus = driver.findElement(By.cssSelector("#email")).isEnabled();
//  	  	
//  	  	if (emailTextboxStatus == true) {
//  	  		driver.findElement(By.cssSelector("#email")).sendKeys("soidientan01@gmail.com");
//  	  		System.out.println("Email textbox is Enabled");
//  	  		
//  	  	}
//  	  	else {
//  	  		System.out.println("Email textbox Disable");
//  	  			
//  	  		}  
//  	  	
//  	  boolean sliderstatus1 = driver.findElement(By.cssSelector("#slider-1")).isEnabled();
//	  	
//	  	if (sliderstatus1 == true) {
//	  		System.out.println("Slider 01 is Enabled");
//	  		
//	  	}
//	  	else {
//	  		System.out.println("Slider 01 is Disable");
//	  			
//	  		}
//	  	boolean sliderstatus2 = driver.findElement(By.cssSelector("#slider-2")).isEnabled();
//	  	
//	  	if (sliderstatus2 == true) {
//	  		System.out.println("Slider 02 is Enabled");
//	  		
//	  	}
//	  	else {
//	  		System.out.println("Slider 02 is Disable");
//	  			
//	  		}
  		
  		

 }
	@Test
	public void TC_3() {
//Cách cơ bản
//		 driver.findElement(By.id("java")).click();
//		 driver.findElement(By.id("under_18")).click();
//	
//		 Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
//		 
//		 Assert.assertTrue(driver.findElement(By.id("java")).isSelected());
//		 
//		 driver.findElement(By.id("under_18")).click(); 
//		 
//		 driver.findElement(By.id("java")).click();
//		 
//		 Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
//		 System.out.println("under 18 is Selected");
//		 
//		 Assert.assertFalse(driver.findElement(By.id("java")).isSelected());
//		 System.out.println("Java check box is not Selected");
		  
		  
//Nâng cao nè 
		  clickToElement(Under18);
		  clickToElement(java);
		  Assert.assertTrue(isElementSelected(Under18));
		  Assert.assertTrue(isElementSelected(java));
		  clickToElement(Under18);
		  clickToElement(java);
		  Assert.assertTrue(isElementSelected(Under18));
		  Assert.assertFalse(isElementSelected(java));
 
	  }
  		

  	@AfterMethod
  	public void afterMethod() {
  }

}
