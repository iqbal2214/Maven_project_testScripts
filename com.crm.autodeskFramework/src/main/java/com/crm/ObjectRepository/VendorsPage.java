package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createVendorsImg;
	
	public WebElement getCreateVendorsImg() {
		return createVendorsImg;
	}

}