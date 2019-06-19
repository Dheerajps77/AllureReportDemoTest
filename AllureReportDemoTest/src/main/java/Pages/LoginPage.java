package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AllureLogUtil;
import io.qameta.allure.Step;

public class LoginPage {
	
	protected WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id = "username")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText = "Sign up")
	WebElement signUpLink;
	
	@Step("login with username: {0} and password: {1} ")
	public void login(String un, String pwd){
		
		try {
			AllureLogUtil.log("Enter email value : " + un);
			emailId.sendKeys(un);
			AllureLogUtil.log("Enter email value : " + pwd);
			password.sendKeys(pwd);
			AllureLogUtil.log("Click on login button");
			loginButton.click();		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
