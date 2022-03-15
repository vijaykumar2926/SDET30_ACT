package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headertext;
	
	public OpportunityInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// getters

	public WebElement getHeadertext() {
		return headertext;
	}
	
	// business library
	/**
	 * this method will return opportunity info
	 * @return
	 */
	public String OpportunityNameInfo()
	{
		String Header = headertext.getText();
		return Header;
	}
}
