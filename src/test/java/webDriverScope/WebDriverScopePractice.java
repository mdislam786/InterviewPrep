package webDriverScope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class WebDriverScopePractice extends TestBase {

	@Test
	public void webDriverScoope() throws Exception {
		// TestCase1:Get me the total count of links on the page.
		// TestCase2: Get me the link counts of the footerSection.
		// TestCase3:Get me the link counts of the 1st column of footerSection.
		// TestCase4:Click on each link of the 1st column of footerSection and check if
		// the pages are opening?

		initialize();

		driver.get("http://qaclickacademy.com/practice.php");

		// TestCase1:Get me the total count of links on the page.
		
		// To get the count of links of the entire page:
		System.out.println("Link counts of entirePage : " + driver.findElements(By.tagName("a")).size());

		// TestCase2: Get me the link counts of the footerSection.
		
		// First figure it out of footerSection area: By using WebElement argument,
		// and making a miniDriver called footerdriver and limitingthe scope of the
		// WebDriver(driver): which has all the functions
		// available to the WebDriver(driver).
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Link counts of footerSection: " + footerdriver.findElements(By.tagName("a")).size());
		
		

		// TestCase3:Get me the link counts of the 1st column of footerSection.

		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(
				"Link counts of the 1st column of footerSection: " + columndriver.findElements(By.tagName("a")).size());
		
		

		// TestCase4:Click on each link of the 1st column of footerSection and check if
		// the pages are opening?

		// forLoop To open every tab:
		for (int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(2000L);
		}

		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();

		// whileLoop to get the titles of every window opened:
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		driver.quit();

	}

}
