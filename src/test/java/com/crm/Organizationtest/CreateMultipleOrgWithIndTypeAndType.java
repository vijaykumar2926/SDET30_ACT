package com.crm.Organizationtest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationpage;

public class CreateMultipleOrgWithIndTypeAndType extends BaseClass
{
		@Test(dataProvider = "testdata")
		public void createOrgWithIndType(String OrgName, String IndType, String Type) throws Throwable
		{
			// random number
			int Rnum = jLib.getRandomNumber();
			
			OrgName = OrgName+"_"+Rnum;
			
			// click on organization link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			Reporter.log("clicked on organization link", true);

			
			// click on create organization link
			Organizationpage op = new Organizationpage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("Clicked on create organization lookup image", true);

			
			// create new organization
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrganization(OrgName, IndType, Type);
			Reporter.log("New Organization created", true);
			
			// verification
			OrganizationInfoPage opi = new OrganizationInfoPage(driver);
			String Header = opi.organizationInfo();
			if (Header.contains(OrgName)) 
			Assert.assertTrue(Header.contains(OrgName));
			Reporter.log("Verification successful", true);

		}
		
		@DataProvider(name = "testdata")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readMultipleDataFromExcel("OrgTestData2");
			return data;
		}
}
