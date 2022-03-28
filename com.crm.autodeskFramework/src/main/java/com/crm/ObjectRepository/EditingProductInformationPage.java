package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class EditingProductInformationPage extends WebDriverUtility{
public EditingProductInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@name='productname']")
private WebElement productNameTextField;

@FindBy(xpath="//input[@id='product_no']")
private WebElement productNoTextField;

@FindBy(xpath="//td[@class='dvtCellInfo' and @align='left']/descendant::input[@type='checkbox']")
private WebElement productActiveCheckBox;

@FindBy(xpath="//input[@id='productcode']")
private WebElement partNumberTextField;

@FindBy(xpath="//input[@name='sales_start_date']")
private WebElement salesStartDateTextField;

@FindBy(name="manufacturer")
private WebElement manufacturerDropDown;

@FindBy(name="productcategory")
private WebElement productCatagoryDropDown;

@FindBy(id="jscal_field_start_date")
private WebElement supportStartDateTextField;

@FindBy(id="jscal_field_expiry_date")
private WebElement supportExpiryDateTextField;

@FindBy(name="sales_end_date")
private WebElement salesEndDateTextField;

@FindBy(id="vendor_part_no")
private WebElement vendorPartNoTextField;

@FindBy(xpath="//img[@title='Select']")
private WebElement selectVendorNameImage;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

@FindBy(name="productsheet")
private WebElement productSheetTextField;

@FindBy(name="mfr_part_no")
private WebElement mfrPartNoTextField;

@FindBy(name="serial_no")
private WebElement serialNoTextField;

@FindBy(name="website")
private WebElement websiteTextField;


public WebElement getWebsiteTextField() {
	return websiteTextField;
}

public WebElement getProductSheetTextField() {
	return productSheetTextField;
}

public WebElement getMfrPartNoTextField() {
	return mfrPartNoTextField;
}

public WebElement getSerialNoTextField() {
	return serialNoTextField;
}

public WebElement getProductNameTextField() {
	return productNameTextField;
}

public WebElement getProductNoTextField() {
	return productNoTextField;
}

public WebElement getProductActiveCheckBox() {
	return productActiveCheckBox;
}

public WebElement getPartNumberTextField() {
	return partNumberTextField;
}

public WebElement getSalesStartDateInputField() {
	return salesStartDateTextField;
}


public WebElement getManufacturerDropDown() {
	return manufacturerDropDown;
}

public WebElement getProductCatagoryDropDown() {
	return productCatagoryDropDown;
}

public WebElement getSupportStartDateTextField() {
	return supportStartDateTextField;
}

public WebElement getSupportExpiryDateTextField() {
	return supportExpiryDateTextField;
}

public WebElement getSalesEndDateTextField() {
	return salesEndDateTextField;
}

public WebElement getVendorPartNoTextField() {
	return vendorPartNoTextField;
}

public WebElement getSelectVendorNameImage() {
	return selectVendorNameImage;
}

public WebElement getSaveButton() {
	return saveButton;
}

public void enterAllInputFieldsOfProductInformation(String productName,String productNum,String partNum,String vendorPartNum,String mfrNum,String productSheet, String serialNum) {
	productNameTextField.clear();
	productNameTextField.sendKeys(productName);
	productNoTextField.sendKeys(productNum);
	partNumberTextField.sendKeys(partNum);
	vendorPartNoTextField.sendKeys(vendorPartNum);
	mfrPartNoTextField.sendKeys(mfrNum);
	productSheetTextField.sendKeys(productSheet);
	serialNoTextField.sendKeys(serialNum);
}

public void enterAllDates(String salesStartDate,String salesEndDate,String supportStartDate,String supporEndDate) {
	salesStartDateTextField.sendKeys(salesStartDate);
	salesEndDateTextField.sendKeys(salesEndDate);
	supportStartDateTextField.sendKeys(supportStartDate);
	supportExpiryDateTextField.sendKeys(supporEndDate);	
}
public void selectAllDropdownOfProductInformation(String nameToSelectProductCatagory, String nameToSelectManufacturer) {
	selectFromList(productCatagoryDropDown, nameToSelectProductCatagory);
	//selectFromList(manufacturerDropDown, nameToSelectManufacturer);	
}
public void clickOnSaveButton() {
	saveButton.click();
}

public void clickOnSelectVendorImg() {
	selectVendorNameImage.click();
}

}
