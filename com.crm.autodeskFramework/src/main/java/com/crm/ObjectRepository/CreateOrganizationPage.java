package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.com.autodesk.generic.utility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
public CreateOrganizationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

	@FindBy(name="accountname")
	private WebElement OrganizationNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getAccountNameTextField() {
		return OrganizationNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void selectIndustry(String industryName) {
		selectFromList(industryDropDown, industryName);
	}
	
	public void provideOrganizationNameInTextField(String OrganizationName) {
		OrganizationNameTextField.sendKeys(OrganizationName);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

}
