package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class CreateOpportunityPage extends Webdriverutility
{
	@FindBy(name = "potentialname")
	private WebElement opportunityNameEdt;
	
	@FindBy(name = "related_to_type")
	private WebElement 	relatedToDropdown;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@name='related_to_display']/../img")
	private WebElement relatedToSelectImg;
	
	@FindBy(xpath = "//input[@name='campaignname']/../img")
	private WebElement campaignSourceSelectImg;
	
	@FindBy(name = "search_text")
	private WebElement popupSearchEdt;
	
	@FindBy(name = "search_field")
	private WebElement popupDropdown;
	
	@FindBy(name = "search")
	private WebElement popupSearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
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
	
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}

	public WebElement getRelatedToDropdown() {
		return relatedToDropdown;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getRelatedToSelectImg() {
		return relatedToSelectImg;
	}

	public WebElement getCampaignSourceSelectImg() {
		return campaignSourceSelectImg;
	}
	// business library
	
	
	/**
	 * This method will create a new Opportunity 
	 * @param opportunityName
	 */
	public void createNewOpportunity(String opportunityName)
	{
		opportunityNameEdt.sendKeys(opportunityName);
		saveBtn.click();
	}
	
	/**
	 * This method will create Opportunity with contacts and Campaign and select lead Source
	 * @param driver
	 * @param opportunityName
	 * @param lastname
	 * @param Related_to
	 */
	public void createNewOpportunity(WebDriver driver,String opportunityName, String lastname, String Campaignname, String Related_to, String LeadSource)
	{
		opportunityNameEdt.sendKeys(opportunityName);
		select(Related_to, relatedToDropdown);
		relatedToSelectImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(lastname);
		select("lastname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, lastname);
		switchToWindow(driver, "parenttab");
		select(LeadSource, leadSourceDropdown);
		campaignSourceSelectImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(Campaignname);
		select("campaignname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, Campaignname);
		switchToWindow(driver, "parenttab");
		saveBtn.click();
	}
	
	/**
	 * This method will create Opportunity with Organization and Campaign and select lead Source
	 * @param opportunityName
	 * @param driver
	 * @param OrgName
	 * @param Campaignname
	 * @param Related_to
	 */
	public void createNewOpportunity(String opportunityName, WebDriver driver, String OrgName, String Campaignname, String Related_to , String LeadSource)
	{
		opportunityNameEdt.sendKeys(opportunityName);
		select(Related_to, relatedToDropdown);
		relatedToSelectImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(OrgName);
		select("lastname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, OrgName);
		switchToWindow(driver, "parenttab");
		select(LeadSource, leadSourceDropdown);
		campaignSourceSelectImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(Campaignname);
		select("campaignname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, Campaignname);
		switchToWindow(driver, "parenttab");
		saveBtn.click();
	}
	
	/**
	 * This method will select campaign 
	 * @param driver
	 * @param Campaignname
	 */
	public void selectCampaignSourceByCampaignName(WebDriver driver, String Campaignname)
	{
		campaignSourceSelectImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(Campaignname);
		select("campaignname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, Campaignname);
		switchToWindow(driver, "parenttab");
	}
	
	
	
	
	
}
