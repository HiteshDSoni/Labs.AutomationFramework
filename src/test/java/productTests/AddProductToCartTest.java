package productTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import genericUtilities.SeleniumUtility2;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductToCartTest extends SeleniumUtility2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// Create Object Of Utility Classes
		SeleniumUtility2 sUtil = new SeleniumUtility2();
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 1, 2);

		// Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		// load the URL
		driver.get(URL);

		// Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

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
	}

}
