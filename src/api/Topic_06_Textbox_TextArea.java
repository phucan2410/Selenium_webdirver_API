package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Topic_06_Textbox_TextArea {
 WebDriver driver;
 String loginpPageUrl, userId, passWord;
 String name, dob, address, city, state, pin, email, phone;
 
 By nameTextboxBy = By.name("name");
 By dobTextboxBy = By.name("dob");
 By addressTextboxBy = By.name("address");
 By cityTextboxBy = By.name("city");
 By stateTextboxBy = By.name("state");
 By pinTextboxBy = By.name("pin");
 By emailTextboxBy = By.name("email");
 By passwordTextboxBy = By.name("password");
 By phoneTextboxBy = By.name("telephoneno");
 
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4");
	  
	  name = "An";
	  dob = "1996-02-05";
	  address = "Hai chau da nang";
	  city = "Da Nang";
	  state = "AK";
	  pin = "545454";  
	  email = "soidientan01@gmail.com";
	  phone = "+840702693850";
  }

  @Test
  public void TC_01_Register() {
	loginpPageUrl = driver.getCurrentUrl();
	driver.findElement(By.xpath("//a[text()='here']")).click();
	
	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("soidientan01@gmail.com");
	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	
	userId = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
	passWord = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
  }
  
  @Test
  public void TC_02() {
	  driver.get(loginpPageUrl);
	  driver.findElement(By.name("uid")).sendKeys(userId);
	  driver.findElement(By.name("password")).sendKeys(passWord);
	  driver.findElement(By.name("btnLogin")).click();
	 
	  Assert.assertTrue(driver.findElement(By.xpath("td[text()='Manger Id : mngr303746']")).isDisplayed());
  }
  
  @Test
  public void TC_03() {
	  driver.findElement(nameTextboxBy).sendKeys(name);
	  driver.findElement(dobTextboxBy).sendKeys(dob);
	  driver.findElement(addressTextboxBy).sendKeys(address);
	  driver.findElement(cityTextboxBy).sendKeys(city);
	  driver.findElement(stateTextboxBy).sendKeys(state);
	  driver.findElement(pinTextboxBy).sendKeys(pin);
	  driver.findElement(emailTextboxBy).sendKeys(email);
	  
	  driver.findElement(By.name("sub")).click();
	  
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td")).getText(), dob);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='PIN']/following-sibling::td")).getText(), pin);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile Number']/following-sibling::td")).getText(), phone);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='E-mail']/following-sibling::td")).getText(), email);
	  
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
