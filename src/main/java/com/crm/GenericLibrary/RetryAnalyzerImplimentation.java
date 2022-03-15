package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplimentation implements IRetryAnalyzer
{

	int count = 0;
	int retrycount = 4;
	
	public boolean retry(ITestResult result) {
		
		if (count<retrycount) 
		{
			count++;
			return true;
			
		}
		
		return false;
	}
	
}
