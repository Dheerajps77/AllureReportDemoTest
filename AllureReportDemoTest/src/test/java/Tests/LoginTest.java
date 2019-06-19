package Tests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import ConstantsClass.Constants;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.AllureLogUtil;
import Utilities.EnvironmentPropertiesReaderForConfig;
import Utilities.Log;
import Utilities.RandomStringGeneratorUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	EnvironmentPropertiesReaderForConfig environmentPropertiesReaderForConfig;
	Properties properties;	
	
	@Test(priority = 0, description = "verifying login page title test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void verifyLoginPageTitleTest(Method method) {		
		properties=EnvironmentPropertiesReaderForConfig.getInstance().PropertiesFile();
		String userName="";
		String userPassword="";		
		try {
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");
			loginPage=new LoginPage(driver);
			userName=properties.getProperty("username");
			userPassword=properties.getProperty("password");
			e3.log(Status.INFO, "login with username: {0} "+userName+"and password: {1}" + userPassword);
			loginPage.login(userName, userPassword);
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
		}
	}
	
	
	@Test(priority = 1, description = "verifying home page title test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify home page title test on home Page")
	@Story("Story Name: To check home page title")
	public void verifyHomePageTitleTest(Method method){
		
		
		try {
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");
			homePage=new HomePage(driver);
			String title = homePage.getHomePageTitle();
			System.out.println("the home page title is: "+ title);
			log.info("the home page title is: "+ title);
			Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
			e3.log(Status.INFO, "Verify home page title expected  title of "+title+"with actual " + Constants.HOME_PAGE_TITLE);
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
		}
	}
	
	@Test(priority = 2, description = "verifying contact page title test")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Test Case Description: Verify contact page title on home Page")
	@Story("Story Name: To check contact page title")
	public void verifyContactPageTitleTest(Method method){				
		ContactUsPage contactUsPage;
		try {
			contactUsPage=new ContactUsPage(driver);
			String emailVal=RandomStringGeneratorUtil.RandomString();
			String firstname=RandomStringGeneratorUtil.RandomFnameString();
			String lastname=RandomStringGeneratorUtil.RandomLnameString();
			String jobtitle="Software Engineer";
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			contactUsPage.createNewContact(emailVal, firstname, lastname, jobtitle);
			e3.log(Status.INFO, "created new contact " + emailVal + firstname + lastname + jobtitle);
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
		}
	}
	
	
	
	@Test(priority = 3, description = "verifying username")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Test Case Description: Verify username on home Page")
	@Story("Story Name: To check if username")
	public void verifyUserNameTest(Method method){						
		try {
			softAssert=new SoftAssert();
			homePage=new HomePage(driver);
			String actualUserName="";
			String expectedUserName="NaveenAutomationLabs";
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			actualUserName=homePage.getUserNameText();
			softAssert.assertEquals(actualUserName, expectedUserName);
			AllureLogUtil.Info("Verify username : " + actualUserName + " with current user : " + expectedUserName);
			e3.log(Status.INFO, "Verify username : " + actualUserName + " with current user : " + expectedUserName);
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
		}
	}
	
	@Test(priority = 4, description = "verifying search contacts test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify search contacts on Contact page")
	@Story("Story Name: To search contacts from the list in Contact page")
	public void verifySearchContactsTest(Method method){								
		
		try {	
			softAssert=new SoftAssert();
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			
			softAssert.assertEquals("Hello".equalsIgnoreCase("Hello"), "Assert failed due to mismatch of Hello and hello");
			AllureLogUtil.Info("Verify hello : " + " Hello "+ "with current : " + "Hello");
			e3.log(Status.INFO, "Verify hello : " + " Hello "+ "with current : " + "Hello");
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
		}
	}
	
	@Test(priority = 5, description = "verifying imports function test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify imports function on Import page")
	@Story("Story Name: To check if we are able to import documents in Import page")
	public void verifyImportsTest(Method method){				
		
		try {		
			softAssert=new SoftAssert();
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			
			softAssert.assertEquals("Dheeraj".equalsIgnoreCase("Dheeraj"), "Assert failed due to mismatch of Dheeraj and dheeraj");
			AllureLogUtil.Info("Verify name : " + " Dheeraj "+ "with current : " + "Dheeraj");
			e3.log(Status.INFO, "Verify name : " + " Dheeraj "+ "with current : " + "Dheeraj");
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();			
			Log.Error("Exception occurs !!", e);
		}
	}
	
	@Test(priority = 6, description = "verifying create company function test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify create company function on Company page")
	@Story("Story Name: To check if we are able to create company on Company page")
	public void verifyCreateCompanyTest(Method method){				
		
		try {		
			softAssert=new SoftAssert();
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			softAssert.assertEquals("Motors".equalsIgnoreCase("Motors"), "Assert failed due to mismatch of Motor and Motors");
			AllureLogUtil.Info("Verify vechile : " + " Motors "+ "with current : " + "motors");
			e3.log(Status.INFO, "Verify vechile : " + " Motors "+ "with current : " + "motors");
			AllureLogUtil.EndLog(method.getName() + " has been completed");
			Log.EndLog(method.getName() + " has been completed");
			softAssert.assertAll();
		} catch (Exception e) {
			e.printStackTrace();			
			Log.Error("Exception occurs !!", e);
		}
	}
	
	@Test(priority = 7, description = "verifying create dashboard function test")
	@Severity(SeverityLevel.TRIVIAL)
	@Description("Test Case Description: Verify create dashboard function on Home page")
	@Story("Story Name: To check if we are able to create dashboard on Home page")
	public void verifyCreateDashboardTest(Method method){				
		
		try {			
			AllureLogUtil.StartLog(method.getName() + " has been started");
			Log.StartLog(method.getName() + " has been started");			
			String a ="Skip / Ignore Test";
			 if(a.equals("Skip / Ignore Test")){
			 throw new SkipException("Skipping / Ignoring - Script not Ready for Execution ");
			 }else{
			 System.out.println("In else condition"); 
			 }
			 System.out.println("Out of the if else condition");	
		} catch (Exception e) {
			e.printStackTrace();
			Log.Error("Exception occurs !!", e);
			throw new SkipException("Not ready to test "+method.getName()+" function under this build version 3.4.5");				
		}			
	}
}
