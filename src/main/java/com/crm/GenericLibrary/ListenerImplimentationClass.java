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
	
		// Consolidate all the parameter and generate the report
		report.flush();
		
	}

	public void onStart(ITestContext context) {

		// execution will start here
		/* configure  the report */
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report"+new JavaUtility().getsystemdateinformat()+".html");
		htmlreport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Selenium Execution Report ");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Vijay");
		
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		
		String MethodName = result.getMethod().getMethodName();
		String path=null;
		//Step 1: Configure screenshot name
		String screenshotname = MethodName+"-"+ new JavaUtility().getsystemdateinformat();
		try {
			path =  new Webdriverutility().getScreenShot(BaseClass.sdriver, screenshotname);
			
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, MethodName+"---> testscript execution FAILED");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);


	}

	public void onTestSkipped(ITestResult result) {
	
		String MethodName =	result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---> testscript execution SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestStart(ITestResult result) {
		
		String MethodName =	result.getMethod().getMethodName();
		System.out.println(MethodName+"---> testscript execution STARTED");
		test = report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName =	result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---> testscript execution PASSED");
		
		
	}
}
