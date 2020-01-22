package baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReportsClass;

public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	public static void setUp() {
		ReportsClass.startUp();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterSuite
	public static void tearDown() {
		driver.quit();
		ReportsClass.endTest();
	}

	public void openBrowser(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void openNewTab() {
		((JavascriptExecutor) driver).executeScript("window.open();");
	}

	public void waitFor1Sec() throws Exception {
		Thread.sleep(1000);
	}

	public void waitFor2Sec() throws Exception {
		Thread.sleep(2000);
	}

	public void waitFor3Sec() throws Exception {
		Thread.sleep(3000);
	}

	public void waitFor4Sec() throws Exception {
		Thread.sleep(4000);
	}

	public void waitFor5Sec() throws Exception {
		Thread.sleep(5000);
	}

	public void waitFor10Sec() throws Exception {
		Thread.sleep(10000);
	}

	// User defined method to check the alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
