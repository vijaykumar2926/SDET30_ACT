package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage 
{
	@FindBy(name = "vendorname")
	private WebElement VendorNameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorNameEdit() {
		return VendorNameEdit;
	}
	
	// business library
	
	/**
	 * This method will create new vendor
	 * @param VendorName
	 */
	public void CreateNewVendor(String VendorName)
	{
		VendorNameEdit.sendKeys(VendorName);
		SaveBtn.click();
	}
}
