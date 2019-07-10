package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragCursorToSomeExtent {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("https://ubuntu.com/download/desktop/thank-you?country=IN&version=18.04.2&architecture=amd64");

		WebElement slider = driver.findElement(By.xpath("//input[@id='amount-community']"));
		Actions move = new Actions(driver);
		move.dragAndDropBy(slider, 30, 0).build().perform();
	}
}
