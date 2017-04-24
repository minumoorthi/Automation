package testng.web;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.seltest.core.Tests;
import org.seltest.data.DataFactory;
import org.seltest.driver.DriverFactory;
import org.seltest.driver.DriverManager;
import org.seltest.test.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EastWestOnlineLogin extends Tests{
	
	private WebDriver driver;
	/*private - so that no other class can hijack your logger
static - so there is only one logger instance per class, also avoiding attempts to serialize loggers
final - no need to change the logger over the lifetime of the class
Also, I prefer name log to be as simple as possible, yet descriptive.

The former way allows you to use the same logger name (name of the actual class) in all classes
 throughout the inheritance hierarchy. So if Bar extends Food, both will log to Bar logger. Some find it more intuitive.*/
	private static final LoggerUtil Banklogger = LoggerUtil.getLogger();
	
	/*@Parameters annotation is easy but to test with multiple sets of data we need to use Data Provider.

To fill thousand's of web forms using our testing framework we need a different methodology which can give us a 
very large dataset in a single execution flow.

This data driven concept is achieved by @DataProvider annotation in TestNG.*/
	@Test(dataProvider="deviceData")
	 public void testAllDrivers(String browser) {

        driver = DriverFactory.getDriver(browser);
        DriverManager.setWebDriver(driver);
        driver = DriverManager.getDriver();

        try {
            setup();
        } catch (Exception e) {
            Banklogger.exception(e);
        }
    }

	
	public void setup() throws Exception {
		Thread.sleep(2000);
		
		driver.get("https://www.eastwestbank.com/");
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		assertTrue(true);
		
		
	}
	/*http://www.guru99.com/parameterization-using-xml-and-dataproviders-selenium.html*/
	@DataProvider(name="deviceData",parallel=true)
    public Object[][] device(){

        return DataFactory.getDataObject("testdata/driver.csv");
    }

    @AfterClass
    //All the script execution is done, have to quit the driver to delete the session from the Appium server
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)
            driver.quit();

    }



	

}
