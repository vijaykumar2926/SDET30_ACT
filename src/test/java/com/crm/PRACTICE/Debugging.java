package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.Webdriverutility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Debugging 
{
	@Test
	public void debuggg()
	{
		System.out.println("debug");
		System.out.println(division(5, 0));
		
	}
	
	public int division(int a,int b )
	{
		int c = a+b;
		int d = c+1;
		return d;
	}
}
