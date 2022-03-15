package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCupdateQuery 
{
	@Test
	public void sampleJDBCupdatequery() throws SQLException
	{
		Connection con = null;
		try 
		{
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			Statement state = con.createStatement();
			int result = state.executeUpdate("insert into student values(7,'vinay','male')");
			if(result==1)
			{
				System.out.println("database is updated successfully");
			}else{
				System.out.println("database update un successful");
			}
		} catch (Exception e) 
		{
			
		}
		finally 
		{
			con.close();
		}
		
	}

}
