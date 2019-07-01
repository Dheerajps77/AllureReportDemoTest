package Tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandles {

	static WebDriver driver;

	public static ArrayList<String> ReturnWindowsName() {
		String titleNameOfCurrentWindowInvokedString = null;
		String currentWindowName = null;
		ArrayList<String> listOfWindowName = new ArrayList<String>();
		try {

			Set<String> windowNameSet = driver.getWindowHandles();
			Iterator<String> iterator = windowNameSet.iterator();

			while (iterator.hasNext()) {
				currentWindowName = iterator.next();
				titleNameOfCurrentWindowInvokedString = driver.switchTo().window(currentWindowName).getTitle();
				listOfWindowName.add(titleNameOfCurrentWindowInvokedString);
				System.out.println(titleNameOfCurrentWindowInvokedString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listOfWindowName;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.get("http://www.naukri.com/");
		ArrayList<String> windowNames = null;
		windowNames = ReturnWindowsName();
		if (windowNames.contains("Cognizant")) {
			driver.close();
		} else if (windowNames.contains("Xoriant")) {
			driver.close();
		} else if (windowNames.contains("Genpact")) {
			driver.close();
		}
		
		
		
	}

}
