package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewVendorsImg;
	
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewVendorsImg() {
		return createNewVendorsImg;
	}
	
	// business library
	
	/**
	 * This method will click on Create product Image
	 */
	public void clickOnCreateVendorImg()
	{
		createNewVendorsImg.click();
	}
	
}
