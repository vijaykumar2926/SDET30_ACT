package com.crm.assignmentcontactsTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateContactTest extends BaseClass //TC_21
{
	@Test
	public void createcontact() throws Throwable
	{
		//read data from Excel Sheet
		String LastName = eLib.readDataFromExcel("Contacts", 4, 2)+"_"+jLib.getRandomNumber();
		String OrgName = eLib.readDataFromExcel("Contacts", 4, 3)+"_"+jLib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		Organizationpage op = new Organizationpage(driver);
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		/* Navigate to organization link */
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on Organization link", true);


		/* click on create Organization button */
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create Organization lookup image", true);

		
		/* enter mandatory fields and save */
		cop.createNewOrganization(OrgName);
		Reporter.log("New Organization created", true);

		
		/* Organization name verification */
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(OrgName));
		Reporter.log("Verification successful", true);

		/* Navigate to contacts link */
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link", true);

		/* click on create contact button */
		cp.clickOnCreateContactsLink();
		Reporter.log("Clicked on create contacts lookup image", true);

		
		/* enter mandatory fields and save */
		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.getLastnameEdt().sendKeys(LastName);
		ccp.clickOnSelectOrgAndclickOnOrgName(driver, OrgName);
		ccp.getClearOrgimg().click();
		ccp.getSaveBtn().click();
		Reporter.log("New contacts created", true);

		
		// verification
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header1 = cip.contactNameInfo();

		Assert.assertTrue(header1.contains(LastName));
		Reporter.log("Verification successful", true);

	}

}
