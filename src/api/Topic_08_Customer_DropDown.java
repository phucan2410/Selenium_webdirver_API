package api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Topic_08_Customer_DropDown {
	WebDriver driver;
	WebDriverWait exlicitWait;
	JavascriptExecutor jsExcutor;
	
  
	@BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  
	  exlicitWait = new WebDriverWait(driver, 30);
	  
  }
  
//  @Test
//  public void TC_01_JQuery() {
//	  driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
//	  SelectItemCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "13");
//	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "13");
//	  sleepInSecound(4);
//	  SelectItemCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "1");
//	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "1");
//	  
//	  sleepInSecound(4);
//	  SelectItemCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
//	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "19");
//	  sleepInSecound(4);
//	  SelectItemCustomDropDown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "5");
//	  Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "5");
//	  sleepInSecound(4);
//  }
  
  @Test
  public void TC_03_Angular() {
	driver.get("https://ej2.syncfusion.com/angular/demos/#/material/drop-down-list/data-binding");
	
	SelectItemCustomDropDown("ejs-dropdownlist[@id='gamne']", "ul[@id='games_options']/li", "Basketball");
	sleepInSecound(2);
	Assert.assertEquals(gettextangular(), "Basketball");
	SelectItemCustomDropDown("ejs-dropdownlist[@id='gamne']", "ul[@id='games_options']/li", "Cricket");
	Assert.assertEquals(gettextangular(), "Cricket");
	sleepInSecound(2);
	
	SelectItemCustomDropDown("ejs-dropdownlist[@id='gamne']", "ul[@id='games_options']/li", "Football");
	Assert.assertEquals(gettextangular(), "Football");
	sleepInSecound(2);
  }
  
  
  public String gettextangular() {
	  return (String) jsExcutor.executeScript("return document.querySelector(\"select[name='games']>option[selected]\").text");
  }
 
   
  
  public void SelectItemCustomDropDown(String parentXpath, String allItemXpath, String string) {
	  
	  // chờ cho các item đc hiểm thị ra trước khi chọn
	  driver.findElement(By.xpath(parentXpath)).click();
	  sleepInSecound(1);
	  
	  // lấy hết tất cả các item đưa vào 1 list
	  exlicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
	  List<WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
	  
	  // Dùng vòng lặp duyệt qua từng Item
	  
	  for (WebElement item : allItem) {
		  //Duyệt qua từng item
		  //text get ra = text mong muốn thì dừng lại 
		  //thoát khỏi vòng lặp
		  if(item.getText().equals(string)) {
			  item.click();
			  break;
			  
		  }
	  }
//	  exlicitWait.until()
  }
  
  // Hàm sleep
  public void sleepInSecound(long timeout) {
	  try {
		Thread.sleep(timeout * 1000);
		
	} catch (InterruptedException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
  }
  
  @BeforeMethod
  public void afterClass() {
  }

}
