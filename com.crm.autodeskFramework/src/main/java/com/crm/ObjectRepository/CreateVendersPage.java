package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendersPage {
	public CreateVendersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="vendorname")
	private WebElement vendorNameTextField;
	
	@FindBy(name="website")
	private WebElement websiteTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getVendorNameTextField() {
		return vendorNameTextField;
	}

	public WebElement getWebsiteTextField() {
		return websiteTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createVendorwithMandatoryFields(String vendorName) {
		getVendorNameTextField().sendKeys(vendorName);
		getSaveButton().click();
	}

}
