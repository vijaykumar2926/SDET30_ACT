package com.crm.contactsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;

public class CreateMultipleContacts extends BaseClass
{
		@Test(dataProvider = "testdata")
		public void createOrgWithIndType(String LastName) throws Throwable
		{
			// random number
			int Rnum = jLib.getRandomNumber();
			
			LastName = LastName+"_"+Rnum;
			
			// click on Contacts link
			HomePage hp = new HomePage(driver);
			hp.clickOnContactLink();
			Reporter.log("clicked on Contacts link", true);

			
			// click on create Contacts link
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnCreateContactsLink();
			Reporter.log("Clicked on create Contacts lookup image", true);

			
			// create new Contacts
			CreateContactsPage ccp = new CreateContactsPage(driver);
			ccp.createNewContact(LastName);
			Reporter.log("New Contacts created", true);

			
			// verification
			ContactsInfoPage cip = new ContactsInfoPage(driver);
			String Header = cip.contactNameInfo();
			Assert.assertTrue(Header.contains(LastName));
			Reporter.log("Verification successful", true);
		}
		
		@DataProvider(name = "testdata")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readMultipleDataFromExcel("ContactsTestData");
			return data;
		}
}
