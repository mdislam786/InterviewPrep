package handlingMultipleWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.TestBase;

public class HandlingMultipleWindowsAssignment extends TestBase {
	@Test
	public void handleWindows2() {
		initialize();

		driver.get("https://the-internet.herokuapp.com/windows");

		// Opening childWindow
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		// To get the ID's of every windows opened and to save it in a set
		Set<String> windowIds = driver.getWindowHandles();

		// To iterate through the id set from Parent to child
		Iterator<String> it = windowIds.iterator();

		// to get to parentWindow:
		String parentWindow = it.next();

		// to get to the childWindow :
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		// to switch back to Parent window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

		driver.quit();

	}
}