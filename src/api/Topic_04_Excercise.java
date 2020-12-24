package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;


public class Topic_04_Excercise {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod1() {
	  	driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://live.demoguru99.com/");
		
  }
  
  @Test
  public void TC_01_GetURL() {
	  
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  
	  driver.findElement(By.xpath("//button[@title='Login']")).click();
	  String CurrentURL1 = driver.getCurrentUrl();
	  Assert.assertEquals(CurrentURL1, "http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.findElement(By.xpath("//Span[text()='Create an Account']")).click();
	  
	  String CurrentURL2 = driver.getCurrentUrl();
	  Assert.assertEquals(CurrentURL2, "http://live.demoguru99.com/index.php/customer/account/create/");
	  
  }
  
  @Test
  public void TC_02_Get_TitlePage(){
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  String title1 = driver.getTitle();
	  Assert.assertEquals(title1, "Customer Login");
	  
	  driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  String title2 = driver.getTitle();
	  Assert.assertEquals(title2, "Create New Customer Account");
  }
  
  @Test
  public void TC_03_Nanigation() {
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  
	  String URL_Createa_Account = driver.getCurrentUrl();
	  Assert.assertEquals(URL_Createa_Account, "http://live.demoguru99.com/index.php/customer/account/create/");
	  
	  driver.navigate().back();
	  String URL_Login = driver.getCurrentUrl();
	  Assert.assertEquals(URL_Login, "http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.navigate().forward();
	  
	  String title3 = driver.getTitle();
	  Assert.assertEquals(title3, "Create New Customer Account");
	  
  }
  
  @Test
  public void TC_04_Getpagesource() {
	  driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
	  String loginPagesource = driver.getPageSource();
	  Assert.assertTrue(loginPagesource.contains("Login or Create an Account"));
	  driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  String CreatePagesource = driver.getPageSource();
	  Assert.assertTrue(CreatePagesource.contains("Create an Account"));
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
