package com.crm.contactsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactsTest extends BaseClass //scenario 2
{
	@Test(groups = "smokeSuite")
	public void createcontacts() throws Throwable
	{
		//read data from Excel Sheet
		String LastName = eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		ContactsPage cp = new ContactsPage(driver);
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ContactsInfoPage cop = new ContactsInfoPage(driver);
		
		/* Navigate to contacts link */
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link", true);

		/* click on create contact button */
		cp.clickOnCreateContactsLink();
		Reporter.log("Clicked on create contacts lookup image", true);

		
		/* enter mandatory fields and save */
		ccp.createNewContact(LastName);
		Reporter.log("New contacts created", true);

		// verification
		 String header = cop.contactNameInfo();
		Assert.assertTrue(header.contains(LastName));
		Reporter.log("Verification successful", true);

		
	}
}
