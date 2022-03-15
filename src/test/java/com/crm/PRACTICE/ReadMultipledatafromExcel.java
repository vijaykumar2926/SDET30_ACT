package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class ReadMultipledatafromExcel 
{
	ExcelFileUtility elib = new ExcelFileUtility();
	
	@Test(dataProvider = "testdata")
	public void readmultipledatafromexcel(String Orgname , String IndType)
	{
		System.out.println(Orgname+" --> "+ IndType);
	}
	
	@DataProvider(name = "testdata")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = elib.readMultipleDataFromExcel("OrgTestData");
		return data;
	}
	
}
