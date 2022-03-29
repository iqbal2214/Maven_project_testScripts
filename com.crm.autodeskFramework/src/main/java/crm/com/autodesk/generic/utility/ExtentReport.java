package crm.com.autodesk.generic.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
	// step 3: create a test method during the test execution start
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//step 4: log the pass method
		test.log(Status.PASS,result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//step 5: take screenshot ,attach screenshot to extend report,add exception log
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		WebDriverUtility webUtils=new WebDriverUtility();
		String path=null;
		try {
			path=webUtils.takeScreenShotwithReturnPath(BaseClass.sDriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//step 5: log skip methods and throw exception
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}


	@Override
	public void onStart(ITestContext context) {
		//step 1: extent report configuration
		ExtentSparkReporter extentReport=new ExtentSparkReporter("./extentreport"+new JavaUtilities().getSystemDateAndTime()+".html");
		extentReport.config().setReportName("com.crm.autodesk");
		extentReport.config().setDocumentTitle("vtiger");
		extentReport.config().setTheme(Theme.DARK);
		
		//attach the physical report and system configuration
		report=new ExtentReports();
		report.attachReporter(extentReport);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("url", "http://localhost:8888/");
		report.setSystemInfo("Enviroment", "local server");
		report.setSystemInfo("browser", "chrome");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
