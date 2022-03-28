package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//Initialization of WebElements 
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of web elements
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOraganizationimage;

	public WebElement getCreateOraganizationimage() {
		return createOraganizationimage;
	}
	
	public void clickOnCreateOrganizationImage() {
		createOraganizationimage.click();
	}
}
