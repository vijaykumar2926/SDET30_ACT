package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrcticeTest 
{
	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeDriver driver1 = new ChromeDriver();
		
	}
	
}
