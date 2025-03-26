package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListner interface of TestNG
 * @author Hitesh S
 */
public class ListenerImplementation2 implements ITestListener {

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - @Test execution Started");
		
	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - @Test PASS");
		
	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - @Test FAIL");

		System.out.println(result.getThrowable());
		
		//Capture Screenshot
		SeleniumUtility2 s = new SeleniumUtility2();
		JavaUtility j = new JavaUtility();
		
		String screenshotName = methodName+"-"+j.getSystemDateInFormat();

		try{
			s.captureScreenShot(BaseClass.driver,screenshotName);
		}catch (IOException e){
		e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - @Test SKIP");

		System.out.println(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	
		System.out.println("Suite execution started");
	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite execution finished");

	}


	
	
}
