package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class CreateOrganizationPage extends Webdriverutility
{
	@FindBy(name = "accountname")
	private WebElement organaizationNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement TypeDropdown;
	

	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// getters

	public WebElement getOrganaizationNameEdt() {
		return organaizationNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	
	// business library
	
	/**
	 * This method will create new Organization with Organization name
	 * @param orgName
	 */
	public void createNewOrganization(String orgName)
	{
		organaizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create new Organization with organization and industry Type
	 * @param orgName
	 * @param IndType
	 */
	public void createNewOrganization(String orgName , String IndType)
	{
		organaizationNameEdt.sendKeys(orgName);
		select(IndType, industryDropdown);
		saveBtn.click();
	}
	
	/**
	 * This method will create new Organization with organization and industry Type and Type
	 * @param orgName
	 * @param IndType
	 * @param Type
	 */
	public void createNewOrganization(String orgName , String IndType, String Type)
	{
		organaizationNameEdt.sendKeys(orgName);
		select(IndType, industryDropdown);
		select(Type, TypeDropdown);
		saveBtn.click();
	}
}
