package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.GenericLibrary.Webdriverutility;

public class EditProductPage extends Webdriverutility
{
	@FindBy(name = "productname")
	private WebElement ProductNameEdit;
	
	@FindBy(id = "jscal_field_sales_start_date")
	private WebElement  SalesStartDateEdt;
	
	@FindBy(id = "jscal_field_sales_end_date")
	private WebElement  SalesEndDateEdt;
	
	@FindBy(id = "vendor_part_no")
	private WebElement VendorPartNoEdt;
	
	@FindBy(id = "productsheet")
	private WebElement ProductSheetEdt;
	
	@FindBy(id = "product_no")
	private WebElement ProductNoEdt;
	
	@FindBy(id = "productcode")
	private WebElement PartNumberEdt;
	
	@FindBy(id = "jscal_field_start_date")
	private WebElement  SupportStartDateEdt;
	
	@FindBy(id = "jscal_field_expiry_date")
	private WebElement SupportExpiryDateEdt;
	
	@FindBy(name = "website")
	private WebElement WebsiteEdt;
	
	@FindBy(id = "mfr_part_no")
	private WebElement MfrPartNoEdt;
	
	@FindBy(id = "serial_no")
	private WebElement SerialNoEdt;
	
	@FindBy(name = "productcategory")
	private WebElement ProductCategoryDropdown;
	
	@FindBy(name = "manufacturer")
	private WebElement  ManufacturerDropdown;
	
	@FindBy(name = "glacct")
	private WebElement GLAccountDropdown;
	
	@FindBy(id = "search_txt")
	private WebElement PopupSearchEdt;
	
	@FindBy(name = "search_field")
	private WebElement popupDrodown;
	
	@FindBy(name = "search")
	private WebElement popupSearchNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	


	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorNameLockupImg;

	public EditProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductNameEdit() {
		return ProductNameEdit;
	}

	public WebElement getSalesStartDateEdt() {
		return SalesStartDateEdt;
	}

	public WebElement getSalesEndDateEdt() {
		return SalesEndDateEdt;
	}

	public WebElement getVendorPartNoEdt() {
		return VendorPartNoEdt;
	}

	public WebElement getProductSheetEdt() {
		return ProductSheetEdt;
	}

	public WebElement getProductNoEdt() {
		return ProductNoEdt;
	}

	public WebElement getPartNumberEdt() {
		return PartNumberEdt;
	}

	public WebElement getSupportStartDateEdt() {
		return SupportStartDateEdt;
	}

	public WebElement getSupportExpiryDateEdt() {
		return SupportExpiryDateEdt;
	}

	public WebElement getWebsiteEdt() {
		return WebsiteEdt;
	}

	public WebElement getMfrPartNoEdt() {
		return MfrPartNoEdt;
	}

	public WebElement getSerialNoEdt() {
		return SerialNoEdt;
	}

	public WebElement getProductCategoryDropdown() {
		return ProductCategoryDropdown;
	}

	public WebElement getManufacturerDropdown() {
		return ManufacturerDropdown;
	}

	public WebElement getGLAccountDropdown() {
		return GLAccountDropdown;
	}

	public WebElement getVendorNameLockupImg() {
		return VendorNameLockupImg;
	}
	public WebElement getPopupSearchEdt() {
		return PopupSearchEdt;
	}

	public WebElement getPopupDrodown() {
		return popupDrodown;
	}

	public WebElement getPopupSearchNowBtn() {
		return popupSearchNowBtn;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// business library
	
	public void editProduct(WebDriver driver, String productName, String Productnumber,String PartNumber
			,String Manufacturer,String ProductCategory, String salesStartDate, String salesEndDate, 
			String supportStartDate, String supportExpiryDate, String VendorNo, String Vendorname,
			String website, String ProductSheet, String MfrPartNo, String SerialNo)
	{
		ProductNameEdit.clear();
		ProductNameEdit.sendKeys(productName);
		passDataIntoDisabledTextfields(driver, "product_no", Productnumber);
		PartNumberEdt.sendKeys(PartNumber);
		select(Manufacturer, ManufacturerDropdown);
		select(ProductCategory, ProductCategoryDropdown);
		SalesStartDateEdt.sendKeys(salesStartDate);
		SalesEndDateEdt.sendKeys(salesEndDate);
		SupportStartDateEdt.sendKeys(supportStartDate);
		SupportExpiryDateEdt.sendKeys(supportExpiryDate);
		VendorPartNoEdt.sendKeys(VendorNo);
		VendorNameLockupImg.click();
		switchToWindow(driver, "popup");
		PopupSearchEdt.sendKeys(Vendorname);
		select("vendorname", popupDrodown);
		popupSearchNowBtn.click();
		clickOnElementByLinktextValue(driver, Vendorname);
		//driver.findElement(By.xpath("//a[.='"+Vendorname+"']")).click();
		switchToWindow(driver, "parenttab");
		WebsiteEdt.sendKeys(website);
		ProductSheetEdt.sendKeys(ProductSheet);
		MfrPartNoEdt.sendKeys(MfrPartNo);
		SerialNoEdt.sendKeys(SerialNo);
		select(GLAccountDropdown, 2);
		saveBtn.click();
			
	}

	
	
	
}
