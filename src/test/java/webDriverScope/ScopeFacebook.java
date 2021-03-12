package webDriverScope;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class ScopeFacebook extends TestBase{
	@Test
	public void webDriverScopeFacebook() throws Exception {
		initialize();
		
		driver.get("https://www.facebook.com/");

		// TestCase1:Get me the total count of links on the page.
		// To get the count of links of the entire page:
		System.out.println("Link counts of entirePage : " + driver.findElements(By.tagName("a")).size());

		// TestCase2: Get me the link counts of the footerSection.
		WebElement footerdriver = driver
				.findElement(By.xpath("//ul[@class='uiList pageFooterLinkList _509- _4ki _703 _6-i']"));
		System.out.println("Link counts of footerSection : " + footerdriver.findElements(By.tagName("a")).size());

		// TestCase3:Click on each link of footerSection and check if
		// the pages are opening by printing the title in the console?

		// to open every link of footerSection using forLoop:

		for (int i = 1; i < footerdriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerdriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(2000L);
		}

		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

		driver.quit();
		
	}

}
