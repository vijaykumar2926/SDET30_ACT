package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods wrt to java 
 * @author vijay
 *
 */
public class JavaUtility 
{
	/**
	 * This method will create random number and return it to user
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
	
	/**
	 * This method will generate current system date and return it to user
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will generate current system date and return it in format to user
	 * @return
	 */
	public String getsystemdateinformat()
	{
		Date d = new Date();
		String date = d.toString();
		String[] date1 = date.split(" ");
		
		String mon = date1[1];
		String day = date1[2];
		String time = date1[3].replace(":", "_");
		String year = date1[5];
		
		date = day+"-"+mon+"-"+year+"-"+time;
		return date;
		
		
	}
	
	/**
	 * This method will reverse a given String
	 * @param value
	 * @return
	 */
	public String reverseGivenString(String value)
	{
		String rev = "";
		for (int i = 0; i < value.length(); i++) 
		{
		    char cha = value.charAt(i);
			rev = cha+rev;
		}
		return rev;
	}
	
	/**
	 * This method will convert date format ,
	 *  (DD-MM-YYYY) INTO (YYYY-MM-DD) 
	 * @param date
	 * @return
	 */
	public String reverseDate(String date)
	{
		 String[] value = date.split("-");
		String rev = (value[2]+"-"+value[1]+"-"+value[0]);
		return rev;
		
	}
	
}
