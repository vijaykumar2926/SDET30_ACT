package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.Webdriverutility;

public class ProductsPage extends Webdriverutility
{
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProductImg;
	
	@FindBy(name = "search_text")
	private WebElement searchForEdt;
	
	@FindBy(id = "bas_searchfield")
	private WebElement productDropDown;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	@FindBy(xpath = "//img[@src='themes/images/end.gif]")
	private WebElement lastBtn;
		

	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//  generate getters

	public WebElement getCreateProductBtn() {
		return createProductImg;
	}


	public WebElement getSearchForEdt() {
		return searchForEdt;
	}


	public WebElement getProductDropDown() {
		return productDropDown;
	}

	public WebElement getSearchbtn() {
		return searchNowBtn;
	}
	
	public WebElement getCreateProductImg() {
		return createProductImg;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getLastBtn() {
		return lastBtn;
	}
	
	// business library
	
	/**
	 * This method will click on createProduct Image	
	 */
	public void clickOnCreateProductImg()
	{
		createProductImg.click();
	}
	
	/**
	 * This method will search for product in by Product name
	 * @param productname
	 */
	public void searchForProduct(String productname)
	{
		searchForEdt.sendKeys(productname);
		select("productname", productDropDown);
		searchNowBtn.click();
	}
	
	/**
	 * This method will click on Edit button Based On product name
	 * @param driver
	 * @param Productname
	 */
	public void clickOnEditbtn(WebDriver driver , String Productname)
	{
		driver.findElement(By.xpath("//a[.='"+Productname+"']/../..//a[.='edit']")).click();
	}
	
	
}
