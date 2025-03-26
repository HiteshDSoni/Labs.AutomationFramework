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
 * This class provides implementation to ITestListner interface of TestNG and
 * Extent Reports configuration
 * 
 * @author Hitesh S
 */
public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test execution Started");

		// Create Test in Extent Report
		test = report.createTest(methodName);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test PASS");

		// Log the status PASS in extent report
		test.log(Status.PASS, methodName + " - @Test PASS");

	}

	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test FAIL");

		System.out.println(result.getThrowable());

		// Log the status FAIL in Extent Reports
		test.log(Status.FAIL, methodName + " - @Test FAIL");
		test.log(Status.WARNING, result.getThrowable());

		// Capture Screenshot
		SeleniumUtility2 s = new SeleniumUtility2();
		JavaUtility j = new JavaUtility();

		String screenshotName = methodName + "-" + j.getSystemDateInFormat();

		try {
			String path = s.captureScreenShot(BaseClass.driver, screenshotName);

			// Attach the screenshot to Extent Report
			test.addScreenCaptureFromPath(path);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - @Test SKIP");

		System.out.println(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

		System.out.println("Suite execution started");

		// Basic Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(
				".\\ExtentReports\\Report - " + new JavaUtility().getSystemDateInFormat() + ".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setReportName("Automation Execution Report");
		esr.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Google Chrome");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Base URL", "https://www.saucedemo.com/");
		report.setSystemInfo("Reporter name", "Hitesh");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Suite execution finished");

		// Generate the extent Reports
		report.flush();

	}

}
