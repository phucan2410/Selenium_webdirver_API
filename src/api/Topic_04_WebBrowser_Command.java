package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_04_WebBrowser_Command {
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
  }

  @Test
  public void TC_91_Webbrowser() {
	  //Apply for tab
	  driver.close();
	  //Apply for browser
	  driver.quit();
	  
	  //lấy ra URL page hiện tại
	  String loginpageurl = driver.getCurrentUrl();
	  Assert.assertEquals(loginpageurl, "https://google.com");
	  
	  //get title page 
	  driver.getTitle();
	  Assert.assertEquals(driver.getTitle(), "Welcome");
	  
	  //chờ element load thành công
	  driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	  
	  // LẤY GUID của tab/ window hiện tại
	  driver.getWindowHandle();
	  
	  // GUID all tab/window 
	  driver.getWindowHandles();
	  
	  //Chờ cho element load ra thành công
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  //Chờ cho page được load thành công
	  
	  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  
	  //JS Excutor
	  
	  driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	  
	  // Full screen
	  driver.manage().window().fullscreen();
	  
	  driver.manage().window().maximize();
	  
	 //Responsive 
	  // driver.manage().window().setSize(arg0);
	  
	  //Back lai page truoc
	  
	  driver.navigate().back();
	  
	  // Forward toiws page truowcs
	 
	  driver.navigate().forward();
	  
	  // Tải lại trang
	  driver.navigate().refresh();
	  
	 
	  }


  @AfterMethod
  public void afterMethod() {
  }

}
