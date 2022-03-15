package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class CreateContactsPage extends Webdriverutility
{
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(id = "email")
	private WebElement EmailEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrganizationNameImg;
	
	@FindBy(name = "search_text")
	private WebElement popupSearchEdt;
	
	@FindBy(name = "search_field")
	private WebElement popupDropdown;
	
	@FindBy(name = "search")
	private WebElement popupSearchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement LeadSourceDropdown;
	
	@FindBy(name = "emailoptout")
	private WebElement EmailOptOutCheckbox;
	
	@FindBy(name = "reference")
	private WebElement ReferenceCheckbox;
	
	@FindBy(name = "notify_owner")
	private WebElement NotifyOwnerCheckbox;
	
	@FindBy(name = "donotcall")
	private WebElement DoNotCallCheckbox;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::input[@src='themes/images/clear_field.gif']")
	private WebElement clearOrgimg;
	
	
	public WebElement getClearOrgimg() {
		return clearOrgimg;
	}

	public WebElement getLeadSourceDropdown() {
		return LeadSourceDropdown;
	}

	public WebElement getEmailOptOutCheckbox() {
		return EmailOptOutCheckbox;
	}

	public WebElement getReferenceCheckbox() {
		return ReferenceCheckbox;
	}

	public WebElement getNotifyOwnerCheckbox() {
		return NotifyOwnerCheckbox;
	}

	public WebElement getDoNotCallCheckbox() {
		return DoNotCallCheckbox;
	}

	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//getters

	public WebElement getSelectOrganizationNameImg() {
		return selectOrganizationNameImg;
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

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//  business library
	/**
	 * This method will create new Organization with mandatoryfields(LastName)
	 * @param Lastname
	 */
	public void createNewContact(String Lastname)
	{
		lastnameEdt.sendKeys(Lastname);
		saveBtn.click();
	}
	
	public void createNewContact(String Lastname, String emailid)
	{
		lastnameEdt.sendKeys(Lastname);
		EmailEdt.sendKeys(emailid);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with contact lastname and organization name   
	 * @param driver
	 * @param OrgName
	 */
	public void createNewContact(WebDriver driver ,String Lastname, String OrgName)
	{
		lastnameEdt.sendKeys(Lastname);
		selectOrganizationNameImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(OrgName);
		select("accountname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, OrgName);
		switchToWindow(driver, "parenttab");
		saveBtn.click();
	}
	
	/**
	 * This method will create contact with contact lastname and organization name and lead source
	 * @param driver
	 * @param Lastname
	 * @param Orgname
	 * @param leadSource
	 */
	public void createNewContact(WebDriver driver,String Lastname, String Orgname, String leadSource)
	{
		lastnameEdt.sendKeys(Lastname);
		selectOrganizationNameImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(Orgname);
		select("accountname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, Orgname);
		switchToWindow(driver, "parenttab");
		select(leadSource, LeadSourceDropdown);
		saveBtn.click();
		
	}
	
	/**
	 * This method will select Organization by clicking organization lookup Image
	 * @param driver
	 * @param Orgname
	 */
	public void clickOnSelectOrgAndclickOnOrgName(WebDriver driver, String Orgname)
	{
		selectOrganizationNameImg.click();
		switchToWindow(driver, "Popup");
		popupSearchEdt.sendKeys(Orgname);
		select("accountname", popupDropdown);
		popupSearchBtn.click();
		clickOnElementByLinktextValue(driver, Orgname);
		switchToWindow(driver, "parenttab");
	}
	
	
}
