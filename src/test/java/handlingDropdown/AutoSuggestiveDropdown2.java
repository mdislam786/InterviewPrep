package handlingDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class AutoSuggestiveDropdown2 extends TestBase {

	@Test
	public void autoSuggestiveDropdown2() throws Exception {
		initialize();
		driver.get("http://qaclickacademy.com/practice.php");

		// Target is to select United States from the Dropdowns:
		WebElement dropdownEditbox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		dropdownEditbox.sendKeys("uni");
		Thread.sleep(2000);

		dropdownEditbox.sendKeys(Keys.ARROW_DOWN);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String countryEditboxText = (String) js.executeScript(script);
		System.out.println(countryEditboxText);

		int i = 0;
		while (!countryEditboxText.equalsIgnoreCase("United States")) {
			i++;
			dropdownEditbox.sendKeys(Keys.ARROW_DOWN);
			countryEditboxText = (String) js.executeScript(script);
			System.out.println(countryEditboxText);
			if (i > 8) {
				break;
			}
		}

		if (i > 8) {
			System.out.println("Sorry! Element not present.");
		}

		driver.quit();

	}
}