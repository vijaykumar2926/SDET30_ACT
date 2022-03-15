package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public CampaignsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	
	// business library
	
	/**
	 * This method will Return the campaign title 
	 * @return
	 */
	public String campaignNameInfo()
	{
		String header = headerText.getText();
		return header;
	}
}
