package handlingAlerts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.TestBase;

public class HandlingAlerts extends TestBase {
	@Test
	public void alertHandle(){
		initialize();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();

		System.out.println(driver.switchTo().alert().getText());		

		driver.switchTo().alert().accept(); // to click ok,done,yes
		
		driver.quit();
	}

}
