package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//The Retry class will implement after the Listeners, it will look at all testcases that failed and it will retry however many times you ask
	
	int count = 0;
	int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count < maxTry)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
