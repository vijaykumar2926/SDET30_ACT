package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic method to read and write data into excel sheet 
 * @author vijay
 *
 */
public class ExcelFileUtility 
{
	/**
	 * This method will read data from excel sheet and return value to the user when sheet name,
	 * row number and cell number is specified
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet , int row , int cell) throws Throwable, IOException
	{
		FileInputStream fis  = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row ro = sh.getRow(row);
		Cell cel = ro.getCell(cell);
		String value = cel.getStringCellValue();
		return value;
		
	}
	
	
	/**
	 * This method will write data into excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param value
	 * @throws Throwable
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet , int row , int cell , String value) throws Throwable, IOException
	{
		FileInputStream fis  = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		//Row ro = sh.getRow(row);
		Row ro = sh.createRow(row);
		Cell cel = ro.createCell(cell);
		cel.setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fos);
	}
	
	/**
	 * This method will return last row number
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheet) throws Throwable
	{
		FileInputStream fis  = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int ro = sh.getLastRowNum();
		return ro;
	}
	
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheet name
	 * and return 2 dimensional object[][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int LastRow = sh.getLastRowNum();
		int LastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] Data = new Object[LastRow][LastCell];
		
		for (int i = 0; i < LastRow; i++) 
		{
			for (int j = 0; j < LastCell; j++) 
			{
				Data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return Data;
		
	}
	
}