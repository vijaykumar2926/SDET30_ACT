package com.crm.PRACTICE;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDatafromExcelSheetTest 
{
	@Test
	public void readdatafromexcel() throws Throwable
	{
		//step 1 : load the excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		
		// Step 2 : create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3 : get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		
		// step 4 : get the row
		Row ro = sh.getRow(0);
		
		//step 5 : get the cell
		Cell ce = ro.getCell(1);
		
		//read the data from the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
	}
}
