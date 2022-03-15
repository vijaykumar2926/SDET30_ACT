package com.crm.organizationA1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateOrganizationCopyShippingAddressTest extends BaseClass //TC_16
{
	@Test
	public void CreateOrganizationCopyShippingAddress() throws Throwable
	{
		// read data from excel sheet
		String orgname = eLib.readDataFromExcel("Org", 7, 2)+"_"+jLib.getRandomNumber();
	
		/* create new organization and click on copy shipping address checkbox */
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		Organizationpage op = new Organizationpage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(orgname);
		Reporter.log("New organization created", true);

				
		// organization verification
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(orgname));
		Reporter.log("Verification successful", true);


	}
}
