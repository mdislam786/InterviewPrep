package mouseHover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import util.TestBase;

public class MouseHoverTest extends TestBase{
	@Test
	public void mouseHover() throws Exception {
		initialize();
		driver.get("http://only-testing-blog.blogspot.com/p/mouse-hover.html");
		
		WebElement searchEngine = driver.findElement(By.xpath("//div[contains(text(),'Search Engine')]"));
		WebElement clickYahoo = driver.findElement(By.xpath("//a[contains(text(),'Yahoo')]"));
		
		Thread.sleep(4000);
		
		Actions a = new Actions(driver);
		a.moveToElement(searchEngine).moveToElement(clickYahoo).click().perform();
		
		// To verify user clicked on the yahoo link:
		System.out.println(driver.getTitle());
		
		
		driver.quit();
		
		
	}

}
