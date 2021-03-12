package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.TestBase;

public class TechfiosDatabaseTest extends TestBase{
	@Test
	public void techfiosDatabaseTest() throws ClassNotFoundException, SQLException {		
		// com.mysql.jdbc.Driver got replaced by the following:
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("JDBC loaded");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techfios", "root", "admin");
		System.out.println("Connection established!");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM spring");

		while (rs.next()) {
			String Email = rs.getString("email");
			String Password = rs.getString("password");

			System.out.println(Email);
			System.out.println(Password);
			
			//initialize();
			
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://techfios.com/test/billing/?ng=login/");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[@name='login']")).click();
			
			//To validate its logged in with data from the database
			captureScreenshot(driver, "techfiosDatabaseTest");			
			driver.quit();			
		}
	}
}
