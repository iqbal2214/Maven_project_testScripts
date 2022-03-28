package crm.com.autodesk.generic.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ImplimantationForIRetryAnalyser implements IRetryAnalyzer{

	int count=0;
	int retry=5;
	public boolean retry(ITestResult result) {
		if(count<retry) {
			count++;
			return true;
		}
		return false;
	}

}
