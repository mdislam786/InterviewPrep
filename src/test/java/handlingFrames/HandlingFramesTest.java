package handlingFrames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestBase;

public class HandlingFramesTest extends TestBase {

	@Test
	public void handleFrame() throws Exception {

		driver.get("http://jqueryui.com/droppable/");

		// to get the count of frames;
		System.out.println(driver.findElements(By.tagName("iframe")).size());

		// to switch to frame using WebElement argument.
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

		// to confirm that you are inside the frame.
		System.out.println(driver.findElement(By.xpath("//div[@id='draggable']")).isDisplayed());
		
		// Taking screenshot before Action 
		captureScreenshot(driver, "beforeAction");

		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));

		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));

		Thread.sleep(2000);

		Actions actions = new Actions(driver);

		// To drag and drop
		actions.dragAndDrop(source, target).build().perform();
		Thread.sleep(2000);

		// To switch back to the default content in order to any other task outside of
		// frame:
		driver.switchTo().defaultContent();
		
		// Taking screenshot after Action 
		captureScreenshot(driver, "afterAction");

		// to click on Accept Example.
		driver.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();
	}

	@BeforeTest
	public void startUp() {
		initialize();
	}

	@AfterTest
	public void shutDown() {
		tearDown();
	}

}
