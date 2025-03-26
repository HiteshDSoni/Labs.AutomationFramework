package productTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTestTESTNG extends BaseClass {

	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{

		System.out.println("Test Started--- Done");

		//Read the data
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);

		// Navigate To Product and click on it
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);

		// Add product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();

		if (productInCart.equals(productAdded)) {
			System.out.println("pass");
			System.out.println(productInCart);

		} else {
			System.out.println("fail");

		}

		System.out.println("Test Completed --- Done");

	}

}
