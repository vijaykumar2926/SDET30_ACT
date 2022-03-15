package com.crm.Organizationtest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;


public class CreateOrgTest extends BaseClass 
{
	@Test
	public void createorg() throws Throwable //scenario 1
	{
		// Read data from Excel sheet
		String Orgname = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
	
		HomePage hp = new HomePage(driver);
		Organizationpage op = new Organizationpage(driver);
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		OrganizationInfoPage oi = new OrganizationInfoPage(driver);
		
		/* Navigate to organization link*/
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on organization link", true);

		/* click on create organization button*/
		op.clickOnCreateOrgImg();
		Reporter.log("Clicked on create organization lookup image", true);

		/* create organization with mandatory fields and save */
		cop.createNewOrganization(Orgname);
		Reporter.log("New organization created", true);

		// verification
		String header = oi.organizationInfo();
		Assert.assertTrue(header.contains(Orgname));
		Reporter.log("Verification successful", true);

		
	}
}
