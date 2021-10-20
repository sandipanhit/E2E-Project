package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		String browser = System.getProperty("browser");
		//String browser = prop.getProperty("browser");
		//String [] diffBrowser = browser.split(",");
		
		
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C://eclipse-jee-2019-03-R-win32-x86_64//workspace//driver//chromedriver.exe");
				driver= new ChromeDriver();
				
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\eclipse-jee-2019-03-R-win32-x86_64\\workspace\\driver\\geckodriver.exe");
				driver=new FirefoxDriver();
		
			}
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName , WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destFi = new File(System.getProperty("user.dir")+"\\reports\\snapshot\\",testCaseName+".png");
		String destFile = System.getProperty("user.dir")+"\\reports\\snapshot\\"+testCaseName+".png";
		FileUtils.copyFile(source,destFi);
		return destFi.getName();
	}

}
