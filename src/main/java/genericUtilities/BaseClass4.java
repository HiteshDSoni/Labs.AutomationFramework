package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations of TestNG
 * 
 * @author Hitesh S
 */

public class BaseClass4 {

	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();

	public WebDriver driver;

	//@BeforeTest
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("BeforeSuite --- Done");
		System.out.println("-----Database Connection Successful-----");

	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void bcConfig(String ParameterValue) throws IOException {
		String URL = fUtil.readDataFromPropertyFile("url");

		//For Cross Browser Execution - run time polymorphism
		if(ParameterValue.equals("edge"))
		{
		driver = new EdgeDriver();
		}
		else if(ParameterValue.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(ParameterValue.equals("firefox"))
		{
		driver = new FirefoxDriver();
		}
		else
		{
		driver = new ChromeDriver();
		}

		
		//driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);

		driver.get(URL);
		System.out.println("BeforeClass --- Done");
		System.out.println("-----Browser launch successful-----");
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("BeforeMethod --- Done");
		System.out.println("-----Login to App successful-----");
	}

	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();

		System.out.println("AfterMethod --- Done");
		System.out.println("-----Logout of App successful-----");
	}

	@AfterClass(alwaysRun = true)
	public void acConfig() {

		driver.quit();
		System.out.println("AfterClass --- Done");
		System.out.println("-----Browser closure successful-----");
	}

	//@AfterTest
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("AfterSuite --- Done");
		System.out.println("-----Database closure successful-----");
	}
}
