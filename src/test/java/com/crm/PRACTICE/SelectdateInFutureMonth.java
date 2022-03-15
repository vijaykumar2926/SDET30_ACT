package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectdateInFutureMonth 
{
	@Test
	public void selectdate()
	{
		String Day = "25";
		String Month = "August";
		String Year = "2022";
		
		// Launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
				
		Actions act = new Actions(driver);
		act.moveByOffset(1, 1).click().perform();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		String Xpath = "//div[.='"+Month+" "+Year+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+Day+"']";
		String Xpath1 = "//span[@aria-label='Next Month']";

		
		for(;;)
		{
			try 
			{
				driver.findElement(By.xpath(Xpath)).click();
				break;
				
			} catch (Exception e) 
			{
				driver.findElement(By.xpath(Xpath1)).click();
			}
		}
		
	}
}
