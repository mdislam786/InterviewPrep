package seleniumWaitsOrSynchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImplicitWait {
	
	@Test
	public void implicitWait() {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();			
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		
		// Implicit wait applies to the all the elements in a page.
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.quit();
		

		
	}

}
