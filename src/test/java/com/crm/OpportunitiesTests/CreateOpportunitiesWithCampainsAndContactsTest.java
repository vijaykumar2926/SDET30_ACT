package com.crm.OpportunitiesTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOpportunityPage;
import com.crm.ObjectRepository.CreatecampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportunityInfoPage;

public class CreateOpportunitiesWithCampainsAndContactsTest extends BaseClass
{
	@Test
	public void CreateOpportunitiesWithCampaignsAndContacts() throws Throwable
	{
		// Read data from excel sheet
		int random = jLib.getRandomNumber();
		String Lastname = eLib.readDataFromExcel("Opportunities", 1, 2)+"_"+random;
		String CampaignName = eLib.readDataFromExcel("Opportunities", 1, 3)+"_"+random;
		String Related_to = eLib.readDataFromExcel("Opportunities", 1, 4);
		String Opportunity_Name = eLib.readDataFromExcel("Opportunities", 1, 5)+"_"+random;
		String Lead_Source = eLib.readDataFromExcel("Opportunities", 1, 6);
		
		HomePage hp = new HomePage(driver);

		// Create contact
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link", true);

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLink();
		Reporter.log("Clicked on create contacts lookup image", true);

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(Lastname);
		Reporter.log("New contacts created", true);

		
		// verify contact
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String header = cip.contactNameInfo();
		Assert.assertTrue(header.contains(Lastname));
		Reporter.log("Verification successful", true);


		// Create Campaigns
		hp.clickOnMoreLink();
		Reporter.log("clicked on more link", true);

		hp.clickOnCampaignslink();
		Reporter.log("clicked on Campaigns link", true);

		CampaignsPage cpp = new CampaignsPage(driver);
		cpp.clickOnCreateNewcampaignsImg();
		Reporter.log("Clicked on create Campaigns lookup image", true);

		
		CreatecampaignPage cccp = new CreatecampaignPage(driver);
		cccp.CreateNewcampaigns(CampaignName);
		Reporter.log("New Campaigns created", true);

		
		// verify Campaigns
		CampaignsInfoPage caip = new CampaignsInfoPage(driver);
		String campheader = caip.campaignNameInfo();
		Assert.assertTrue(campheader.contains(CampaignName));
		Reporter.log("Verification successful", true);


		// Create Opportunities
		hp.clickOpportunitieslink();
		Reporter.log("clicked on Opportunities link", true);

		OpportunitiesPage operp = new OpportunitiesPage(driver);
		operp.clickOnCreateOpportunityImg();
		Reporter.log("Clicked on create Opportunities lookup image", true);

		CreateOpportunityPage coppp = new CreateOpportunityPage(driver);
		coppp.createNewOpportunity(driver, Opportunity_Name, Lastname, CampaignName, Related_to, Lead_Source);
		Reporter.log("New Opportunities created", true);

		// verify Opportunity
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);
		String header1 = oip.OpportunityNameInfo();
		Assert.assertTrue(header1.contains(Opportunity_Name));
		Reporter.log("Verification successful", true);


	}
}