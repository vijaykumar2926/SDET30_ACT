package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentationClass implements ITestListener
{

	public void onFinish(ITestContext context) 
	{
		
	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		
		//Step 1: Configure screenshot name
		String screenshotname = MethodName+"-"+ new JavaUtility().getsystemdateinformat();
		try {
			new Webdriverutility().getScreenShot(BaseClass.sdriver, screenshotname);
			
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	
		String MethodName =	result.getMethod().getMethodName();
		System.out.println(MethodName+"---> TestScript SKIPPED");
	}

	public void onTestStart(ITestResult result) {
		
		String MethodName =	result.getMethod().getMethodName();
		System.out.println(MethodName+"---> testscript execution STARTED");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName =	result.getMethod().getMethodName();
		System.out.println(MethodName+"---> testscript execution sucessfull - PASS");
	}
}
