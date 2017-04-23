package testng.web;

import org.openqa.selenium.WebDriver;
import org.seltest.core.Tests;
import org.seltest.driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClapsappGit extends Tests {
	
	private WebDriver driver;

	@BeforeClass
	public void setup() throws Exception{
		
		driver = DriverManager.getDriver();
		
	}
	
	@Test
	public void executescript() throws Exception{
		Thread.sleep(2000);
		
		driver.get("http://www.clapsapp.com/");
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void testrun() throws Exception{
		driver.quit();
	}

}
