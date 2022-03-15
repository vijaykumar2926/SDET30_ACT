package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizationpage 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookupImg;
	
	@FindBy(name = "emailoptout")
	private WebElement EmailOptOutCheckBox;
	
	
	public WebElement getEmailOptOutCheckBox() {
		return EmailOptOutCheckBox;
	}

	public Organizationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	// business library
	/**
	 * This method will click on create Organization image
	 */
	public void clickOnCreateOrgImg()
	{
		createOrgLookupImg.click();
	}
}
