package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider6cross2 
{
	
	@Test(dataProvider = "getData")
	public void dataprovider6cross2(String Brand,String Model)
	{
		System.out.println(Brand+"----"+Model);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0] = "MI";
		obj[0][1] = "Note 8 pro";
		
		obj[1][0] = "Samsung";
		obj[1][1] = "Note 10";
		
		obj[2][0] = "vivo";
		obj[2][1] = "v25";
		
		obj[3][0] = "Oppo";
		obj[3][1] = "Reno 5";
		
		obj[4][0] = "Oneplus";
		obj[4][1] = "Nord CE";
		
		obj[5][0] = "Nokia";
		obj[5][1] = "Lumia";
		
		return obj;
	}
}
