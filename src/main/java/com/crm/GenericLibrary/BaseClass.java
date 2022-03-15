package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	// Create Object For All Utilities
	public databaseUtility dBLib = new databaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public Webdriverutility wLib = new Webdriverutility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups = {"smokeSuite","regressionSuite"})
	public void connectDataBase() throws Throwable
	{
		//dBLib.getConnection();
		
		Reporter.log("==== DataBase Connection Successful ====",true);
	}
	
		@BeforeClass(groups = {"smokeSuite","regressionSuite"})
	
//	@BeforeTest
	//@Parameters("browser")
	public void launchTheBrowser() throws Throwable
	{
		// read data from propertyfile
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		
		String URL = pLib.readDataFromPropertyFile("url");
	
		// Create run time polymorphism
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		Reporter.log("==== Browser Launch Successful ====",true);
		sdriver = driver;
	}
	
	
	@BeforeMethod(groups = {"smokeSuite","regressionSuite"})
	public void Login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		Reporter.log("==== Login To Appliction Successful ====",true);
	}
	
	@AfterMethod(groups = {"smokeSuite","regressionSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApplication(driver);
		Reporter.log("==== Logout Of Application Successful ====",true);

	}
	
	@AfterClass(groups = {"smokeSuite","regressionSuite"})
	
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		
		Reporter.log("==== Browser close Successful ====",true);

	}
	
	@AfterSuite(groups = {"smokeSuite","regressionSuite"})
	public void closeDataBase() throws Throwable
	{
		//dBLib.closeConnection();
		
		Reporter.log("==== DataBase Close Successful ====",true);
	}
	
}
