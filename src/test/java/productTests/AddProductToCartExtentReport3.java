package productTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

//Created on March 20, 2025 12:10 PM

@Listeners(genericUtilities.ListenerImplementation.class)
public class AddProductToCartExtentReport3 extends BaseClass {

	@Test
	public void tc_001_AddProductToCartTest() throws IOException {

		System.out.println("Test Started--- Done");

		// Read the data
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

		// Modify this assertion to intentionally fail:
		Assert.assertEquals(productInCart, productAdded);  // This will fail intentionally
		Assert.assertTrue(productInCart.equals(productAdded));
		System.out.println("Assertion --- done");

		
	}

	@Test
	public void tc_002_sampleTest()
	{
		System.out.println("sampleTest_RegressionSuite --- Done");

	}
}
