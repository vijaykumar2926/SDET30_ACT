package com.crm.PRACTICE;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenericLibrary.ListenerImplimentationClass.class)

public class Nextclick extends BaseClass
{
	@Test
	public void teat() throws Throwable
	{
		
		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
	
		/* Navigate to contacts link */
		hp.clickOnContactLink();
		Assert.fail();

		//cp.clickOnElement(driver, "Micrmax_45");
		System.out.println("==== Clicked on Contact");
		
		

	}

}
