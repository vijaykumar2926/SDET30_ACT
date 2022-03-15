package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	// getters

	public WebElement getHeaderText() {
		return headerText;
	}
	
	// business library
	
	/**
	 * This method will return product info
	 * @return
	 */
	public String organizationInfo()
	{
		String header = headerText.getText();
		return header;
	}
	
}
