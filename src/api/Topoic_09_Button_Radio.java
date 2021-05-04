package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class Topoic_09_Button_Radio {
	WebDriver driver;
	WebDriverWait explicitWait;
	@BeforeClass
	  public void beforeClass() {
			  System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
			  driver = new ChromeDriver();
			  explicitWait = new WebDriverWait(driver, 15);

	  }
	//Visible có thể nhìn thấy và thao tác được
	@Test
	public void TC_01_Visible() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		// Chờ cho Submit button được visible trong vòng 15s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='SubmitLogin']")));
		
		
	}
	@Test
	public void TC_02_invisible() {
		//driver.get("http://live.demoguru99.com/index.php");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[text()='An email addree .']")));
		// Không nhìn tháy  
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='header-account']//a[text()='My Account']")));
	}
	
	@Test
	public void TC_03_invisible() {
		// Cố tình Wait cho error mesage visible => failed
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[text()='An email address required.']")));
	}
	
	
	@AfterClass
	public void afterClass() {
	}
}

