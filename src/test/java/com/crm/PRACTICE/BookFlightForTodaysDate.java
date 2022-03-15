package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlightForTodaysDate 
{
	@Test
	public void bookFlightForCurrentDate() throws Throwable
	{
		Date d = new Date();
		SimpleDateFormat sfd = new SimpleDateFormat("d MMMM YYYY");
		String today = sfd.format(d);
		System.out.println(today);
		String[] spl = today.split(" ");
		String Day = spl[0];
		String Month = spl[1];
		String Year = spl[2];

//		Date d = new Date();
//		String dat = d.toString();
//		String[] date = dat.split(" ");
//
//		String Month = date[1];
//		String Day = date[2];
//		String Year = date[5];
//		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Calender.properties");
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		Day = pobj.getProperty(Day);
//		Month = pobj.getProperty(Month);
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		Reporter.log("Browser launched Successfully",true);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		Reporter.log("Application loaded Sucessfully",true);
	
		driver.findElement(By.xpath("//p[.='Enter city or airport']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("BLR");
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		Reporter.log("From location added Successfully",true);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("DEL");
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		Reporter.log("To location added Successfully",true);
		
		String Xpath = "//div[.='"+Month+" "+Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+Day+"']";
		driver.findElement(By.xpath(Xpath)).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		Reporter.log("Current date selected Successfully",true);
		
		driver.findElement(By.xpath("//a[.='Done']")).click();
		driver.findElement(By.xpath("//span[.='SEARCH FLIGHTS']")).click();
		Reporter.log("Clicked on search flights Button",true);
		
	}
}
