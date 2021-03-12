package handlingDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestBase;

public class dropdownTest extends TestBase {

	@Test
	public void selectFromDropdown() throws Exception {
		driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
		WebElement selectCountry = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(selectCountry);
		Thread.sleep(3000);

		select.selectByVisibleText("ALBANIA");
		Thread.sleep(3000);

		// To capture Screenshot to match the requirement. captureScreenshot() is
		// available in the TestBase class which was extended to.
		captureScreenshot(driver, "selectedCountry");

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
