package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Topic_02_Xpath_CSS {
	WebDriver driver;
	Random rand;
	String emailAddress, fisrtname, lastname;
	
	
	
  @BeforeMethod
  public void beforeMethod() {
  driver = new FirefoxDriver();
  rand = new Random();
	driver.manage().window().maximize();
	driver.get("http://live.demoguru99.com/");
	emailAddress = "phucan" + rand.nextInt(99999) + "@gmail.com";
	fisrtname = "An";
	lastname = "Phuc Nguyen";
  }
  
  @Test
  public void TC_01_Empty_Email_Password() {
	  driver.get("http://live.demoguru99.com/");
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
	  driver.get("http://live.demoguru99.com/");
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("123321@123.123");
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();
	  
	  //Verify msg error 
	  Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
  }
  
  	@Test
  	public void TC_03() {
  	driver.get("http://live.demoguru99.com/");
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("phucan24123@gmail.com");
	  driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("1234");
	  driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();;
	  
	  //Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@class='input-box']//div[@id='advice-validate-password-pass']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
  }
  
  	@Test
  	public void TC_04() {
  		driver.get("http://live.demoguru99.com/");
	 driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	 driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("phucan24123@gmail.com");
	 driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("123123123");
	 driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();
	 
	 Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(), "Invalid login or password.");
	 }
  
  	@Test
  	public void TC_05() {
  		driver.get("http://live.demoguru99.com/");
		 driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
		 driver.findElement(By.xpath("//div[@class='buttons-set']//a[@class='button']")).click();
		 driver.findElement(By.id("firstname")).sendKeys("An");
		 driver.findElement(By.id("middlename")).sendKeys("Phuc");
		 driver.findElement(By.id("lastname")).sendKeys("Nguyen");
		 driver.findElement(By.id("email_address")).sendKeys("phucan24123@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("phucan2410");
		 driver.findElement(By.id("confirmation")).sendKeys("phucan2410");
		 driver.findElement(By.xpath("//div[@class='input-box']//input[@type='checkbox']")).click();
		 driver.findElement(By.xpath("//span[text()='Register']")).click();
		 
		 Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(), "Thank you for registering with Main Website Store.");
		 driver.findElement(By.xpath("//a[text()='Account Information']")).click();
		 Assert.assertEquals(driver.findElement(By.id("firstname")).getAttribute("value"), "An");
		 Assert.assertEquals(driver.findElement(By.id("lastname")).getAttribute("value"), "Nguyen");
		 Assert.assertEquals(driver.findElement(By.xpath("//input[@title='Email Address']")).getAttribute("value"), "phucan24123@gmail.com");
		 driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		 driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		 //Kiem tra navigation 
		 String URL = driver.getCurrentUrl();
		 Assert.assertTrue(URL.contains("http://live.demoguru99.com/index.php/"));
		 System.out.println(URL);
		 
  }
  
 	@Test
 	public void TC_06() {
 		driver.get("http://live.demoguru99.com/");
		 driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
		 driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Email Address']")).sendKeys("phucan24123@gmail.com");
		 driver.findElement(By.xpath("//div[@class='input-box']//input[@title='Password']")).sendKeys("phucan2410");
		 driver.findElement(By.xpath("//div[@class='buttons-set']//span[text()='Login']")).click();;
		 Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='My Dashboard']")).getText(), "MY DASHBOARD");
		 driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		 //tach chuoi
		 
		 Assert.assertEquals(driver.findElement(By.xpath("//strong[text()= 'Hello, An Phuc Nguyen!']")).getText(), "Hello, " + fisrtname + " " + lastname + "!");
		 
		 String contactInformation = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")).getText();
		 Assert.assertTrue(contactInformation.contains("An Phuc Nguyen"));
		 Assert.assertTrue(contactInformation.contains("phucan24103@gmail.com"));
 	}
	
 
 	@AfterMethod
 	public void afterMethod() {
	  driver.quit();
  }
}

