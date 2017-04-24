package testng.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seltest.core.Config;
import org.seltest.core.Tests;
import org.seltest.data.DataFactory;
import org.seltest.driver.DriverFactory;
import org.seltest.driver.DriverManager;
import org.seltest.test.LoggerUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertTrue;

/**
 * Created by ssu on 4/17/2017.
 */
public class GoogleAllDriver  extends Tests {

    private WebDriver driver;

    private static final LoggerUtil logger = LoggerUtil.getLogger();

    @Test(dataProvider="deviceData")
    public void testAllDrivers(String browser) {

        driver = DriverFactory.getDriver(browser);
        DriverManager.setWebDriver(driver);
        driver = DriverManager.getDriver();

        try {
            executeScript();
        } catch (Exception e) {
            logger.exception(e);
        }
    }

    public void executeScript() throws Exception {

        Thread.sleep(2000);

        //driver.findElement(By.name("Add New Expense")).click();
        driver.get("http://www.google.com");

        Thread.sleep(3000);

        driver.navigate().back();

        assertTrue(true);
    }
   
    @DataProvider(name="deviceData",parallel=true)
    public Object[][] device(){

        return DataFactory.getDataObject("testdata/driver.csv");
    }

    @AfterClass
    //All the script execution is done, have to quit the driver to delete the session from the appium server
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)
            driver.quit();

    }


}
