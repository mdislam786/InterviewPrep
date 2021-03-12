package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(TestBase.class);

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\util\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("internetExplorer")) {
			System.setProperty("webdriver.ie.driver", ".\\drivers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(prop.getProperty("url"));
	}

	public void captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(sourceFile, new File(".\\ScreenshotImages\\" + screenshotName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
