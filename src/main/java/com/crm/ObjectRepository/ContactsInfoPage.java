package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(id = "dtlview_Email Opt Out")
	private WebElement EmailOptOut;

	@FindBy(id = "dtlview_Reference")
	private WebElement Reference;
	
	@FindBy(id = "dtlview_Notify Owner")
	private WebElement NotifyOwner;
	
	@FindBy(id = "dtlview_Do Not Call")
	private WebElement DoNotCall;
	
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// getters

	public WebElement getHeaderText() {
		return headerText;
	}
	public WebElement getEmailOptOut() {
		return EmailOptOut;
	}

	public WebElement getReference() {
		return Reference;
	}

	public WebElement getNotifyOwner() {
		return NotifyOwner;
	}

	public WebElement getDoNotCall() {
		return DoNotCall;
	}
	
	// business library
	
	/**
	 * This method will Return the contact title 
	 * @return
	 */
	public String contactNameInfo()
	{
		String header = headerText.getText();
		return header;
	}
	
	/**
	 * This method will return EmailOptOut Status
	 * @return
	 */
	public String EmailOptOut() 
	{
		String text = EmailOptOut.getText();
		return text;
	}
	
	/**
	 * This method will return Reference Status
	 * @return
	 */
	public String Reference() 
	{
		String text = Reference.getText();
		return text;
	}
	
	/**
	 * This method will return NotifyOwner Status
	 * @return
	 */
	public String NotifyOwner() 
	{
		String text = NotifyOwner.getText();
		return text;
	}
	
	/**
	 * This method will return DoNotCall Status
	 * @return
	 */
	public String DoNotCall() 
	{
		String text = DoNotCall.getText();
		return text;
	}
	
}
