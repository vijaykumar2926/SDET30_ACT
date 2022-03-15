package com.crm.Organizationtest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateOrganizarionTestsWithPropertiesfiletest extends BaseClass
{
	@Test
	public void createorganization() throws Throwable
	{
		String Orgname = eLib.readDataFromExcel("Org", 1, 1)+"_"+jLib.getRandomNumber();
		
	    // Step 4 : navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		
		// Step 5 : click on create organization link
		Organizationpage op = new Organizationpage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		
		// Step 6 : Create organization with mandatory fields
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(Orgname);
		Reporter.log("New organization created", true);

		
		/* organization verification */
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(Orgname));
		Reporter.log("Verification successful", true);


		
	}
}
