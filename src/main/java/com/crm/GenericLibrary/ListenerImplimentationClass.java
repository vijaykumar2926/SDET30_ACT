package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentationClass implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	
	public void onFinish(ITestContext context) 
	{
		// consolidate all the parameter and generate report
		report.flush();
	}

	public void onStart(ITestContext context) {

		//Execution starts here 
		/* configure the report */
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentsReport"+new JavaUtility().getsystemdateinformat());
		htmlreport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter name", "vijay");

		
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
		
		test.log(Status.FAIL, MethodName+"---> TestScript FAILED");

	}

	public void onTestSkipped(ITestResult result) {
	
		String MethodName =	result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---> TestScript SKIPPED");
		// This will capture the exception and log it in report
		test.log(Status.SKIP, result.getThrowable());

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
