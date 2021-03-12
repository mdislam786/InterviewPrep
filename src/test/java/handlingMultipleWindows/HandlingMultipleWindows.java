package handlingMultipleWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.TestBase;

public class HandlingMultipleWindows extends TestBase{
	@Test 
	public void handleWindows() {
		initialize();
		
		driver.get("https://www.msn.com/");

		// Opening firstChild window
		driver.findElement(By.xpath("//h3[contains(text(),'Shopping')]")).click();

		// Opening secondChild window
		driver.findElement(By.xpath("//h3[contains(text(),'Skype')]")).click();		

		//To get the ID's of every windows opened and save it in a set
		Set<String> windowsIds = driver.getWindowHandles();
		
		//To iterate through the id set from Parent to child
		Iterator<String>it= windowsIds.iterator();
		
		// to get to ParentWindow:
		String ParentWindow = it.next();
		System.out.println(driver.getTitle());
		
		// to get to the firstChildId :
		String firstChildWindow = it.next();
		driver.switchTo().window(firstChildWindow);
		System.out.println(driver.getTitle());
		
		//to get the secondChildId :
		String secondChildWindow = it.next();
		driver.switchTo().window(secondChildWindow);
		System.out.println(driver.getTitle());
		
		// to switch back to Parent window
		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getTitle());

		driver.quit();

		
	}

}
