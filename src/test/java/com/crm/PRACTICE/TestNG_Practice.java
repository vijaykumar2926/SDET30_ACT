package com.crm.PRACTICE;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_Practice 
{
	@Test(priority = 2,invocationCount = 3,enabled = false)
	public void createOrg()
	{
		System.out.println("create org");
		
	}
	
	@Test(priority = -20,invocationCount = 5)
	public void deleteOrg()
	{
		System.out.println("delete org");
		Reporter.log("DELETE", true);
	}
	
	@Test(priority = 0,invocationCount = 7)
	public void modifyOrg()
	{
		System.out.println("modify org");
		Reporter.log("MODIFY");
	}
	
	
}
