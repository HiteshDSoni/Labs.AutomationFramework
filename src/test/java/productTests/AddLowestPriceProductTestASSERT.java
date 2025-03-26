package productTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddLowestPriceProductTestASSERT extends BaseClass {

	@Test
	public void tc_002_addLowestPriceProductToCartTest() throws IOException, InterruptedException {

		System.out.println("Test Started--- Done");

		// Read the data
		String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 4, 3);

		// Navigate To Product and click on it
		InventoryPage ip = new InventoryPage(driver);
		System.out.println("Product name selected is : " + PRODUCTNAME);
		Thread.sleep(2000);
		ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
		System.out.println(driver.getTitle());

		// Add product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getItemName();

		Assert.assertEquals(productInCart, PRODUCTNAME);

		Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		System.out.println("Assertion --- done");

	}

}
