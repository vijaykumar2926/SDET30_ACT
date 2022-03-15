package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class HomePage extends Webdriverutility
{
	@FindBy(linkText = "Organizations")
	private WebElement organizationlnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitieslnk;
	
	@FindBy(linkText = "Products")
	private WebElement productslnk;
	
	@FindBy(linkText = "More")
	private WebElement morelnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlnk;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLnk;
	
	
	// initialization - use constructor

	
	public WebElement getVendorsLnk() {
		return vendorsLnk;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// generate getters

	public WebElement getOrganizationlnk() {
		return organizationlnk;
	}

	public WebElement getContactslnk() {
		return contactslnk;
	}

	public WebElement getOpportunitieslnk() {
		return opportunitieslnk;
	}

	public WebElement getProductslnk() {
		return productslnk;
	}

	public WebElement getMorelnk() {
		return morelnk;
	}

	public WebElement getCampaignslnk() {
		return campaignslnk;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}
	

	
	// business library
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationlnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactLink()
	{
		contactslnk.click();
	}
	
	/**
	 * This method will click on products link
	 */
	public void clickOnProductslink()
	{
		productslnk.click();
	}
	
	/**
	 * This method will click on campaigns link
	 */
	public void clickOnCampaignslink()
	{
		campaignslnk.click();
	}
	
	/**
	 * This method will click on More link
	 */
	public void clickOnMoreLink()
	{
		morelnk.click();
	}
	
	/**
	 * This method will click on Opportunities link
	 */
	public void clickOpportunitieslink()
	{
		opportunitieslnk.click();
	}
	
	/**
	 * This method will click on Vendors link
	 */
	public void clickOnVendorLink()
	{
		vendorsLnk.click();
	}
	
	/**
	 * This method will Logout of the Application
	 * @param driver
	 */
	public void logoutOfApplication(WebDriver driver)
	{
		mouseHover(driver, administratorimg);
		signoutlnk.click();
	}
}
