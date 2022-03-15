package com.crm.PRACTICE;

import org.testng.annotations.Test;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;

public class TEst
{
	@Test
	public void  test() throws Throwable
	{
		ExcelFileUtility ex = new ExcelFileUtility();
		JavaUtility jutil = new JavaUtility();

		
		String cell1 = ex.readDataFromExcel("Products", 4, 4);
		String cell2 = ex.readDataFromExcel("Products", 4, 8);
		
		cell1=jutil.reverseDate(cell1);
		cell2=jutil.reverseDate(cell2);

		
		System.out.println(cell1);
		System.out.println(cell2);		
		
	
		
		
		
	}
}

