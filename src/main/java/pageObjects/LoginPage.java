package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By email = By.id("user_email");
	By pword = By.xpath("//input[@type='password']");

	By loginBtn = By.cssSelector("input.login-button");
	By forgotPword = By.cssSelector("[href*='password/new']");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPword() {
		return driver.findElement(pword);
	}

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

	public  ForgotPassword forgotPassword() {
		driver.findElement(forgotPword).click();
		ForgotPassword fp = new ForgotPassword(driver);
		return fp;
	}

}
