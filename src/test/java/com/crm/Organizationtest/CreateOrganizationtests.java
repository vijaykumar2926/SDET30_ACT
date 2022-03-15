package com.crm.Organizationtest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateOrganizationtests extends BaseClass
{
	@Test(groups = "smokeSuite")
	public void createorg() throws Throwable, Throwable
	{
		String Orgname = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		
		// step 3 : navigate to organization 
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		
		// step 4 : click on create organization link
		Organizationpage op = new Organizationpage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		// Step 5 : Create organization with mandatory fields
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(Orgname);
		Reporter.log("New organization created", true);

		// organization name verified
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(Orgname));
		Reporter.log("Verification successful", true);

	}
	
	
	
}
