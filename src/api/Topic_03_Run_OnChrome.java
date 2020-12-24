package api;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Run_OnChrome {
	WebDriver driver;
	String project_localtion = System.getProperty("user.dir");
	
	@Test
	public void TC_01_Run_firfox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://google.com");
		
	}
	
	@Test
	public void TC_02_Run_Chrome() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", project_localtion + "//browerDriver//chromedriver.exe");
		driver.get("https://google.com");
		driver.quit();
	}
}
