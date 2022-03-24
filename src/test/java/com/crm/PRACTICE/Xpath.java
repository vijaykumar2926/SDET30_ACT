package com.crm.PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath 
{
	@Test
	public void test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String prd1 = "Lenovo Yoga Smart Tablet with The Google Assistant 25.65 cm (10.1 inch, 4GB, 64GB, WiFi + 4G LTE), Iron Grey";
		String prd = "Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 256GB Storage) + Samsung Galaxy Watch 4";
		driver.get("https://www.amazon.in/s/ref=mega_elec_s23_2_2_1_2?rh=i%3Acomputers%2Cn%3A4363894031&ie=UTF8");
		driver.navigate().to("https://www.amazon.in/s?k=ipho&ref=nb_sb_noss_2");
		String xpath = "//span[.='"+prd+"']/../../../..//span[@class='a-price-whole']";
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
	
	}
}
