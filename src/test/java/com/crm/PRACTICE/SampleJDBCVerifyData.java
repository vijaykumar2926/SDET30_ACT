package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCVerifyData 
{
	@Test
	public void SampleJDBCverifydata() throws SQLException
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		try {
			Statement state = con.createStatement();
			String expdata = "vinay";
			ResultSet results = state.executeQuery("select * from students;");
			while(results.next())
			{
					String actdata = results.getString(2);
					if(expdata.equalsIgnoreCase(actdata))
					{
						System.out.println(actdata+" data is verified");
						break;
					}else{
						System.out.println("Data not present in database");
					}
			}
		} catch (Exception e) {
			
		}
		finally {
			con.close();
		}
	}
}
