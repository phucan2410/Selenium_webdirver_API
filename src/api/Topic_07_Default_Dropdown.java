package api;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class Topic_07_Default_Dropdown {
  Select select;
  WebDriver driver;
  String firstName, lastName, emailAddress, companyName, password;
  String date, month, year;
//  WebDriverWait exlicitWait;
//  JavascriptExecutor jsExecutor;
//  Actions action;
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://demo.nopcommerce.com");
//	  exlicitWait = new WebDriverWait(driver, 20);
//	  jsExecutor = (JavascriptExecutor) driver;
//	  action = new Actions(driver);
	  firstName = "An";
	  lastName = "Nguyen";
	  //getRandomNumber tiền tố  "@gmail.com" hậu tố
	  
	  companyName = "AnCompany";
	  password = "phucan1!";
	  date = "30";
	  month = "September";
	  year = "1998";
	  
  }
  
  @Test(invocationCount = 1)
  public void TC_01_register() {
	  //1 mở trang register 
	  driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	  driver.findElement(By.className("ico-register")).click();
	  
	  //2 điền thông tin
	  driver.findElement(By.id("gender-male")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("An");
	  driver.findElement(By.id("LastName")).sendKeys("Nguyen");
	  
	  // Khởi tạo biến select để thao tác vs dropdown Date
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
	  select.selectByVisibleText("30");
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
	  
	//Khởi tạo biến sleect để thao tác vs dropdown Month
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
	  select.selectByVisibleText("September");
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), "September");
	  
	  //Khởi tạo biến sleect để thao tác vs dropdown Year
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
	  select.selectByVisibleText("1998");
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), "1998");
	  // bỏ xuống dưới này vì hàm 
	  emailAddress = "soidientan" + getRandomNumber() + "@gmail.com";
	  driver.findElement(By.id("Email")).sendKeys(emailAddress);
	  driver.findElement(By.id("Company")).sendKeys(companyName);
	  
	  checkToCheckboxorRadio(By.id("Newsletter"));
	  driver.findElement(By.xpath("//label[text()='Password:']")).sendKeys(password);
	  driver.findElement(By.xpath("//label[text()='Confirm password:']")).sendKeys(password);
  
	  // Hay dùng isMultiple, selectByvisible, getFirstSelectOption
	  //3 đăng ký
	  driver.findElement(By.id("register-button")).click();
	  //4 kiểm tra xuất hiện message đăng ký thành công
	  Assert.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");
	  //5 vào my account
	  driver.findElement(By.className("ico-account")).click();
	  //6 kiểm tra thông tin 
	  Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected());
	  Assert.assertTrue(driver.findElement(By.id("Newsletter")).isSelected());
	  
	  Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
	  Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
	  Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
	  Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
	  Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyName);
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
	  
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
	  
	  select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
	  
	  driver.findElement(By.xpath("//a[text()='Log out']")).click();
	  
	  

  }
  
  public void checkToCheckboxorRadio(By by) {
	  WebElement element = driver.findElement(by);
	  if(!element.isSelected()) {
		  element.click();
	  }
	  
  }
  
   public void uncheckToCheckboxorRadio(By by) {
	  WebElement element = driver.findElement(by);
	  if(!element.isSelected()) {
		  element.click();
	  }
   }
  
   public void sleep(long second) {
	try {
		Thread.sleep(second * 1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
   }
   
   public int getRandomNumber() {
	   Random rand = new Random();
	   return rand.nextInt(99999);
   }

  @AfterMethod
  public void afterMethod() {
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  driver.quit();
  }

}
