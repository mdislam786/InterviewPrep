package takesScreenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class CaptureScreenshot {
	@Test
	public static void captureScreenMethod() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			driver.get("http://techfios.com/test/billing/?ng=login/");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("techfiosdemo@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc124"); // Failing the test
																						// intentionally by providing
																						// wrong password so it will go
																						// to the catch block and will
																						// take screenshot.
			driver.findElement(By.xpath("//button[@name='login']")).click();
			String actualText = driver.findElement(By.xpath("//span[@class='hidden-xs']")).getText();
			Assert.assertEquals("Welcome TechFios Tester", actualText);
			
		} catch (Exception e) {

			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".\\screenshotImages\\TestFailingScreenShot.png"));
		}
		driver.close();
		driver.quit();

	}

}
