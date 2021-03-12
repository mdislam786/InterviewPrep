package seleniumWaitsOrSynchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitTest {

	@Test
	public void explicitWait() {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'Start')]"));
		startButton.click();

		WebElement toBeDisplayedButton = driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions .visibilityOfElementLocated(By.
		 * xpath("//span[contains(text(),'New York Hilton Midtown')]"))); wait.until(
		 * ExpectedConditions.elementToBeClickable(By.
		 * xpath("//span[contains(text(),'New York Hilton Midtown')]"))) .click();
		 */

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(toBeDisplayedButton));
		wait.until(ExpectedConditions.elementToBeClickable(toBeDisplayedButton)).click();
		
		
		System.out.println(toBeDisplayedButton.isDisplayed());
		System.out.println(toBeDisplayedButton.getText());
		
		driver.quit();

	}

}
