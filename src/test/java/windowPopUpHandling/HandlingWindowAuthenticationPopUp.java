package windowPopUpHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowAuthenticationPopUp {

	public static void main(String[] args) {

		// HandlingWindowAuthenticationPopUp is easily done By following the syntax
		// https://Username:Password@SiteURL

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.get("https://the-internet.herokuapp.com/");

		driver.get("https://admin:admin@the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Basic Auth")).click();

	}

}
