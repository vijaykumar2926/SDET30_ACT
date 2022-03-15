package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectdateInCurrentMonth 
{
	@Test
	public void selectdate()
	{
		String Day = "25";
		String Month = "March";
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
		driver.findElement(By.xpath(Xpath)).click();
		
	}
	
}
