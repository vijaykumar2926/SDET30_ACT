package com.crm.Campaigns;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreatecampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;

public class CreateCampaignsTest extends BaseClass //TC_05
{
	@Test
	public void Createcampains() throws Throwable
	{
		// data from excel sheet
		String Productname = eLib.readDataFromExcel("Products", 1, 1)+"_"+jLib.getRandomNumber();
		String Campaignsname = eLib.readDataFromExcel("Campaigns", 1, 1)+"_"+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		ProductsPage pp = new ProductsPage(driver);
		CreateProductPage cpp = new CreateProductPage(driver);
		ProductInfoPage pi = new ProductInfoPage(driver);
		CampaignsPage cp = new CampaignsPage(driver);
		CreatecampaignPage ccp = new CreatecampaignPage(driver);
		CampaignsInfoPage ci = new CampaignsInfoPage(driver);
		
		/* navigate to to products and create a product */
		hp.clickOnProductslink();
		Reporter.log("clicked on products link", true);

		pp.clickOnCreateProductImg();
		Reporter.log("Clicked on create contacts lookup image", true);

		cpp.createNewProduct(Productname);
		Reporter.log("New contacts created", true);

		/*  products verification */
		String header = pi.productNameInfo();
		Assert.assertTrue(header.contains(Productname));
		Reporter.log("Verification successful", true);
		
		/* create Campaign with created product */
		hp.clickOnMoreLink();
		hp.clickOnCampaignslink();
		Reporter.log("clicked on Campaigns link", true);

		cp.clickOnCreateNewcampaignsImg();
		Reporter.log("Clicked on create Campaigns lookup image", true);

		ccp.createNewCampaign(driver, Productname, Campaignsname);
		Reporter.log("New Campaigns created", true);

		// campaigns verification
		String header1 = ci.campaignNameInfo();
		Assert.assertTrue(header1.contains(Campaignsname));
		Reporter.log("Verification successful", true);


	}
}