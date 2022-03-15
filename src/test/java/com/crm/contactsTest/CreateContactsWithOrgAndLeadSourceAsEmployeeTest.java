package com.crm.contactsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateContactsWithOrgAndLeadSourceAsEmployeeTest extends BaseClass
{
	@Test
	public void CreateContactsWithOrgAndLeadSourceAsEmployee() throws Throwable
	{
		// read data from excel sheet
		String Lastname = eLib.readDataFromExcel("Contacts", 26, 2)+"_"+jLib.getRandomNumber();
		String OrgName = eLib.readDataFromExcel("Contacts", 26, 3)+"_"+jLib.getRandomNumber();
		String Leadsource = eLib.readDataFromExcel("Contacts", 26, 4);

				
		/* create organization */
		// click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		
		// click on create organization lookupimg
		Organizationpage op = new Organizationpage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		
		// create organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(OrgName);
		Reporter.log("New organization created", true);

		// contact verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(OrgName));
		Reporter.log("Verification successful", true);

		/* create contact */
		// click on contacts link
		hp.clickOnContactLink();
		
		//click on create contacts
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLink();
		Reporter.log("clicked on contacts link", true);

		// create new contact with orgname and leadsource
		CreateContactsPage ccp = new CreateContactsPage(driver);
		Reporter.log("Clicked on create contacts lookup image", true);

		ccp.createNewContact(driver, Lastname, OrgName, Leadsource);
		Reporter.log("New contacts created", true);

		// contact verification
		ContactsInfoPage cip = new ContactsInfoPage(driver);

		String header1 = cip.contactNameInfo();
		Assert.assertTrue(header1.contains(Lastname));
		Reporter.log("Verification successful", true);

	}
}
