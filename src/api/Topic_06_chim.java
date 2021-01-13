package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Topic_06_chim {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://login.mailchimp.com/signup/");
  }
  @Test
  public void TC_01() throws InterruptedException {
	  driver.findElement(By.id("email")).sendKeys("soidientan01@gmail.com");
	  driver.findElement(By.id("new_username")).sendKeys("soidientan");
	  
	  /* Lower case */
	  driver.findElement(By.xpath("//li[@class='lowercase-char completed' and text() = 'One lowercase character']")).sendKeys("auto");
	  Thread.sleep(2000);
	  Assert.assertTrue(driver.findElement(By.xpath("\"//li[@class='lowercase-char completed' and text() = 'One lowercase character']")).isDisplayed());
  }
 

  @AfterMethod
  public void afterMethod() {
  }

}
