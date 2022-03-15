package com.crm.assignmentcontactsTest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;

public class CreateContactsNotifyOwnerTest extends BaseClass //TC_25
{
	@Test
	public void CreateContactsNotifyOwner() throws Throwable 
	{
		SoftAssert sa = new SoftAssert();
		// Read data from Excel sheet
		String LastName = eLib.readDataFromExcel("Contacts", 13, 2)+"_"+jLib.getRandomNumber();
	
		/* Place the mouse cursor and click on "Contact" Link */
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link", true);

		
		/* Navigate to "create new Contact"page by click on "+" image */
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLink();
		Reporter.log("Clicked on create contacts lookup image", true);

		/* Create a contact and check "Do not call "box is enable or not */
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.getLastnameEdt().sendKeys(LastName);
		ccp.getNotifyOwnerCheckbox().click();
		ccp.getSaveBtn().click();
		Reporter.log("New contacts created", true);

		
		/* contact and email_checkbox verification */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header = cip.contactNameInfo();
		Assert.assertTrue(header.contains(LastName));
		String text = cip.NotifyOwner();
		sa.assertTrue(text.contains("yes"));
		Reporter.log("Verification successful", true);

		sa.assertAll();
	}
}
