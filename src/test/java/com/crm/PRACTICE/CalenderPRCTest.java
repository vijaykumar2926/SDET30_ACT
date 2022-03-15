package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPRCTest 
{
	@Test
	public void Selectdate() throws Throwable
	{
		String Day = "16" , Month = "March" ,Year = "2022";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//p[.='Enter city or airport']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bengaluru (BLR)");
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(" New Delhi (DEL)");
		driver.findElement(By.xpath("//li[@tabindex='0']")).click();
		String Xpath = "//div[.='"+Month+" "+Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+Day+"']";
		driver.findElement(By.xpath(Xpath)).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Done']")).click();
		driver.findElement(By.xpath("//span[.='SEARCH FLIGHTS']")).click();
	}
}
