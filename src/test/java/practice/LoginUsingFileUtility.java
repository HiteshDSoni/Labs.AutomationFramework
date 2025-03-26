package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;

/*
 * Script for Login into the application and logout
 * Using FileUtility from genericUtilities
 * @author Hitesh S
 * 
 * Time created	12 March 2025, 12:01:01 pm
 * 
 * Time last modified	13 March 2025, 12:05:02 pm
 * 
*/

public class LoginUsingFileUtility {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		FileUtility file = new FileUtility();
		//String URL = file.readDataFromPropertyFile("url");
		String username = file.readDataFromPropertyFile("username");
		String password = file.readDataFromPropertyFile("password");

		driver.get(file.readDataFromPropertyFile("url"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Done");
		
		// driver.quit();
	}
}
