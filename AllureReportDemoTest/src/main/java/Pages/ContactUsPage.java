package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.AllureLogUtil;
import io.qameta.allure.Step;

public class ContactUsPage {

	protected WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactBtn;

	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondBtn;

	@FindBy(xpath = "//input[@id='uid-ctrl-1']")
	WebElement email;

	@FindBy(xpath = "//input[@id='uid-ctrl-2']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='uid-ctrl-3']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='uid-ctrl-5']")
	WebElement jobTitle;
	
	@FindBy(how=How.XPATH, using="//a[@href='https://app.hubspot.com/reports-dashboard/5004418' and @data-tracking='click hover']//following::a[@id='nav-primary-contacts-branch' and @data-tracking='click hover']")
	WebElement contactMenuButton;
	
	@FindBy(how=How.XPATH, using="//li[@class='expandable active']//a[@href='https://app.hubspot.com/contacts/5004418/contacts' and @data-tracking='click' and @id='nav-secondary-contacts']")
	WebElement contactButton;
	
	@Step("Create new contact with these details : {0}, {1}, {2} and {3} ")
	public void createNewContact(String emailVal, String firstname, String lastname, String jobtitle) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			
			wait.until(ExpectedConditions.elementToBeClickable(contactMenuButton));
			contactMenuButton.click();
			
			wait.until(ExpectedConditions.visibilityOf(contactButton));
			contactButton.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
			createContactBtn.click();
						
			wait.until(ExpectedConditions.elementToBeClickable(email));
			email.sendKeys(emailVal);

			wait.until(ExpectedConditions.elementToBeClickable(firstName));
			firstName.sendKeys(firstname);

			wait.until(ExpectedConditions.elementToBeClickable(lastName));
			lastName.sendKeys(lastname);

			wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
			jobTitle.sendKeys(jobtitle);

			wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
			createContactSecondBtn.click();
			AllureLogUtil.Info("Created new contact using below details :- ");
			AllureLogUtil.Info("Email value -- " + emailVal + " First name -- " + firstname + " Last name -- " + lastname + " Job tile -- " + jobtitle);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
