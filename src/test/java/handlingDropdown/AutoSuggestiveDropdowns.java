package handlingDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class AutoSuggestiveDropdowns extends TestBase {
	@Test
	public void autoSuggestiveDropdowns() throws Exception {
		initialize();

		driver.get("https://ksrtc.in/oprs-web/");

		WebElement dropdownEditbox = driver.findElement(By.xpath("//input[@id='fromPlaceName']"));

		dropdownEditbox.sendKeys("beng");
		Thread.sleep(2000);

		dropdownEditbox.sendKeys(Keys.ARROW_DOWN);

		// Since the Texts are not visible in the boardingPlace editBox, it will not
		// print any text using .getText method:
		System.out.println((dropdownEditbox.getText()));

		// It's only achievable by using JavascriptExecutor API of Javascript DOM :
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"fromPlaceName\").value;"; // its a Javascript command to get
																					// the hiddenText from the editBox.
		
		String text = (String) js.executeScript(script);
		System.out.println(text);

		int i = 0;
		while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			i++;
			dropdownEditbox.sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			if (i > 5) {
				break;
			}

		}
		if (i > 5) {
			System.out.println("Element is not found!");
		}
		driver.quit();
	}

}
