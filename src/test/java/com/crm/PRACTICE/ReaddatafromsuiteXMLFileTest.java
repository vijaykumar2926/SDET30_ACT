package com.crm.PRACTICE;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReaddatafromsuiteXMLFileTest 
{
	@Test
	public void readdatafromXML(XmlTest xml)
	{
		String BROWSER = xml.getParameter("browser");
		String URL = xml.getParameter("url");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		
	}
}
