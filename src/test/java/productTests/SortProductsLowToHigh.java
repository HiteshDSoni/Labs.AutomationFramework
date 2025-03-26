package productTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility2;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class SortProductsLowToHigh {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		//Create Object Of Utility Classes
		SeleniumUtility2 sUtil = new SeleniumUtility2();
		FileUtility fUtil = new FileUtility();
		
		//Read the Required Data
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		//load the URL
		driver.get(URL);
		
		//Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Navigate To Product and click on it
		InventoryPage ip = new InventoryPage(driver);
		ip.getSortDropDown().click();
		ip.sortProduct(driver, SORTOPTION);
		
		
		//String productsSorted = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
						
		//Validate the products details
								
		
		
		
	}

}
