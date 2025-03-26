
/*
 * @ Author Hitesh
 * 
 * Script for Login into the application, 
 * sort the products low to high, add to cart and logout
 * 
*/

package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Remove {

		@Test
		public void remove() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		WebElement ele = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));

		Select s = new Select(ele);
		s.selectByVisibleText("Price (low to high)");
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).isDisplayed());
		driver.findElement(By.id("remove-sauce-labs-onesie")).click();

		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.close();
	}
}

