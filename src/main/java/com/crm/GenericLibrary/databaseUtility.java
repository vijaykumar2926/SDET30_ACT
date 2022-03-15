package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains methods related to database
 * @author vijay
 *
 */
public class databaseUtility 
{
	Connection con = null;
	/**
	 * This method is used to establish connection to the database
	 * @throws Throwable
	 */
	public void getConnection() throws Throwable
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(IpathConstants.DbUrl, IpathConstants.DbUsername, IpathConstants.DbPassword);
	}
	
	/**
	 * This method is used to close connection 
	 * @throws Throwable
	 */
	public void closeConnection() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and return expected data to the user
	 * @param Query
	 * @param columnIndex
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String exceuteQueryAndGetData(String Query, int columnIndex, String expectedData) throws Throwable
	{
		String Data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(Query);
		while(result.next())
		{
			Data =result.getString(columnIndex);
			if (Data.contains(expectedData)) 
			{
				flag=true;
				break;
			}
		}
		if (flag) 
		{
			System.out.println(expectedData + "-----> data verified");
			return expectedData;
		}
		else
		{
			System.out.println(expectedData + "-----> data not verified");
			return "";
		}
	}
	
	/**
	 * This method will execute update and return count of updated rows
	 * @param Query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String Query) throws Throwable
	{
		int result = con.createStatement().executeUpdate(Query);
		return result;
		
	}
	
}
