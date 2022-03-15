package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headertext;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// getters

	public WebElement getHeadertext() {
		return headertext;
	}
	
	// business library
	
	/**
	 * This method will return Product Info
	 * @return
	 */
	public String productNameInfo()
	{
		String Header = headertext.getText();
		return Header;
	}
}
