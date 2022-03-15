package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic methods to fetch data from property file
 * @author vijay
 *
 */
public class PropertyFileUtility 
{
	/**
	 * This method will read the data from property file and return it to user 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis  = new FileInputStream(IpathConstants.Propertypath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
		
	}
}
