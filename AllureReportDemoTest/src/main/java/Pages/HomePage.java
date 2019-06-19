package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ConstantsClass.Constants;

public class HomePage {

	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='private-page__title']")
	WebElement homePageHeader;

	@FindBy(xpath = "//li[@class='expandable ']//a[@id='nav-primary-contacts-branch']")
	WebElement contactsTab;

	@FindBy(xpath = "//div[@class='secondary-nav expansion']//following::div[@aria-label='Contacts']//li[@role='none']//a[@id='nav-secondary-contacts' and @role='menuitem' and contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath="//a[@id='account-menu']//span")
	WebElement userNameText;
	
	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}

	public boolean verifyHomePageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePageHeader));
		return homePageHeader.isDisplayed();
	}

	public String getHomePageHeaderText() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(homePageHeader));
		return homePageHeader.getText();
	}
	
	public String getUserNameText() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(userNameText));
		return userNameText.getText();
	}
}
