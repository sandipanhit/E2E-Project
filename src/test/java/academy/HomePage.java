package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getData")
	public void loginPage(String Username , String Password , String text) throws IOException {
		
		LandingPage lp = new LandingPage(driver);
		LoginPage l=lp.getLogin();
		//LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(Username);
		l.getPword().sendKeys(Password);
		l.getLoginBtn().click();
		log.info(text);
		
		ForgotPassword fp = l.forgotPassword();
		fp.getEmail().sendKeys("abcdef@a.com");
		fp.sendMeInstructions().click();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object [][] data = new Object[2][3];
		data[0][0] = "a.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted User 1";
		
		data[1][0] = "abc.com";
		data[1][1] = "12345234";
		data[1][2] = "Restricted User 2";
		
		return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
