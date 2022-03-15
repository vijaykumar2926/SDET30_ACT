package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider4Cross3 
{
	@Test(dataProvider = "getData")
	public void Dataprovider4cross3(String Brand , String model , int Qty )
	{
		System.out.println(Brand+"-----"+model+"-----"+Qty);
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[4][3];
		
		obj[0][0] = "MI";
		obj[0][1] = "note 8";
		obj[0][2] = 2000;
		
		obj[1][0] = "vivo";
		obj[1][1] = "v25";
		obj[1][2] = 3000;
		
		obj[2][0] = "Iphone";
		obj[2][1] = "13 pro";
		obj[2][2] = 1000;
		
		obj[3][0] = "Samsung";
		obj[3][1] = "s11";
		obj[3][2] = 2500;
		
		return obj;
	}
}
