package academy;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateNavigationBar extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	public void PageNavigationBar() throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		
		
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation bar has been displayed");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
