package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewCampaignImg;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewCampaignImg() {
		return createNewCampaignImg;
	}
	
	// business library
	
	/**
	 * This method will click on create new Campaign Image 
	 */
	public void clickOnCreateNewcampaignsImg()
	{
		createNewCampaignImg.click();
	}
}
