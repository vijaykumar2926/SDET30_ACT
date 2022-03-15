package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest 
{
	@Test
	public void writedataintoexcelsheet() throws Throwable, IOException
	{
		//open the file in read mode
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row ro = sh.getRow(0);
		
		//create a cell to write data
		Cell cel = ro.createCell(3);
		
		// set a cell value
		cel.setCellValue("TC_4000");
		
		// open the file in write mode
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\data.xlsx");
		wb.write(fout);
		
	}

}
