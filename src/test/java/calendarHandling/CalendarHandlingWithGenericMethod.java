package calendarHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class CalendarHandlingWithGenericMethod extends TestBase {
	@Test
	public void handleCalendarWithGenericMethod() throws Exception {
		initialize();

		driver.get("https://www.path2usa.com/travel-companions");

		// July 14
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("July")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();

		}

		// Grab the common attribute and put them into a list and iterate.
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();

			if (text.equalsIgnoreCase("14")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
		Thread.sleep(2000);

		driver.quit();

	}

}
