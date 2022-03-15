package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyfilePractice 
{
	@Test
	public void test() throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\test.properties");
		Properties poj = new Properties();
		poj.load(fis);
		
		String NAME = poj.getProperty("name");
		
		System.out.println(NAME);
	}
}
