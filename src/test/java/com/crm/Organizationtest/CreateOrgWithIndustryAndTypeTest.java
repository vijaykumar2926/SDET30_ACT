package com.crm.Organizationtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateOrgWithIndustryAndTypeTest extends BaseClass
{
	@Test
	public void CreateOrgWithIndustryAndType() throws Throwable
	{	
		// Read data from Excel sheet
		String Orgname = eLib.readDataFromExcel("Org", 10, 2)+"_"+jLib.getRandomNumber();
		String IndType = eLib.readDataFromExcel("Org", 10, 3);
		String Type = eLib.readDataFromExcel("Org", 10, 4);

		/* Navigate to organization link*/
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		/* click on create organization button*/
		Organizationpage op = new Organizationpage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		/* create organization with mandatory fields and save */
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrganization(Orgname, IndType, Type);
		Reporter.log("New organization created", true);

		/* Organization verification */
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String header = oip.organizationInfo();
		Assert.assertTrue(header.contains(Orgname));
		Reporter.log("Verification successful", true);


	}
}
