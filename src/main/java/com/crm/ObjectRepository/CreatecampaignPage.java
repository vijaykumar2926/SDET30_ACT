package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class CreatecampaignPage extends Webdriverutility 
{
	@FindBy(name = "campaignname")
	private WebElement CampaignNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectProductImg;
	
	@FindBy(name = "search_text")
	private WebElement popupSearchEdt;
	
	@FindBy(name = "search_field")
	private WebElement popupDropdown;
	
	@FindBy(name = "search")
	private WebElement popupSearchBtn;
	
	public CreatecampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameEdt() {
		return CampaignNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSelectProductImg() {
		return selectProductImg;
	}
	public WebElement getPopupSearchEdt() {
		return popupSearchEdt;
	}

	public WebElement getPopupDropdown() {
		return popupDropdown;
	}

	public WebElement getPopupSearchBtn() {
		return popupSearchBtn;
	}


	// business library
	
	/**
	 * This method will create new campaigns
	 * @param campaignsName
	 */
	public void CreateNewcampaigns(String campaignsName)
	{
		CampaignNameEdt.sendKeys(campaignsName);
		saveBtn.click();
	}
	
	
	/**
	 * This method will create a new campaign with campaign name and product name 
	 * @param driver
	 * @param ProductName
	 * @param CampaignName
	 */
	public void createNewCampaign(WebDriver driver, String ProductName, String CampaignName)
	{
		CampaignNameEdt.sendKeys(CampaignName);
		selectProductImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(ProductName);
		select("productname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, ProductName);
		switchToWindow(driver, "parenttab");
		saveBtn.click();

		
		
	}
}
