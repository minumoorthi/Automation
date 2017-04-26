package testng.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
	@Test(priority=1)
	public void clapsapp() throws Exception{
		
		
	     driver.get("http://www.clapsapp.com/");
	     

		Thread.sleep(2000);
	}
	
	@Test(priority=2, enabled=false)
	private void Signup() throws Exception{
		
		driver.findElement(By.linkText("Sign up")).click();
		Thread.sleep(5000);
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Minu");
		WebElement email=driver.findElement(By.id("email"));
		email.sendKeys("minu.moorthi@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("1234");
		System.out.println("Step 1");
		WebElement frame = driver.findElement(By.xpath(".//*[@id='login-main']/div[2]/div[1]/form/div[4]/div/div/div/iframe"));

        driver.switchTo().frame(frame);

        driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
        driver.switchTo().defaultContent();

        Thread.sleep(2000);

       // WebElement frame1 = driver.findElement(By.xpath(".//iframe[@title='recaptcha challenge']"));
       // driver.switchTo().frame(frame1);
       // driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click(); // this will click on the [Verify] button.

		driver.findElement(By.linkText("NEXT"));
		System.out.println("Done");
		
		Thread.sleep(5000);
		
		
	}
	
	@Test(priority=3)
	public void Signin() throws Exception{
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(2000);
		WebElement email1 = driver.findElement(By.id("email"));
		email1.sendKeys("minu.moorthi@gmail.com");
		WebElement password1 = driver.findElement(By.id("password"));
		password1.sendKeys("1234");
		driver.findElement(By.linkText("SIGN IN")).click();
	}
	@AfterClass
	public void teardown() throws Exception{
		
		driver.quit();
	}

}
