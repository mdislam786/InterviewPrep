package handlingWebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import util.TestBase;

public class HandlingWebTables extends TestBase{
	@Test
	public void handleWebTables() {
		initialize();
		
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/20246/aus-vs-wi-match-10-icc-cricket-world-cup-2019");

		driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int sum = 0;
		int rowcount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();

		for (int i = 0; i < count - 2; i++) {
			String value = table
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText();
			int valueInteger = Integer.parseInt(value);
			sum = sum + valueInteger;
		}
		// System.out.println(sum);

		String Extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		int extrasValue = Integer.parseInt(Extras);
		int totalSumValue = sum + extrasValue;
		System.out.println(totalSumValue);

		String actualTotalValue = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]"))
				.getText();
		int actualTotalValueInteger = Integer.parseInt(actualTotalValue);
		if (totalSumValue == actualTotalValueInteger) {
			System.out.println("Count matches.");

		} else {
			System.out.println("Sorry! It's not working.");
		}

		driver.quit();
		
		
	}

}
