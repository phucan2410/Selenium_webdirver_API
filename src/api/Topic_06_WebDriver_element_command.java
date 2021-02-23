package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class Topic_06_WebDriver_element_command {
  WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("https://automationfc.github.io/multiple-fields/");
  }
  
  @Test
  public void TC_01_Webelement_Commad() {
	  WebElement element = driver.findElement(By.xpath(""));
	  
	  //Xóa dữ liệu 
	  element.clear(); //**hay dùng
	  
	  // Nhập dữ liệu textbox
	   
	  element.sendKeys(""); //**hay dùng

	  //Click vào button/checkbox/link/
	  
	  element.click(); //**hay dùng 
	  
	  //Get tham số 
	  element.getAttribute("placeholder"); //**hay dùng
	  
	  //Get stype của element/font/size/color
	  element.getCssValue("color");
	  
	  //GUI
	  element.getLocation();
	  element.getRect();
	  element.getSize();
	  
	  String emailTextbox = element.getTagName();
	  Assert.assertEquals(emailTextbox, "input");
	  
	  //Đầu ra của hàm này => tên thẻ => đầu vào của 1 elemnt khác ( tagname trong xpath)
	  driver.findElement(By.xpath("" + emailTextbox + "[@id='email']"));
	  
  	  
  	  // lấy ra text của element bất kỳ text k nằm trong attribute
	  element.getText(); //**hay dùng
	  
	  // Kiểm tra mong muống đang hiển thị
	  
	  Assert.assertTrue(element.isDisplayed()); //**hay dùng
  	
	  // Có thể thao tác được
	  Assert.assertTrue(element.isEnabled()); //**hay dùng
	  
	  //Đã được chọn thành công (Radio button/ checkbox)
	  Assert.assertTrue(element.isSelected()); //**hay dùng
	  
	  // Kiểm tra không mong muốn element hiển thị
	  Assert.assertFalse(element.isDisplayed());
	  
	  //Enter vào trong 1 form
	  element.submit(); 
	  
	  
  }
  	  
  

  @AfterMethod
  public void afterMethod() {
  }

}
