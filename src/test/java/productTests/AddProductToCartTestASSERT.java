package productTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddProductToCartTestASSERT extends BaseClass {

	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{

		System.out.println("Test Started--- Done");

		//Read the data
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

		Assert.assertEquals(productInCart, productAdded);

		Assert.assertTrue(productInCart.equals(productAdded));
		System.out.println("Assertion --- done");

	}

}
