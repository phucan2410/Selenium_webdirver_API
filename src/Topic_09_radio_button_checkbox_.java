import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import static org.testng.Assert.assertEquals;


public class Topic_09_radio_button_checkbox_ {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
	}	
	
	@Test
	public void f() throws InterruptedException {
		driver.get("https://www.fahasa.com/customer/account/create?attempt=1");
		By loginButton = By.cssSelector(".fhs-btn-login");
		driver.findElement(By.xpath("//a[text()='Đăng nhập']")).click();
		
		// Verify button is déabled
		Assert.assertFalse(driver.findElement(loginButton).isEnabled());
		
		// Input email pass 
		driver.findElement(By.xpath("//input[@id='login_username']")).sendKeys("soidientan01@gmail.com");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("phucan1!");
	
		//Verify login button is enabled
		Assert.assertTrue(driver.findElement(loginButton).isEnabled());
		
		Thread.sleep(2000);
		
	}


	@AfterClass
	public void afterClass() {
	}

}
