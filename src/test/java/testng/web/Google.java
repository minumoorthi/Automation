package testng.web;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.seltest.core.Tests;
import org.seltest.driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by ssu on 4/17/2017.
 */
public class Google extends Tests {

    private WebDriver driver;


    @BeforeClass
    //Executed once for all the script in the class
    public void setUp() throws Exception {
        driver = DriverManager.getDriver();
    }

    @Test
    //At this point Android driver is initialized fine and communication with the device is established
    //Script will be executed accordingly
    public void executeScript() throws Exception {

        Thread.sleep(2000);

        //driver.findElement(By.name("Add New Expense")).click();
        driver.get("http://www.google.com");

        Thread.sleep(3000);

        driver.navigate().back();

        assertTrue(true);
    }

    @AfterClass
    //All the script execution is done, have to quit the driver to delete the session from the appium server
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)
            driver.quit();

    }
}
