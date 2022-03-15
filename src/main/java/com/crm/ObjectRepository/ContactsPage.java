package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookupImg;
	
	@FindBy(xpath = "//img[@src='themes/images/end.gif']")
	private WebElement LastBtn;
	
	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement SendMailBtn;
	
	@FindAll({@FindBy(xpath = "(//input[@name='pagenum']/..//img)[3]"),
			@FindBy(xpath = "//img[@src='themes/images/next.gif']")})
	private WebElement nextBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteBtn;
	
	public WebElement getSendMailBtn() {
		return SendMailBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getSelectBtn() {
		return selectBtn;
	}

	@FindBy(name = "Select")
	private WebElement selectBtn;
	
	public WebElement getLastBtn() {
		return LastBtn;
	}

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// getters

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}
	
	// business library
	
	/**
	 * This method will click on create contacts Image
	 */
	public void clickOnCreateContactsLink() 
	{
		createOrgLookupImg.click();
	}
	
	/**
	 * This Method will click on Contacts By contact LastName
	 * @param driver
	 * @param Lastname
	 */
	public void selectContact(WebDriver driver, String Lastname)
	{
		driver.findElement(By.xpath("//a[.='"+Lastname+"']/../../td/input[@type='checkbox']")).click();
	}
	
	
	/**
	 * This method will search for a contact from 1st page to last page and click the contact
	 * @param driver
	 * @param lastname
	 */
	public void clickOnElement(WebDriver driver, String lastname)
	{
		boolean flag = true;
		while(flag)
		{
			try {
				
				boolean ele = driver.findElement(By.xpath("//a[.='"+lastname+"']")).isDisplayed();
				if(ele)
				{
					driver.findElement(By.xpath("//a[.='"+lastname+"']")).click();
					flag = false;
				}

			} catch (RuntimeException e) 
			{
				nextBtn.click();
			}
			
		}
	}
	
	
}
