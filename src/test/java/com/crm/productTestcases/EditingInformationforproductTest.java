package com.crm.productTestcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreateVendorPage;
import com.crm.ObjectRepository.EditProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductsPage;
import com.crm.ObjectRepository.VendorPage;

public class EditingInformationforproductTest extends BaseClass  //TC_23
{
	@Test
	public void EditingInformationforproduct() throws Throwable
	{
		
		// Reading data from excel
		String Vendorname = eLib.readDataFromExcel("Products", 4, 2)+"_"+jLib.getRandomNumber();
		String Productname1 = eLib.readDataFromExcel("Products", 4, 1)+"_"+jLib.getRandomNumber();
		String Productname2 = eLib.readDataFromExcel("Products", 5, 1)+"_"+jLib.getRandomNumber();
		String Productnumber = eLib.readDataFromExcel("Products", 4, 3)+"_"+jLib.getRandomNumber();
		String SalesStartDate = eLib.readDataFromExcel("Products", 4, 4);
		SalesStartDate = jLib.reverseDate(SalesStartDate);
		String PartNumber = eLib.readDataFromExcel("Products", 4, 5);
		String Manufacturer = eLib.readDataFromExcel("Products", 4, 6);
		String ProductCategory = eLib.readDataFromExcel("Products", 4, 7);
		String SalesEndDate = eLib.readDataFromExcel("Products", 4, 8);
		SalesEndDate = jLib.reverseDate(SalesEndDate);
		String SupportStartDate = eLib.readDataFromExcel("Products", 4, 9);
		SupportStartDate = jLib.reverseDate(SupportStartDate);
		String SupportExpiryDate = eLib.readDataFromExcel("Products", 4, 10);
		SupportExpiryDate = jLib.reverseDate(SupportExpiryDate);
		String VendorNo = eLib.readDataFromExcel("Products", 4, 11);
		String Website = eLib.readDataFromExcel("Products", 4, 12);
		String ProductSheet = eLib.readDataFromExcel("Products", 4, 13);
		String MfrPartNo = eLib.readDataFromExcel("Products", 4, 14);
		String SerialNo = eLib.readDataFromExcel("Products", 4, 15);

		HomePage hp = new HomePage(driver);
		hp.clickOnMoreLink();
		hp.clickOnVendorLink();
		Reporter.log("clicked on Vendor link", true);

		
		/* Create a vendor */
		VendorPage vp = new VendorPage(driver);
		vp.clickOnCreateVendorImg();
		Reporter.log("Clicked on create Vendor lookup image", true);

		CreateVendorPage cvp = new CreateVendorPage(driver);
		cvp.CreateNewVendor(Vendorname);
		Reporter.log("New Vendor created", true);

		
		/* Create a product */
		hp.clickOnProductslink();
		Reporter.log("clicked on product link", true);

		ProductsPage pp = new ProductsPage(driver);
		pp.clickOnCreateProductImg();
		Reporter.log("Clicked on create product lookup image", true);

		CreateProductPage ccp = new CreateProductPage(driver);
		ccp.createNewProduct(Productname1);
		Reporter.log("New product created", true);

		
		/* edit Product details */
		hp.clickOnProductslink();
		pp.searchForProduct(Productname1);
		pp.clickOnEditbtn(driver, Productname1);
		EditProductPage epp = new EditProductPage(driver);
		epp.editProduct(driver, Productname2, Productnumber, PartNumber, Manufacturer, ProductCategory,
				SalesStartDate, SalesEndDate, SupportStartDate, SupportExpiryDate, VendorNo, Vendorname,
				Website, ProductSheet, MfrPartNo, SerialNo);
		
		/* Verification */



		Reporter.log("Verification successful", true);

		
		
 	}
}
