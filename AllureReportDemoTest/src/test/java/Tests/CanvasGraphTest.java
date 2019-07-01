package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.interactions.internal.MouseAction;

public class CanvasGraphTest {

	static String chromePath = "";
	static String ffPath = "";
	static WebDriver driver;

	public static void InvestaCanvasImageHandling() throws InterruptedException, AWTException {
		/*
		 * char a='a'; char a1='a';
		 * 
		 * StringBuffer sbBuffer=new StringBuffer().append(a).append(a1);
		 * 
		 * System.out.println(sbBuffer.toString()); char a2=(char) (a+a1);
		 */
		// System.out.println('a'+'h');

		/*
		 * { int i;
		 * 
		 * for(i = 0; i <= 255; i++) { System.out.println(" The ASCII value of " +
		 * (char)i + "  =  " + i); } }
		 */
		
		chromePath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";		
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		//ffPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
		//System.setProperty("webdriver.gecko.driver", ffPath);
		//driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("https://bank.qa.investasolutions.com/#/portfolio-model/5cfa28d174174e496c3c3387");

		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john.doe@magic-bank.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("magic");
		driver.findElement(By.xpath("//button[contains(text(),' LOG IN')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#/portfolio-model-list']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='ui-table-wrapper ng-star-inserted']//table//tbody//tr[1]//td[1]"))
				.click();
		driver.findElement(By.xpath("//a[@id='ui-tabpanel-2-label']")).click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		jsExecutor.executeScript("window.scrollBy(0,350)");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//canvas[@class='chartjs-render-monitor']"));
		driver.findElement(By.xpath("//canvas[@class='chartjs-render-monitor']")).click();
		Thread.sleep(2000);

		Point point = element.getLocation();

		int xPixelValue = 536;
		int yPixelValue = 712;

		int yaxis = element.getLocation().y;
		int xaxis = element.getLocation().x;

		int width = element.getSize().width;
		int height = element.getSize().height;

		System.out.println("y-axis : " + yaxis + "\nx-axis " + xaxis + "\nwidth " + width + "\nheight " + height);
		Robot r = new Robot();
		Actions action = new Actions(driver);
		// action.contextClick(element).build().perform();
		// action.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		
		action.moveByOffset(xaxis + width / 2, yaxis + height / 2 + 70).build().perform();
		Thread.sleep(2000);
		action.moveToElement(element).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		/*
		 * //Below code is used to mouse move on particular axises
		 * r.mouseMove(xaxis+width/2, yaxis+height/2+70); Thread.sleep(2000); Actions
		 * action=new Actions(driver); action.moveByOffset(xaxis+width/2,
		 * yaxis+height/2+70).build().perform(); Thread.sleep(2000);
		 * action.doubleClick(element).build().perform(); Thread.sleep(2000);
		 */

		/*
		 * int newwidth=width-60; Thread.sleep(2000); r.mouseMove(xPixelValue,
		 * yPixelValue); action.moveByOffset(xPixelValue,
		 * yPixelValue).build().perform(); element.click();
		 */

		// action.moveToElement(element).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	}

	public static void GoogleRightClickOnImageHandling() throws InterruptedException, AWTException {
		chromePath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
		WebElement textBoxElement = driver.findElement(By.name("q"));
		textBoxElement.sendKeys("selenium");
		textBoxElement.submit();
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("logo")).findElement(By.tagName("img"))).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Robot RoboKey = new Robot();
		RoboKey.keyPress(KeyEvent.VK_W);
		RoboKey.keyPress(KeyEvent.VK_A);
		RoboKey.keyPress(KeyEvent.VK_M);
		RoboKey.keyPress(KeyEvent.VK_A);
		RoboKey.keyPress(KeyEvent.VK_N);
		RoboKey.keyPress(KeyEvent.VK_PERIOD);
		RoboKey.keyPress(KeyEvent.VK_J);
		RoboKey.keyPress(KeyEvent.VK_P);
		RoboKey.keyPress(KeyEvent.VK_G);
		Thread.sleep(2000);
		RoboKey.keyPress(KeyEvent.VK_ENTER);

	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		InvestaCanvasImageHandling();

	}

}
