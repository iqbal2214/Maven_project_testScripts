package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
public CreateContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

@FindBy(name="firstname")
private WebElement firstNameTextField;

@FindBy(name="lastname")
private WebElement lastNameTextField;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement selectOrganizationImage;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

public WebElement getFirstNameTextField() {
	return firstNameTextField;
}

public WebElement getLastNameTextField() {
	return lastNameTextField;
}

public WebElement getSelectOrganizationImage() {
	return selectOrganizationImage;
}

public WebElement getSaveButton() {
	return saveButton;
}

public void provideFirstName(String firstName) {
	firstNameTextField.sendKeys(firstName);
}

public void provideLastName(String lastName) {
	lastNameTextField.sendKeys(lastName);
}

public void clickonSelectOrganizationImage() {
	selectOrganizationImage.click();
}

public void clickOnSaveButton() {
	saveButton.click();
}

}
