package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to Java
 * 
 * @author Hitesh S
 * 
 */
public class SeleniumUtility {

	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();

	}

	/**
	 * This below method is used for Implicit wait of 20 seconds
	 * 
	 * @param driver
	 * @throws InterruptedException if Thread.sleep(5000) used
	 */
	public void addImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Thread.sleep(5000);
	}

	/**
	 * This below method is used for element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClickWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for element to be visible in DOM
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForVisibililtyOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//Below we are using method overloading, same method, different parameters
	/**
	 * This method is used to select the dropdown using index
	 *@param dropdown
	 *@param value	
	 */
	public void handleDropdown(WebElement dropdown, int index) {
	Select sel=new Select(dropdown);
	sel.selectByIndex(index);
	}

	
	/**
	 * This method is used to select the dropdown using index
	 * @param value
	 * @param dropdown
	 */
	public void handleDropdown(String value, WebElement dropdown) {
		Select sel3=new Select(dropdown);
		sel3.selectByValue(value);
	
	}
	
	// Other methods 
	
	 // Mouse Hover
    public void mouseHover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Scroll to Element
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Drag and Drop
    public void handleActions(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    // Context Click (Right Click)
    public void handleActions(WebElement element, WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    // Double Click
    public void handleActions(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    
    
}
