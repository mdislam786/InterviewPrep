package handlingTitle;

import org.testng.annotations.Test;

import junit.framework.Assert;
import util.TestBase;

public class TitleTest extends TestBase{
	
	@Test
	public void getTitle() {
		initialize();
		driver.get("https://www.amazon.com/");
		
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
		driver.quit();
	}

}
