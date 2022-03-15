package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// getters

	public WebElement getProductNameEdt() {
		return productNameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	// business library
	
	/**
	 * This method will create new Product
	 * @param ProductName
	 */
	public void createNewProduct(String ProductName)
	{
		productNameEdt.sendKeys(ProductName);
		savebtn.click();
	}
	
}
