package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Topic_02_Xpath_CSS {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
  driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://live.demoguru99.com/");
  }
  
  @Test
  public void TC_01_Empty_Email_Password() {
	  //Click 
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  
	  //Click Login
	  driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();
	  // Verify msg - Actual result
	  Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
	  
	  //Expected result
	  Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	  
  }
  @Test
  public void TC_02_Invailid_Email() {
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("123321@123.123");
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();
	  
	  //Verify msg error 
	  Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
  }
  
  @Test
  public void TC_03() {
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("phucan2410@gmail.com");
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("1234");
	  driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']"));
  }
  
  
  
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
