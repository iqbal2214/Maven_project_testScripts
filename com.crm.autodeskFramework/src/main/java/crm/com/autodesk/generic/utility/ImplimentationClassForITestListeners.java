package crm.com.autodesk.generic.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplimentationClassForITestListeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("execution =============> started");
		
	}

	public void onTestSuccess(ITestResult result) {	
	 String MethodName=result.getMethod().getMethodName();
	 System.out.println(MethodName+"test execution ===========> successfully");
	 
	}

	public void onTestFailure(ITestResult result) {
		 String MethodName=result.getMethod().getMethodName();	
		 System.out.println(MethodName+"test execution========> failed");
		 System.out.println(result.getThrowable());
		
		   try {
			String path = new WebDriverUtility().takeScreenShotwithReturnPath(BaseClass.sDriver, MethodName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		 String MethodName=result.getMethod().getMethodName();	
		 System.out.println(MethodName+"test execution========> skipped");
		 System.out.println(result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
	
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("execution============> finish");
	}
	
	

}
