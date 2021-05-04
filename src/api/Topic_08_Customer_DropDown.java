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
	  
	  jsExcutor = (JavascriptExecutor) driver;
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
  
//  @Test
//  public void TC_03_Angular() {
//	driver.get("https://ej2.syncfusion.com/angular/demos/#/material/drop-down-list/data-binding");
//	
//	SelectItemCustomDropDown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Basketball");
//	sleepInSecound(2);
//	Assert.assertEquals(gettextangular(), "Basketball");
//	
//	SelectItemCustomDropDown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Cricket");
//	sleepInSecound(2);
//	Assert.assertEquals(gettextangular(), "Cricket");
//	
//	
//	SelectItemCustomDropDown("//ejs-dropdownlist[@id='games']", "//ul[@id='games_options']/li", "Football");
//	sleepInSecound(2);
//	Assert.assertEquals(gettextangular(), "Football");
//	
//  }
//  
  @Test
  public void TC_04_React() {
	  driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
	  SelectItemCustomDropDown("//div[@role='listbox']", "//div[@role='option']/span", "Jenny Hess");
	  sleepInSecound(2);
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Jenny Hess");
	  
	  SelectItemCustomDropDown("//div[@role='listbox']", "//div[@role='option']/span", "Elliot Fu");
	  sleepInSecound(2);
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Elliot Fu");
	  
	  SelectItemCustomDropDown("//div[@role='listbox']", "//div[@role='option']/span", "Christian");
	  sleepInSecound(2);
	  Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "Christian");
	  
  }
  
  
  public String gettextangular() {
	  return (String) jsExcutor.executeScript("return document.querySelector(\"select[name='games']>option[selected]\").text");
  }
 
   
  
  public void SelectItemCustomDropDown(String parentXpath, String allItemXpath, String string) {
	  
	  // chá»� cho cÃ¡c item Ä‘c hiá»ƒm thá»‹ ra trÆ°á»›c khi chá»�n
	  driver.findElement(By.xpath(parentXpath)).click();
	  sleepInSecound(1);
	  
	  // láº¥y háº¿t táº¥t cáº£ cÃ¡c item Ä‘Æ°a vÃ o 1 list
	  exlicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
	  List<WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
	  
	  // DÃ¹ng vÃ²ng láº·p duyá»‡t qua tá»«ng Item
	  
	  for (WebElement item : allItem) {
		  //Duyá»‡t qua tá»«ng item
		  //text get ra = text mong muá»‘n thÃ¬ dá»«ng láº¡i 
		  //thoÃ¡t khá»�i vÃ²ng láº·p
		  if(item.getText().equals(string)) {
			  item.click();
			  break;
			  
		  }
	  }
//	  exlicitWait.until()
  }
  
  // HÃ m sleep
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
