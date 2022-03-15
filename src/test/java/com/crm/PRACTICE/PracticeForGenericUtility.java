package com.crm.PRACTICE;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.Webdriverutility;

public class PracticeForGenericUtility 
{
	@Test
	public void practice() throws Throwable 
	{
		JavaUtility jlib = new JavaUtility();
		int random = jlib.getRandomNumber();
		String date = jlib.getSystemDate();
		System.out.println(random+" "+date);
		String date1 = jlib.getsystemdateinformat();
		System.out.println(date1);
		PropertyFileUtility plib = new PropertyFileUtility();
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		ExcelFileUtility exl = new ExcelFileUtility();
		String value = exl.readDataFromExcel("Org", 1, 2);
		System.out.println(value);
		String value1 = exl.readDataFromExcel("Org", 1, 1);
		System.out.println(value1);
		exl.writeDataIntoExcel("Org", 10, 5, "WRITEDATA");
		
		Webdriverutility web =new Webdriverutility();
		WebDriver driver = new FirefoxDriver();
		web.maximizeWindow(driver);
		web.waitForPageLoad(driver);
		driver.get("https://demo.guru99.com/popup.php");
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(3000);
		web.switchToWindow(driver, "articles");
		Thread.sleep(3000);
		driver.close();
		web.switchToWindow(driver, "m/popup");
		driver.findElement(By.linkText("Click Here")).click();
		web.switchToWindow(driver, "articles");
		Thread.sleep(3000);
		driver.close();
		web.switchToWindow(driver, "m/popup");
		Thread.sleep(3000);
		driver.get("http://localhost:8888/index.php?module=Contacts&action=index");
		web.getScreenShot(driver, ""+date1+"-01");
		driver.close();
		
		
		
		
		
		
	}
}
