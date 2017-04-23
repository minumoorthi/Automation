package testng.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Clapsapp {
	
	private WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\minum\\Documents\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
		
	@Test
	public void clapsapp() throws Exception{
		
		
	     driver.get("http://www.clapsapp.com/");
		Thread.sleep(2000);
		
		}
	@AfterClass
	public void teardown() throws Exception{
		
		driver.quit();
	}

}
